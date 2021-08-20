------------------------------------------------------------------------


![CI](https://github.com/kranberry-io/kranberry/actions/workflows/build-actions.yml/badge.svg?style=for-the-badge)
![CONTRIBUTORS](https://img.shields.io/github/contributors/kranberry-io/kranberry.svg)
![Stargazers](https://img.shields.io/github/stars/kranberry-io/kranberry.svg)
![Issues](https://img.shields.io/github/issues/kranberry-io/kranberry.svg)
![License](https://img.shields.io/github/license/kranberry-io/kranberry.svg)
![Forks](https://img.shields.io/github/forks/kranberry-io/kranberry.svg)

------------------------------------------------------------------------
![](README/kranberry1.png)
------------------------------------------------------------------------
1. [About The Project](#about-the-project)
2. [Getting Started](#getting-started)
3. [Kranberry Properties File](#kranberry-properties-file)
4. [Roadmap](#roadmap)
5. [Contributing](#contributing)
6. [License](#license)

------------------------------------------------------------------------
# About The Project

------------------------------------------------------------------------
# Getting Started

> Note that the library is experimental, and the API is subject to change.

The library is published to Maven Central.

## Gradle

Add the Maven Central repository if it is not already there:

```groovy
repositories {
    mavenCentral()
}
```

1. [Add the Kranberry dependency](https://github.com/kranberry-io/kranberry-sample/commit/108de28c0d0c7c527187beb9a1b4662605ccbbac#diff-51a0b488f963eb0be6c6599bf5df497313877cf5bdff3950807373912ac1cdc9) to your `module/build.gradle` file inside the package that will be tested (not the build.gradle file in the project root):

```groovy
// Kranberry
androidTestImplementation 'io.github.kranberry-io:kranberry:$versions.kranberry'
```

2. [Add a `kranberry.properties.json`](https://github.com/kranberry-io/kranberry-sample/commit/3bf5302643c7fdbfebe108149c1b7e7a6585d629) file in the path `module/src/androidTest/assets`. If the folder does not exist, you must create it.

3. [Add an `AndroidManifest.xml`](https://github.com/kranberry-io/kranberry-sample/commit/ba3c973de8924c875ac8d87d897833c5802a18f0) file in the path `module/src/androidTest`. If the folder does not exist, you must create it.

4. [Add an `App.kt` class](https://github.com/kranberry-io/kranberry-sample/commit/31a50136acef58b0146dd70d114e3c18597e7cf4) in the path `module/src/androidTest/java/feature`. If the folder does not exist, you must create it. This step will serve to implement the method that will open your app.

5. [Add a `Home.kt` class](https://github.com/kranberry-io/kranberry-sample/commit/3aec77f09476101d1b9310d65f6b747ee5c5eac7) in the path `module/src/androidTest/java/feature`. If the folder does not exist, you must create it. This step will serve to implement navigation steps and assertions.

6. [Add the `/kranberry-outputs/` information](https://github.com/kranberry-io/kranberry-sample/commit/ab368088d38574818725b4c284744b3552f201aa) to your `gitignore` file. This will prevent you from publishing test outputs in your repository.

7. If you want to run your tests in a customized way, [you can include a Makefile](https://github.com/kranberry-io/kranberry-sample/commit/1525eb53495fdc1917048394fb1ea1fe6eb56427) , modifying the execution tasks with desired parameters.

8. 🥳 🎉 Voilà! Now you can run your first test from the terminal command line:

![](README/test-execution-kranberry.gif)
> Note that there is a previously opened emulator to run the tests.


------------------------------------------------------------------------
# Roadmap
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
# License

Distributed under the MIT License. See `LICENSE` for more information.

------------------------------------------------------------------------
# Kranberry Properties File

This is the configuration file used by the library to configure the values that will be used to set the test environment.
The file must be located in the `src/androidTest/assets` directory with name `kranberry.properties.json`.
Below you will find more details about the parameters that can be used:

* [Properties table](#properties-table)
* [Example of properties file](#example-of-properties-file)

## Properties table

| Parameter                             	| Description                                                                                                                                                                                    	|     Type     	| Obligatory 	|        Default Value       	|
|---------------------------------------	|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|:------------:	|:----------:	|:--------------------------:	|
| app_packages                          	| Packages of the applications that will be tested. The first package in the list will be referenced by the Kranberry constant `APP_PACKAGE`. The others will be used for permission management. 	| List<String> 	|     Yes    	|     io.kranberry.sample    	|
| clear_application_data_before_testing 	| Defines whether the application data defined in the `app_packages` parameter list will be cleared before running the tests.                                                                    	|              	|            	| FALSE                      	|
| default_timeout                       	| Default implicit timeout for interaction with UI elements in milliseconds.                                                                                                                     	|     Long     	|     No     	|            60000           	|
| disable_animations                    	| Defines whether animations will be disabled during instrumentation tests. The goal is to increase test performance.                                                                            	|              	|            	| TRUE                       	|
| max_search_swipes                     	| Sets the maximum scroll down/up will be performed when fetching an element using the methods of the `io.kranberry.ui.Swipe` class.                                                             	|      Int     	|     No     	|                            	|
| page_load_timeout                     	| Defines the maximum implicit wait time for the element set in the `progressbar_class` property. This is used in Kranberry's `waitForPageLoad()` method.                                        	|     Long     	|     No     	| 30000                      	|
| permissions_granted_to_device         	| Defines the list of permissions that will be granted to app packages set in the `app_packages ` property.                                                                                      	| List<String> 	|     No     	|    ACCESS_FINE_LOCATION    	|
| print_colored_logs                    	| Defines if the terminal logs will be printed colored.                                                                                                                                          	|              	|            	| TRUE                       	|
| progressbar_class                     	| Defines the progress bar class that will be implicitly expected. This is used in Kranberry's `waitForPageLoad()` method.                                                                       	| List<String> 	|     No     	| android.widget.ProgressBar 	|
| skip_chrome_welcome_screen            	| Defines whether the application data defined in the `app_packages` parameter list will be cleared before running the tests.                                                                    	|    Boolean   	|     No     	| TRUE                       	|
| swipe_down_params                     	| Defines the list of parameters that will be used in method swipeDown(). These being in order: `SWIPE_DOWN_START_X, SWIPE_DOWN_START_Y, SWIPE_DOWN_END_X, SWIPE_DOWN_END_Y, SWIPE_DOWN_STEPS`   	|  List<Long>  	|     No     	|                            	|
| swipe_up_params                       	| Defines the list of parameters that will be used in method swipeUp(). These being in order: `SWIPE_UP_START_X, SWIPE_UP_START_Y, SWIPE_UP_END_X, SWIPE_UP_END_Y, SWIPE_UP_STEPS`               	|  List<Long>  	|     No     	|                            	|

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
---
