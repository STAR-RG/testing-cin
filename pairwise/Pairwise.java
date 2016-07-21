import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Pairwise {
  
  Set<Requirement> requirements;
  Set<Requirement> satisfiedRequirements = new HashSet<Requirement>();
  
  /************** compute requirements **************/
  static class Requirement {
    // A requirement pair consists of variable 
    // index_1 with value val_1 AND variable 
    // index_2 with val_2.
    int index_1; int val_1;
    int index_2; int val_2;
    Requirement(int index_1, int val_1, int index_2, int val_2) {
      this.index_1 = index_1;
      this.val_1 = val_1;
      this.index_2 = index_2;
      this.val_2 = val_2;
    }
    @Override
    public String toString() {
      return String.format("(%d,%d)-(%d,%d)", index_1, val_1, index_2, val_2);
    }
    /** this is important... using hash sets. **/
    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      Requirement tmp = (Requirement) obj;
      return (index_1 == tmp.index_1 && val_1 == tmp.val_1 && index_2 == tmp.index_2 && val_2 == tmp.val_2);
    }
    @Override
    public int hashCode() { 
      //TODO: this is a horrible/slow hashcode function.  assuming efficiency is not critical.
      return (index_1+""+ val_1+ index_2+ val_2).hashCode();
    }
  }

  static class VarAssignment {
    int var; int val;
    VarAssignment(int var, int val) {
      this.var = var;
      this.val = val;
    }
    @Override
    public String toString() {
      return String.format("(%d,%d)", var, val);
    }
  }
  
  static class VarDomains {
    int[] lo;
    int[] hi;

    VarDomains(int[] lo, int[] hi) {
      this.lo = lo;
      this.hi = hi;
    }
    
  }

  void computeRequirements(VarDomains problem) {
    Set<Requirement> result = new HashSet<Requirement>();
    // computing all var-vals
    List<VarAssignment> allVarVals = new ArrayList<VarAssignment>();
    for (int var = 0; var < problem.lo.length; var++) {
      // iterating through variable var
      for (int val = problem.lo[var]; val <= problem.hi[var]; val++) {
        allVarVals.add(new VarAssignment(var, val));
      }
    }
    // computing all pairs ((x,a),(y,b)) for x!=y
    for (int var1 = 0; var1 < allVarVals.size(); var1++) {
      VarAssignment vv1 = allVarVals.get(var1);
      for (int var2 = 0; var2 < allVarVals.size(); var2++) {
        VarAssignment vv2 = allVarVals.get(var2);
        /**
         * don't want pairs involving the same variables => (vv1.var == vv2.var)
         * don't want duplicated pairs => (vv1.var > vv2.var) 
         */
        if (vv1.var >= vv2.var) continue;
        result.add(new Requirement(vv1.var, vv1.val, vv2.var, vv2.val));
      }
    }
    requirements = result;
  }
  
  /************** update test suite **************/
  void addTest(List<VarAssignment> testInput, boolean debug) {
    satisfiedRequirements.addAll(listReqs(testInput, debug));
  }
  
  List<Requirement> listReqs(List<VarAssignment> testInput, boolean debug) {
    List<Requirement> res = new ArrayList<Requirement>();
    for (int i = 0; i < testInput.size(); i++) {
      VarAssignment vv1 = testInput.get(i);
      for (int j = i+1; j < testInput.size(); j++) {
        VarAssignment vv2 = testInput.get(j);
        Requirement req = new Requirement(vv1.var, vv1.val, vv2.var, vv2.val);
        if (debug) System.out.println(req);
        res.add(req);
      } 
    }
    return res; /* number of new requirements in this test input */
  }
  
  /************** check if test helps improve coverage **************/
  boolean check(List<VarAssignment> testInput, boolean debug) {
    return listReqs(testInput, debug).size() > 0; 
  }

  /************** coverage ****************/
  double coverage() {
    return 100*((double)satisfiedRequirements.size())/requirements.size();
  }
  
  /**
   * Intent of this main function is to document/explain.
   * 
   */
  public static void main(String[] args) {
    Pairwise p = new Pairwise();
    
    // Consider a problem with 3 variables, with the following numeric domains:
    // x: [0,1] -- boolean
    // y: [0,2]
    // z: [0,3]
    p.computeRequirements(new VarDomains(new int[]{0, 0, 0}, new int[]{1, 2, 3}));
    
    // There are 26 pairs (= 2x3 + 2x4 + 3x4).  They are:
    // (x=0, y=0) (x=0, y=1) (x=0, y=2)
    // (x=1, y=0) (x=1, y=1) (x=1, y=2) 
    // -- (2 x 3) part
    // (x=0, z=0) (x=0, z=1) (x=0, z=2) (x=0, z=3) 
    // (x=1, z=0) (x=1, z=1) (x=1, z=2) (x=1, z=3)
    // -- (2 x 4) part
    // (y=0, z=0) (y=0, z=1) (y=0, z=2) (y=0, z=3)
    // (y=1, z=0) (y=1, z=1) (y=1, z=2) (y=1, z=3)
    // (y=2, z=0) (y=2, z=1) (y=2, z=2) (y=2, z=3)
    // -- (3 x 4) part
    System.out.printf("%d ...should be %d\n", p.requirements.size(), 26);
    
    // Build a test case (to check how many requirements/pairs it satisfies).
    // Test case is for (x=0, y=1, z=1)
    VarAssignment a1 = new VarAssignment(0, 0);
    VarAssignment a2 = new VarAssignment(1, 1);
    VarAssignment a3 = new VarAssignment(2, 1);
    List<VarAssignment> test = new ArrayList<VarAssignment>();
    test.add(a1);
    test.add(a2);
    test.add(a3);
    // This test case should satisfy 3 requirements (/pairs).
    // The requirements are: (x=0, y=1) (x=0, z=1) (y=1, z=1)    
    p.addTest(test, true/*debug*/);
    System.out.printf("%d ...should be %d\n", p.satisfiedRequirements.size(), 3);
    
    // compute coverage.
    System.out.printf("coverage = %.2f%% ...should be %.2f\n", p.coverage(), 11.54f);
    
    // create another test (x=0, y=2, z=1)
    VarAssignment a4 = new VarAssignment(0, 0);
    VarAssignment a5 = new VarAssignment(1, 2);
    VarAssignment a6 = new VarAssignment(2, 1);
    test = new ArrayList<VarAssignment>();
    test.add(a4);
    test.add(a5);
    test.add(a6);
    if (p.check(test, false)) {
      // should enter here as there are two new pairs: (x=0, y=2) and (y=2, z=1)
      p.addTest(test, true/*debug*/);
      System.out.printf("coverage %.2f%% ...should be %.2f\n", p.coverage(), 19.23f /* =5/26*/); 
    }
  }

}