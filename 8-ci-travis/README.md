**building/compiling code**
  
  1. gradlew build
  
**running tests**
  
  2. gradle test

**reporting dependencies**
  
  3. gradle dependencies

>filtering output

  4. gradle dependencies --configuration testCompileClasspath
  5. gradle dependencyInsight --configuration testCompileClasspath --dependency junit

**generating wrapper files**

  6. gradle wrapper
