package io.kranberry.ui

import androidx.test.uiautomator.UiDevice
import io.kranberry.environment.DeviceHandler.testEnvironmentProperties

open class BaseUi(open val device: UiDevice) {

    val appPackage = testEnvironmentProperties.appPackages[0]
    val timeout = testEnvironmentProperties.defaultTimeout
    internal val maxSearchSwipes = testEnvironmentProperties.maxSearchSwipes
    private val androidPackage = testEnvironmentProperties.androidPackage
    internal val progressbarClass = testEnvironmentProperties.progressbarClass[0]
    internal val progressBarTimeout = testEnvironmentProperties.pageLoadTimeout
}