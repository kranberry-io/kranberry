package io.kranberry.environment

import com.google.gson.annotations.SerializedName

data class TestEnvironmentProperties(
    @SerializedName("default_timeout") private val _defaultTimeout: Long?,
    @SerializedName("android_package") private val _androidPackage: String?,
    @SerializedName("log_tag") private val _logTag: String?,
    @SerializedName("clear_application_data_before_testing") private val _clearApplicationDataBeforeTesting: Boolean?,
    @SerializedName("skip_chrome_welcome_screen") private val _skipChromeWelcomeScreen: Boolean?,
    @SerializedName("page_load_timeout") private val _pageLoadTimeout: Long?,
    @SerializedName("max_search_swipes") private val _maxSearchSwipes: Int?,
    @SerializedName("disable_animations") private val _disableAnimations: Boolean?,
    @SerializedName("app_packages") private val _appPackages: MutableList<String>?,
    @SerializedName("permissions_granted_to_device") private val _permissionsGrantedToDevice: List<String>?,
    @SerializedName("progressbar_class") private val _progressbarClass: List<String>?,
    @SerializedName("swipe_down_params") private val _swipeDownParams: List<Long>?,
    @SerializedName("swipe_up_params") private val _swipeUpParams: List<Long>?
) {
    val defaultTimeout
        get() = _defaultTimeout ?: 30000L

    val androidPackage
        get() = _androidPackage ?: "android"

    val logTag
        get() = _logTag ?: "KRANBERRY_LOG"

    val clearApplicationDataBeforeTesting
        get() = _clearApplicationDataBeforeTesting ?: true

    val skipChromeWelcomeScreen
        get() = _skipChromeWelcomeScreen ?: true

    val pageLoadTimeout
        get() = _pageLoadTimeout ?: 60000L

    val maxSearchSwipes
        get() = _maxSearchSwipes ?: 50

    val disableAnimations
        get() = _disableAnimations ?: true

    val appPackages
        get() = _appPackages ?: throw IllegalArgumentException(
            "The 'app_packages' parameter is not present in kranberry.properties.json file." +
                    "For more information access: https://github.com/kranberry-io/kranberry#kranberry-properties-file"
        )

    val permissionsGrantedToDevice
        get() = _permissionsGrantedToDevice ?: throw IllegalArgumentException(
            "The 'permissions_granted_to_device' parameter is not present in kranberry.properties.json file." +
                    "For more information access: https://github.com/kranberry-io/kranberry#kranberry-properties-file"
        )

    val progressbarClass
        get() = _progressbarClass ?: listOf("android.widget.ProgressBar")

    val swipeDownParams
        get() = _swipeDownParams ?: listOf(300, 400, 300, 750, 4)

    val swipeUpParams
        get() = _swipeUpParams ?: listOf(192, 724, 192, 100, 55)
}