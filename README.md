![CI](https://github.com/kranberry-io/kranberry/actions/workflows/build-actions.yml/badge.svg)

# kranberry-core


## Kranberry Properties File

This is the configuration file used by the library to configure the values that will be used to set the test environment.
The file must be located in the `src/androidTest/assets` directory with name `kranberry.properties.json`.
Below you will find more details about the parameters that can be used:

<div class="tg-wrap"><table>
<thead>
  <tr>
    <th>Parameters</th>
    <th>Description</th>
    <th>Type</th>
    <th>Obligatory</th>
    <th>Default Value</th>
    <th>Example</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>default_timeout</td>
    <td>Default implicit timeout for interaction with UI elements in milliseconds.</td>
    <td>Long</td>
    <td>No</td>
    <td>60000</td>
    <td>30000</td>
  </tr>
  <tr>
    <td>log_tag</td>
    <td>Tag displayed when printing logs to console during test execution.</td>
    <td>String</td>
    <td>No</td>
    <td>KRANBERRY_LOG</td>
    <td>MY_TAG_LOG</td>
  </tr>
  <tr>
    <td>clear_application_data_before_testing</td>
    <td>Defines whether the application data defined in the `app_packages` parameter list will be cleared before running the tests.</td>
    <td>Boolean</td>
    <td>No</td>
    <td>true</td>
    <td>false</td>
  </tr>
  <tr>
    <td>skip_chrome_welcome_screen</td>
    <td>Defines whether the google chrome welcome screen will be displayed in case of iterations with browser/webviews.</td>
    <td>Boolean</td>
    <td>No</td>
    <td>true</td>
    <td>false</td>
  </tr>
  <tr>
    <td>page_load_timeout</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>max_search_swipes</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>disable_animations</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>app_packages</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>permissions_granted_to_device</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>progressbar_class</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>swipe_down_params</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>swipe_up_params</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</tbody>
</table></div>