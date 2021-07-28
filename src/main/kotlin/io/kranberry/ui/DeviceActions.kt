package io.kranberry.ui

import android.view.KeyEvent

fun BaseUi.backUsingDeviceButton() {
    device.pressKeyCode(KeyEvent.KEYCODE_BACK)
}