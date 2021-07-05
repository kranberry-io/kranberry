package io.kranberry.screeen

import androidx.test.uiautomator.UiDevice
import io.kranberry.Page
import io.kranberry.environment.DeviceHandler
import io.kranberry.environment.DeviceHandler.APP_PACKAGE

open class App(device: UiDevice) : Page(device) {

    open fun open(): App {
        DeviceHandler.start(APP_PACKAGE)
        return this
    }
}
