package io.kranberry.ui

import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until.findObjects
import io.kranberry.log.Log


/**
 * Waits and performs a touch on an element of a given id.
 *
 * @param id of the element you want to tap,
 * it is not necessary to include the full path with the appPackage, Kranberry includes this automatically.
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */

fun BaseUi.tapById(id: String): Boolean = if (waitUntilElementIsPresentById(id)) {
    device.findObject(By.res(appPackage, id)).click()
    Log.message("The element $id was been touched")
    true
} else false

fun BaseUi.tapByText(visibleText: String): Boolean = if (waitUntilElementIsPresentByText(visibleText)) {
    device.wait(findObjects(By.text(visibleText)), timeout)
    device.findObject(By.text(visibleText)).click()
    Log.message("The text '$visibleText' was been touched")
    true
} else false

fun BaseUi.tapByIndex(index: Int): Boolean {
    val element = findElementByIndex(index)
    if (element.exists() && element.isEnabled) {
        element.click()
        return true
    }
    return false
}

fun BaseUi.tapByClass(className: String): Boolean {
    val className: UiObject = device.findObject(
        UiSelector().className(className)
    )

    if (className.exists() && className.isEnabled) {
        className.click()
        return true
    }
    return false
}

fun BaseUi.tapByTextContains(visibleText: String): Boolean {
    val text: UiObject = device.findObject(
        UiSelector().textContains(visibleText)
    )

    if (text.exists() && text.isEnabled) {
        text.click()
        return true
    }
    return false
}

fun BaseUi.tapEnter() {
    device.pressEnter()
}

fun BaseUi.tapByAccessibilityId(accessibilityId: String): Boolean {
    val element = findElementByAccessibilityId(accessibilityId)
    if (element.exists() && element.isEnabled) {
        element.click()
        return true
    }
    return false
}

