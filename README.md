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



## About The Project

## Getting Started

## Roadmap
See the [open issues](https://github.com/kranberry-io/kranberry/issues) for a list of proposed features (and known issues).

## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Kranberry Properties File

This is the configuration file used by the library to configure the values that will be used to set the test environment.
The file must be located in the `src/androidTest/assets` directory with name `kranberry.properties.json`.
Below you will find more details about the parameters that can be used:

* [app_packages](#app_packages)
* [clear_application_data_before_testing](#clear_application_data_before_testing)
* [default_timeout](#default_timeout)
* [disable_animations](#disable_animations)
* [log_tag](#log_tag)
* [max_search_swipes](#max_search_swipes)
* [page_load_timeout](#page_load_timeout)
* [permissions_granted_to_device](#permissions_granted_to_device)
* [progressbar_class](#progressbar_class)
* [skip_chrome_welcome_screen](#skip_chrome_welcome_screen)
* [swipe_down_params](#swipe_down_params)
* [swipe_up_params](#swipe_up_params)
* [Example of properties file](#example-of-properties-file)

---
#### default_timeout
* **Description:** *Default implicit timeout for interaction with UI elements in milliseconds.*
* **Type:** *Long*
* **Obligatory:** **
* **Default Value:** **
* **Example:** `"default_timeout": 60000`
---
#### log_tag
* **Description:** *Tag displayed when printing logs to console during test execution.*
* **Type:** *String*
* **Obligatory:** *No*
* **Default Value:** *KRANBERRY_LOG*
* **Example:** `"log_tag": "MY_PACKAGE_TEST_LOG"`
---
#### clear_application_data_before_testing
* **Description:** *Defines whether the application data defined in the `app_packages` parameter list will be cleared before running the tests.*
* **Type:** *Boolean*
* **Obligatory:** *No*
* **Default Value:** *true*
* **Example:** `"clear_application_data_before_testing": true`
---
#### skip_chrome_welcome_screen
* **Description:** *Defines whether the google chrome welcome screen will be displayed in case of iterations with browser/webviews.*
* **Type:** *Boolean*
* **Obligatory:** *No*
* **Default Value:** *true*
* **Example:** `skip_chrome_welcome_screen": true`
---
#### page_load_timeout
* **Description:** **
* **Type:** *Long*
* **Obligatory:** *No*
* **Default Value:** *60000*
* **Example:** `page_load_timeout": 35000`
---
#### max_search_swipes
* **Description:** **
* **Type:** *Int*
* **Obligatory:** *No*
* **Default Value:** **
* **Example:** ``
---
#### disable_animations
* **Description:** **
* **Type:** *Boolean*
* **Obligatory:** **
* **Default Value:** **
* **Example:** ``
---
#### app_packages
* **Description:** **
* **Type:** *MutableList<String>*
* **Obligatory:** **
* **Default Value:** **
* **Example:** ``
---
#### permissions_granted_to_device
* **Description:** **
* **Type:** *MutableList<String>*
* **Obligatory:** **
* **Default Value:** **
* **Example:** ``
---
#### progressbar_class
* **Description:** **
* **Type:** *List<String>*
* **Obligatory:** **
* **Default Value:** **
* **Example:** ``
---
#### swipe_down_params
* **Description:** **
* **Type:** *List<Long>*
* **Obligatory:** **
* **Default Value:** **
* **Example:** ``
---
#### swipe_up_params
* **Description:** **
* **Type:** *List<Long>*
* **Obligatory:** **
* **Default Value:** **
* **Example:** ``
---
#### Example of properties file

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
