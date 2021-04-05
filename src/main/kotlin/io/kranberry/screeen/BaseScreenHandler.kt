package io.kranberry.screeen

import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import io.kranberry.environment.APP_PACKAGE
import io.kranberry.environment.TIMEOUT

const val MAX_SEARCH_SWIPES = 25
const val MAX_PICK_DATE_TRIES = 11
const val PROGRESS_BAR_TIMEOUT = 60000L
const val ANSI_RESET = "\u001B[0m"
const val ANSI_BLUE = "\u001B[34m"
const val ANSI_MAGENTA = "\u001B[35m"
const val ANSI_GREY = "\u001B[39m"
open class Page(open val device: UiDevice) {
    fun tapByIndex(index: Int): Boolean {
        val element = findElementByIndex(index)
        if (element.exists() && element.isEnabled) {
            element.click()
            return true
        }
        return false
    }

    fun tapByClass(className: String): Boolean {
        val className: UiObject = device.findObject(
                UiSelector().className(className)
        )
        waitForElementAndDevice(className)

        if (className.exists() && className.isEnabled) {
            className.click()
            return true
        }
        return false
    }

    fun tapByTextContains(visibleText: String): Boolean {
        val text: UiObject = device.findObject(
                UiSelector().textContains(visibleText)
        )
        waitForElementAndDevice(text)

        if (text.exists() && text.isEnabled) {
            text.click()
            return true
        }
        return false
    }

    fun tapByAccessibilityId(accessibilityId: String): Boolean {
        val element = findElementByAccessibilityId(accessibilityId)
        waitForElementAndDevice(element)
        if (element.exists() && element.isEnabled) {
            element.click()
            return true
        }
        return false
    }

    fun scrollToEnd(): Boolean {
        val scrollable = UiScrollable(UiSelector().scrollable(true)
                .instance(0))
        waitForElementAndDevice(scrollable)
        return scrollable.scrollToEnd(MAX_SEARCH_SWIPES)
    }

    fun scrollToBeginning(): Boolean {
        val scrollable = UiScrollable(UiSelector().scrollable(true)
                .instance(0))
        waitForElementAndDevice(scrollable)
        return scrollable.scrollToBeginning(MAX_SEARCH_SWIPES)
    }

    internal fun elementIsPresentById(id: String): Boolean {
        device.waitForIdle(TIMEOUT)
        return device.findObjects(By.res(APP_PACKAGE, id)).size > 0
    }

    private fun findElementByIndex(index: Int): UiObject {
        return device.findObject(UiSelector().index(index))
    }

    private fun waitForElementAndDevice(element: UiObject): Page {
        waitForElementAndDevice(element, TIMEOUT)
        return this
    }

    private fun waitForElementAndDevice(element: UiObject, timeout: Long): Page {
        element.waitForExists(timeout)
        device.waitForIdle(timeout)
        return this
    }

    private fun findElementByAccessibilityId(accessibilityId: String): UiObject {
        return device.findObject(UiSelector().descriptionContains(accessibilityId))
    }
}
