package io.kranberry.ui

import androidx.test.uiautomator.By
import io.kranberry.log.Log

fun BaseUi.swipeUpUntilText(text: String): Boolean {
    Log.message("Scrolling up until the text: $text")
    var completedSwipes = 1
    while (device.findObjects(By.textContains(text)).size == 0 && completedSwipes <= maxSearchSwipes) {
        completedSwipes++
        swipeUp(1)
    }
    return elementIsPresentByText(text)
}

fun BaseUi.swipeDownUntilText(text: String): Boolean {
    Log.message("Scrolling up until the text: $text")
    var completedSwipes = 1
    while (device.findObjects(By.text(text)).size == 0 && completedSwipes <= maxSearchSwipes) {
        completedSwipes++
        swipeDown(1)
    }
    return elementIsPresentByText(text)
}

fun BaseUi.swipeUpUntilId(id: String): Boolean {
    var completedSwipes = 1

    while (device.findObjects(
            By.res(
                appPackage,
                id
            )
        ).size == 0 && completedSwipes <= maxSearchSwipes
    ) {
        completedSwipes++
        swipeUp(1)
    }
    return elementIsPresentById(id)
}

private fun BaseUi.swipeUp(times: Int) {
    device.waitForIdle()
    for (i in 1..times) {
        device.waitForIdle()
        device.swipe(192, 724, 192, 100, 55)
    }
}

private fun BaseUi.swipeDown(times: Int) {
    device.waitForIdle()
    for (i in 1..times) {
        device.waitForIdle()
        device.swipe(300, 400, 300, 750, 4)

    }
}