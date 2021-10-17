package io.kranberry.ui

import io.kranberry.environment.DeviceHandler.testEnvironmentProperties
import io.kranberry.environment.TestHandler

open class BaseUi {

    val device = TestHandler.device
    val appPackage = testEnvironmentProperties.appPackages[0]
    val timeout = testEnvironmentProperties.defaultTimeout
    internal val maxSearchSwipes = testEnvironmentProperties.maxSearchSwipes
    private val androidPackage = testEnvironmentProperties.androidPackage
    internal val progressbarClass = testEnvironmentProperties.progressbarClass[0]
    internal val progressBarTimeout = testEnvironmentProperties.pageLoadTimeout
}