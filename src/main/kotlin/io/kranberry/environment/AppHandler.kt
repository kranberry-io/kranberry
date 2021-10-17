package io.kranberry.environment

import io.kranberry.environment.DeviceHandler.APP_PACKAGE
import io.kranberry.environment.DeviceHandler.start
import io.kranberry.outputs.ScreenshotHandler.takeScreenshot

object AppHandler {

    fun openApp() {
        start(APP_PACKAGE)
        takeScreenshot()
    }
}

