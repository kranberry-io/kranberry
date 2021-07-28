package io.kranberry.ui

import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import io.kranberry.Log

fun BaseUi.scrollUntilText(visibleText: String): Boolean {
    val scrollable = UiScrollable(
        UiSelector().scrollable(true)
            .instance(0)
    )

    return if (scrollable
            .scrollIntoView(
                UiSelector()
                    .textContains(visibleText)
                    .instance(0)
            )
    ) {
        Log.message("The text '$visibleText' is present!")
        true
    } else false
}

fun BaseUi.scrollUntilId(visibleId: String): Boolean {
    val scrollable = UiScrollable(
        UiSelector().scrollable(true)
            .instance(0)
    )

    return if (scrollable
            .scrollIntoView(
                UiSelector()
                    .resourceId(visibleId)
                    .instance(0)
            )
    ) {
        Log.message("The text '$visibleId' is present!")
        true
    } else false
}

fun BaseUi.scrollToEnd(): Boolean {
    val scrollable = UiScrollable(
        UiSelector().scrollable(true)
            .instance(0)
    )
    return scrollable.scrollToEnd(maxSearchSwipes)
}

fun BaseUi.scrollToBeginning(): Boolean {
    val scrollable = UiScrollable(
        UiSelector().scrollable(true)
            .instance(0)
    )
    return scrollable.scrollToBeginning(maxSearchSwipes)
}