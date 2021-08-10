package io.kranberry

import androidx.test.uiautomator.UiDevice
import io.kranberry.ScreenshotHandler.takeScreenshot
import io.kranberry.environment.DeviceHandler
import io.kranberry.environment.DeviceHandler.APP_PACKAGE
import io.kranberry.ui.BaseUi
import io.kranberry.ui.elementIsPresentByTextContains
import junit.framework.TestCase.assertTrue

open class App(device: UiDevice) : BaseUi(device) {

    open fun open(): App {
        DeviceHandler.start(APP_PACKAGE)
        takeScreenshot()
        assertTrue(elementIsPresentByTextContains("Welcome to Chrome"))
        return this
    }
}
