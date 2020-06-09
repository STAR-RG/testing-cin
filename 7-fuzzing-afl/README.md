1. clone afl repository
```
$> git clone https://github.com/google/AFL.git
```

2. build AFL # runs very quickly
```
 $> sudo make install
```

3. clone repo of program with vulnerability and build it

```
 $> git clone https://github.com/fuzzstati0n/fuzzgoat.git
```

 Obs. read AFL/README.md if you want to run AFL on different programs

4. cd to fuzzgoat dir
```
 $> cd fuzzgoat
``` 
5. build fuzzgoat
```
 $> make
```
6. modify system properties (for speed and clean crash reports)

```
 $> sudo su -
 $root> echo core >/proc/sys/kernel/core_pattern
 $root> cd /sys/devices/system/cpu
 $root> echo performance | tee cpu*/cpufreq/scaling_governor
```

7. run afl
```
 $> afl-fuzz -i in -o out ./fuzzgoat @@
```
===
Further reading:
  https://fuzzing-project.org/
  https://www.fuzzingbook.org/