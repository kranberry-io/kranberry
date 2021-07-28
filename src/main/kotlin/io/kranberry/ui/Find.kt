package io.kranberry.ui

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector

fun BaseUi.findElementByAccessibilityId(accessibilityId: String): UiObject {
    return device.findObject(UiSelector().descriptionContains(accessibilityId))
}

fun BaseUi.findElementById(id: String): UiObject {
    return device.findObject(UiSelector().resourceId("$appPackage:id/$id"))
}

fun BaseUi.findElementByIndex(index: Int): UiObject {
    return device.findObject(UiSelector().index(index))
}