------------------------------------------------------------------------

<div align="center">
<img align="center" alt="CI" height="25" src="https://github.com/kranberry-io/kranberry/actions/workflows/build-actions.yml/badge.svg?style=plastic">
<img align="center" alt="CONTRIBUTORS" height="26" src="https://img.shields.io/github/contributors/kranberry-io/kranberry.svg?style=plastic&color=orange">
<img align="center" alt="Stargazers" height="26" src="https://img.shields.io/github/stars/kranberry-io/kranberry.svg?style=plastic&color=blueviolet">
<img align="center" alt="Issues" height="26" src="https://img.shields.io/github/issues/kranberry-io/kranberry.svg?style=plastic">
<img align="center" alt="License" height="26" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=plastic)](https://opensource.org/licenses/Apache-2.0">
<img align="center" alt="Forks" height="26" src="https://img.shields.io/github/forks/kranberry-io/kranberry.svg?style=plastic&color=orange">
<img align="center" alt="Last Commit" height="26" src="https://img.shields.io/github/last-commit/kranberry-io/kranberry?style=plastic">
<img align="center" alt="Release Date" height="26" src="https://img.shields.io/github/release-date/kranberry-io/kranberry?style=plastic">
<img align="center" alt="Visitors" height="26" src="https://visitor-badge-reloaded.herokuapp.com/badge?page_id=kranberry-io.kranberry&color=00cf00">
</div>

------------------------------------------------------------------------
![](README/kranberry1.png)
------------------------------------------------------------------------
1. [About Kranberry](#about-kranberry)
2. [Getting Started](#getting-started)
    - [Setup Kranberry Dependency](#setup-kranberry-dependency)
    - [Run Tests Using Makefile](#run-tests-using-makefile)
    - [Run Tests Using Kranberry Gradle Plugin](#run-tests-using-kranberry-gradle-plugin)
3. [Kranberry Properties File](#kranberry-properties-file)
4. [Roadmap](#roadmap)
5. [Contributing](#contributing)
6. [Templates](#templates)
    - [Kranberry Properties](#kranberry-properties)
    - [Android Test Manifest](#android-test-manifest)
    - [App class](#app-class)
    - [Home class](#home-class)
    - [Test class](#test-class)
    - [Makefile](#makefile)
7. [License](#license)
------------------------------------------------------------------------
# About Kranberry

Maintaining Android Mobile UI test codes, which are already structured, is relatively easier than starting them from scratch.

Building/adapting an architecture, defining libraries and their compatibilities ends up consuming precious time when we need to build end-to-end functional tests (E2E).

To get around this issue, we developed an Open-source library in order to facilitate the integration of native UI tests for Android in Kotlin, which aims to reduce the time and complexity of initial configuration of these test modules.

Our goal is to provide resources so you can start a test package quickly, while we provide you with settings and features you won't waste time worrying about!

------------------------------------------------------------------------
# Getting Started

> Note that the library is experimental, and the API is subject to change.

The library is published to [Maven Central](https://mvnrepository.com/artifact/io.github.kranberry-io/kranberry).

To use the Kranberry library, follow the steps:
* [Setup Kranberry Dependency](#setup-kranberry-dependency)
* [Run Tests Using Makefile](#run-tests-using-makefile)
* [Run Tests Using Kranberry Gradle Plugin](#run-tests-using-kranberry-gradle-plugin)

## Setup Kranberry Dependency

Add the [Maven Central](https://mvnrepository.com/artifact/io.github.kranberry-io/kranberry) repository in the **root/build.gradle** file if it is not already there:

```groovy
        maven {
            url "https://plugins.gradle.org/m2/"
        }
```

1. [Add the Kranberry dependency](https://github.com/kranberry-io/kranberry-sample/commit/108de28c0d0c7c527187beb9a1b4662605ccbbac#diff-51a0b488f963eb0be6c6599bf5df497313877cf5bdff3950807373912ac1cdc9) to your `module/build.gradle` file inside the package that will be tested (not the build.gradle file in the project root):

```groovy
// Kranberry
androidTestImplementation 'io.github.kranberry-io:kranberry:1.0.1-beta'
```

2. [Add a `kranberry.properties.json`](https://github.com/kranberry-io/kranberry-sample/commit/3bf5302643c7fdbfebe108149c1b7e7a6585d629) file in the path `module/src/androidTest/assets`. If the folder does not exist, you must create it. [💡 See the template](#kranberry-properties)

3. [Add an `AndroidManifest.xml`](https://github.com/kranberry-io/kranberry-sample/commit/ba3c973de8924c875ac8d87d897833c5802a18f0) file in the path `module/src/androidTest`. If the folder does not exist, you must create it. [💡 See the template](#android-test-manifest)

4. [Add an `App.kt` class](https://github.com/kranberry-io/kranberry-sample/commit/31a50136acef58b0146dd70d114e3c18597e7cf4) in the path `module/src/androidTest/java/feature`. If the folder does not exist, you must create it. This step will serve to implement the method that will open your app. [💡 See the template](#app-class)

5. [Add a `Home.kt` class](https://github.com/kranberry-io/kranberry-sample/commit/3aec77f09476101d1b9310d65f6b747ee5c5eac7) in the path `module/src/androidTest/java/feature`. If the folder does not exist, you must create it. This step will serve to implement navigation steps and assertions.   [💡 See the template](#home-class)

6. [Add a test using the pre-implemented App and Home features](https://github.com/kranberry-io/kranberry-sample/commit/3fa55bdbd598f6131c2cd4875dee5d58ef33200b). If the folder does not exist, you must create it. This step will serve to implement navigation steps and assertions.   [💡 See the template](#test-class)

7. [Add the `/kranberry-outputs/` information](https://github.com/kranberry-io/kranberry-sample/commit/ab368088d38574818725b4c284744b3552f201aa) to your `root/gitignore` file. This will prevent you from publishing test outputs in your repository.

```groovy
/kranberry-outputs/
/app/kranberry-outputs/
```

## Run Tests Using Makefile

8. If you want to run your tests in a customized way, [you can include a Makefile](https://github.com/kranberry-io/kranberry-sample/commit/1525eb53495fdc1917048394fb1ea1fe6eb56427) , modifying the execution tasks with desired parameters.  [💡 See the template](#makefile)

🥳 🎉 Voilà! Now you can run your first test from the terminal command line:

<div align="center">
<img align="center" alt="Run-Tests-Gif" src="https://github.com/kranberry-io/kranberry/blob/master/README/test-execution-kranberry.gif">
</div>

> Note that there is a previously opened emulator to run the tests.

## Run Tests Using Kranberry Gradle Plugin

<span style="color:red">*🛠 This feature is under construction! But you can use the current version which doesn't have the output printing in the terminal console yet.*</span>.

9. Now you can also use the gradle plugin to run the tests from the `./gradlew runKranberryTests` command. [To do this include the settings in the `build.gradle` and `module:build.gradle` files](https://github.com/kranberry-io/kranberry-sample/commit/15b84f2bc72f378f7e1fff22f230352770b2826e) :

> build.gradle

```kotlin
buildscript {
    ext.kotlin_version = '1.4.10'
    ext.kranberry_version = '1.0.1-beta'
    repositories {
        google()
        jcenter()
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:4.1.0'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "io.github.kranberry-io:runtests:1.0.1-beta"
```

> module/build.gradle

```kotlin
apply plugin: "io.github.kranberry-io.runtests"

kranberryTests {
    packageName = "io.kranberry.sample"
    packageTests = "io.kranberry.sample.test"
    apkOutputPath = "build/outputs/apk/debug/app-debug.apk"
    androidTestApkOutputPath = "build/outputs/apk/androidTest/debug/app-debug-androidTest.apk"
    testsRunner = "androidx.test.runner.AndroidJUnitRunner"
}
```
------------------------------------------------------------------------
# Kranberry Properties File

This is the configuration file used by the library to configure the values that will be used to set the test environment.
The file must be located in the `src/androidTest/assets` directory with name `kranberry.properties.json`.
Below you will find more details about the parameters that can be used:

* [Properties table](#properties-table)
* [Example of properties file](#example-of-properties-file)

## Properties table

| Parameter                              	| Description                                                                                                                                                                                    	|     Type     	| Obligatory 	|        Default Value        	|
|----------------------------------------	|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|:------------:	|:----------:	|:---------------------------:	|
| app_packages                           	| Packages of the applications that will be tested. The first package in the list will be referenced by the Kranberry constant `APP_PACKAGE`. The others will be used for permission management. 	| List<String> 	|     Yes    	|     io.kranberry.sample     	|
| clear_application _data_before_testing 	| Defines whether the application data defined in the `app_packages` parameter list will be cleared before running the tests.                                                                    	|   Boolean   	|     No    	| FALSE                       	|
| default_timeout                        	| Default implicit timeout for interaction with UI elements in milliseconds.                                                                                                                     	|     Long     	|     No     	|            60000            	|
| disable_animations                     	| Defines whether animations will be disabled during instrumentation tests. The goal is to increase test performance.                                                                            	|   Boolean   	|     No     	| TRUE                        	|
| max_search_swipes                      	| Sets the maximum scroll down/up will be performed when fetching an element using the methods of the `io.kranberry.ui.Swipe` class.                                                             	|      Int     	|     No     	|                             	|
| page_load_timeout                      	| Defines the maximum implicit wait time for the element set in the `progressbar_class` property. This is used in Kranberry's `waitForPageLoad()` method.                                        	|     Long     	|     No     	| 30000                       	|
| permissions_granted _to_device         	| Defines the list of permissions that will be granted to app packages set in the `app_packages ` property.                                                                                      	| List<String> 	|     No     	|     ACCESS_FINE_LOCATION    	|
| print_colored_logs                     	| Defines if the terminal logs will be printed colored.                                                                                                                                          	|   Boolean   	|     No     	| TRUE                        	|
| progressbar_class                      	| Defines the progress bar class that will be implicitly expected. This is used in Kranberry's `waitForPageLoad()` method.                                                                       	| List<String> 	|     No     	| android.widget .ProgressBar 	|
| skip_chrome_welcome _screen            	| Defines whether the application data defined in the `app_packages` parameter list will be cleared before running the tests.                                                                    	|    Boolean   	|     No     	| TRUE                        	|
| swipe_down_params                      	| Defines the list of parameters that will be used in method swipeDown(). These being in order: `SWIPE_DOWN_START_X, SWIPE_DOWN_START_Y, SWIPE_DOWN_END_X, SWIPE_DOWN_END_Y, SWIPE_DOWN_STEPS`   	|  List<Long>  	|     No     	|                             	|
| swipe_up_params                        	| Defines the list of parameters that will be used in method swipeUp(). These being in order: `SWIPE_UP_START_X, SWIPE_UP_START_Y, SWIPE_UP_END_X, SWIPE_UP_END_Y, SWIPE_UP_STEPS`               	|  List<Long>  	|     No     	|                             	|

## Example of properties file

```json
{
  "default_timeout": 60000,
  "clear_application_data_before_testing": true,
  "skip_chrome_welcome_screen": true,
  "page_load_timeout": 30000,
  "disable_animations": true,
  "app_packages": [
    "com.android.chrome"
  ],
  "permissions_granted_to_device": [
    "ACCESS_FINE_LOCATION",
    "WRITE_EXTERNAL_STORAGE",
    "READ_EXTERNAL_STORAGE",
    "READ_CONTACTS",
    "CAMERA"
  ],
  "progressbar_class": [
    "android.widget.ProgressBar"
  ]
}
```

------------------------------------------------------------------------
# Roadmap

<div align="center">
<img align="center" alt="ISSUES-OPEN" height="26" src="https://img.shields.io/github/issues/kranberry-io/kranberry.svg?style=plastic&color=red">
<img align="center" alt="CLOSED" height="25" src="https://img.shields.io/github/issues-closed/kranberry-io/kranberry?style=plastic&color=green">
</div>

See the [open issues](https://github.com/kranberry-io/kranberry/labels/feature) for a list of proposed features (and known issues).

------------------------------------------------------------------------
# Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


------------------------------------------------------------------------
# Templates

* [Kranberry Properties](#kranberry-properties)
* [Android Test Manifest](#android-test-manifest)
* [App class](#app-class)
* [Home class](#home-class)
* [Test class](#test-class)
* [Makefile](#makefile)

### Kranberry Properties
`module/src/androidTest/assets/kranberry.properties.json`

```json
{
  "default_timeout": 60000,
  "clear_application_data_before_testing": false,
  "skip_chrome_welcome_screen": true,
  "page_load_timeout": 30000,
  "disable_animations": true,
  "app_packages": [
    "your.app.package"
  ],
  "permissions_granted_to_device": [
    "ACCESS_FINE_LOCATION",
    "WRITE_EXTERNAL_STORAGE",
    "READ_EXTERNAL_STORAGE",
    "READ_CONTACTS",
    "CAMERA"
  ],
  "progressbar_class": [
    "android.widget.ProgressBar"
  ],
  "print_colored_logs": true,
  "test-class_prefix": "your.app.package.test"
}
```
[⬅️ ](#templates) [➡️](#android-test-manifest) [⬆️](#setup-kranberry-dependency)
	
### Android Test Manifest
`module/src/androidTest/AndroidManifest.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="your.app.package.test">

    <uses-sdk
        android:minSdkVersion="24"
        android:targetSdkVersion="30" />

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

</manifest>
```
[⬅️ ](##kranberry-properties) [➡️](#app-class) [⬆️](#setup-kranberry-dependency)

### App class
`module/src/androidTest/java/feature/App.kt`

```Kotlin
package feature

import androidx.test.uiautomator.UiDevice
import io.kranberry.environment.DeviceHandler.APP_PACKAGE
import io.kranberry.environment.DeviceHandler.start
import io.kranberry.outputs.ScreenshotHandler.takeScreenshot
import io.kranberry.ui.BaseUi

class App(device: UiDevice) : BaseUi(device) {

    fun open(): Home {
        start(APP_PACKAGE)
        takeScreenshot()
        return Home(device)
    }
}
```

[⬅️](#kranberry-properties) [➡️](#home-class) [⬆️](#setup-kranberry-dependency)

### Home class
`module/src/androidTest/java/feature/Home.kt`

```Kotlin
package feature

import androidx.test.uiautomator.UiDevice
import io.kranberry.outputs.ScreenshotHandler.takeScreenshot
import io.kranberry.ui.BaseUi
import io.kranberry.ui.elementIsPresentByTextContains

class Home(device: UiDevice) : BaseUi(device) {

    fun shouldSeeFlowerList(): Home {
        assert(elementIsPresentByTextContains("Flowers"))
        takeScreenshot()
        return this
    }
}
```

[⬅️](#app-class) [➡️](#test-class) [⬆️](#setup-kranberry-dependency)
### Test class
`module/src/androidTest/java/your/app/package/YourTestJourney.kt`

```Kotlin
package your.app.package
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import feature.App
import io.kranberry.KranberryRules
import io.kranberry.environment.TestHandler.device
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 24)
class YourTestJourney {

    @Rule
    @JvmField
    val testRule = KranberryRules()

    @Test
    fun openApp(){
        App(device)
            .open()
            .shouldSeeFlowerList()
    }
}
}
```
[⬅️](#home-class) [➡️](#makefile) [⬆️](#setup-kranberry-dependency)

### Makefile
`root/Makefile`

```Makefile
### BUILD ####
buildDebug:
	./gradlew assembleDebug

buildAndroidTestDebug:
	./gradlew assembleDebugAndroidTest

### INSTALL ###
installDebug:
	adb install app/build/outputs/apk/debug/app-debug.apk

installAndroidTestDebug:
	adb install app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk

buildInstallDebug: buildDebug installDebug

### TEST ###
testDebug:
	./gradlew testDebug

testFileDebug:
	./gradlew testDebug --tests $(file)

androidTestDebug:
	./gradlew connectedDebugAndroidTest

androidTestDebugModule:
	./gradlew :$(module):connectedDebugAndroidTest

androidTestFileDebugModule:
	./gradlew :$(module):connectedDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=$(file)

clear-logcat-logs:
	@adb shell logcat -b all -c

copy-tests-outputs:
	@rm -rf kranberry-outputs; \
	mkdir kranberry-outputs; \
	adb pull /storage/emulated/0/Android/media/your.app.package kranberry-outputs; \

### RUN UI TESTS ###
# before run tests make sure to call: buildDebug buildAndroidTestDebug installDebug installAndroidTestDebug
test: buildDebug buildAndroidTestDebug installDebug installAndroidTestDebug clear-logcat-logs
	@adb logcat *:S KRANBERRY_LOG:V & LOGCAT_PID=$$!; \
	TERM=dumb adb shell am instrument -w your.app.package.test/androidx.test.runner.AndroidJUnitRunner ; \
	RESULT=$$?; \
	if [ -n "$$LOGCAT_PID" ]; then kill $$LOGCAT_PID; fi; \
	exit $$RESULT

run-kranberry:
	@make test && make copy-tests-outputs
```

[⬅️](#test-class) [➡️](#license) [⬆️](#setup-kranberry-dependency)

------------------------------------------------------------------------
# License

Distributed under the Apache Version 2.0 License. See `LICENSE` for more information.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this software except in compliance with the License.
 You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
