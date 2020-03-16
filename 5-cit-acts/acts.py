import subprocess
import sys

if __name__ == "__main__":
    variables = sys.argv[1]
    
    ## read template of input file for ACTS
    with open('template.txt','r') as f:
        template = f.read()

    # read variables ----------> assuming variables are ordered from 1 to number of lines)
    filename = "input.txt"
    vars = {}
    with open(filename, "w+") as file:
        file.write(template)
        cnt = 1
        with open(variables,'r') as f:
            while True:
                line = f.readline().strip()
                if not line:
                    break
                vars[line] = cnt
                file.write("{} (boolean): TRUE, FALSE\n".format(line))
                cnt += 1

    # invoke acts on inputs.txt. it generates file output.txt
    subprocess.run(["java", "-jar", "acts_3.1.jar", "input.txt"])
    
    filename = "output.txt"
    confs=[]
    with open(filename, "r") as file:
        lines = file.readlines()
        conf = set()
        for line in lines:
            if not line.strip():
                continue
            if line.startswith("#"):
                continue
            elif line.startswith("Configuration"):
                conf = set()
            elif line.startswith("-----"):
                if conf:
                    confs.append(conf)
            else:
                parts=line.split()
                keyval=parts[2]
                keyval_parts=keyval.split("=")
                print("{} --> {}".format(keyval_parts[0],keyval_parts[1]))
                key=keyval_parts[0]
                val=keyval_parts[1]
                key_index=vars[key]
                if (val == "TRUE"):
                    conf.add(int(key_index))
                else:
                    conf.add(int("-"+str(key_index)))

    filename = "output_formatted.txt"
    with open(filename, "w+") as file:
        for conf in confs:
            sample_str = [str(a) for a in conf]
            to_write = ','.join(sample_str)
            file.write(to_write)
            file.write("\n")