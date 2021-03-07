package io.kranberry.screeen

import androidx.test.uiautomator.UiDevice
import io.kranberry.environment.APP_PACKAGE
import io.kranberry.environment.DeviceHandler

open class App(device: UiDevice) : Page(device) {

    open fun open(): App {
        DeviceHandler.start(APP_PACKAGE)
        return this
    }

}
