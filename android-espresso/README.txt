Requirement: Android SDK installed

This file provides instructions on how to run demos of Android
Espresso.  Each directory contains a different Android app with
Android espresso tests.  All samples use the Gradle build system.

1. Call "android avd" and start the AVD that will run the app and
execute the tests.  If you don't know exactly which AVD you should
spawn, skip this step and follow on.  The error messages you will see
will provide you hints on how to configure your environment.

2. Use the command "./gradlew connectedAndroidTest" to run the tests on
a connected emulator or device.  This gradle task should do all the
assembling of the ".apk" file, installation, and execution of tests.

  ERROR "SDK missing": If you observe the message "A problem occurred
     configuring project ':app'. > failed to find target with hash
     string 'android-24'", then.. Open the Android SDK Manager (call
     "android" from the command line) and install the correspondoing
     SDK version.  In this case, SDK 24.

  ERROR "SDK Build Tools missing": If you observe the message "A
    problem occurred configuring project ':app'.  > failed to find
    Build Tools revision 24.0.1", the install corresponding build
    tools from the SDK Manager (call "android" from the command line)

  ERROR "No connected device": If you observe the message "Execution
   failed for task ':app:connectedDebugAndroidTest'.>
   com.android.builder.testing.api.DeviceException: No connected
   devices!", it means no AVD is running.  Open the Android AVD
   Manager (call "android avd" from the command line) and check if
   there is a virtual device that the app can run with.  If a device
   exists, then start the device.  If a device is missing, create one.
   To decide which version to use for your AVD, please check
   requirements on file "build.gradle".  When you start the AVD,
   please make sure you wait until the start screen shows up.

Now that you can run these espresso tests, please check corresponding
code under "app/src/androidTest/".
