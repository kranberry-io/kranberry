package io.kranberry.ui

import androidx.test.uiautomator.By
import io.kranberry.log.Log

/**
 * Verifies that the element is on screen immediately when called,
 * without performing any waits before that.
 *
 * @param id of the element you want to fetch,
 * it is not necessary to include the full path with the appPackage, Kranberry includes this automatically.
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.elementIsPresentById(id: String): Boolean {
    Log.message("Trying to find the element '$id'")

    val elementIsPresent = device.findObjects(By.res(appPackage, id)).size > 0

    when {
        elementIsPresent -> {
            Log.message("The '$id' has been found")
        }
        else -> Log.message("Element '$id' not found")
    }
    return elementIsPresent
}

/**
 * Verifies that the element is on screen immediately when called,
 * without performing any waits before that.
 *
 * @param text of the element you want to fetch,
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.elementIsPresentByTextContains(text: String): Boolean {
    Log.message("Trying to find some element that contains part of the text '$text'")

    val elementIsPresent = device.findObjects(By.textContains(text)).size > 0

    when {
        elementIsPresent -> {
            Log.message("'$text' has been found")
        }
        else -> Log.message("'$text' not found")
    }
    return elementIsPresent
}

@Deprecated(
    "Only to maintain backwards compatibility and will be removed soon.",
    ReplaceWith("elementExistsByTextContains(text)"), DeprecationLevel.WARNING
)
fun BaseUi.findElementByTextContains(text: String): Boolean {
    return elementIsPresentByTextContains(text)
}

@Deprecated(
    "Only to maintain backwards compatibility and will be removed soon.",
    ReplaceWith("elementExistsByTextContains(text)"), DeprecationLevel.WARNING
)
fun BaseUi.elementExistsByTextContains(text: String): Boolean {
    return elementIsPresentByTextContains(text)
}

/**
 * Verifies that the element is on screen immediately when called,
 * without performing any waits before that.
 *
 * @param text of the element you want to fetch,
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.elementIsPresentByText(text: String): Boolean {
    Log.message("Trying to find some element that contains the exact text '$text'")

    val elementIsPresent = device.findObjects(By.text(text)).size > 0

    when {
        elementIsPresent -> {
            Log.message("'$text' has been found")
        }
        else -> Log.message("'$text' not found")
    }
    return elementIsPresent
}

@Deprecated(
    "Only to maintain backwards compatibility and will be removed soon.",
    ReplaceWith("elementIsPresentByText(visibleText)"), DeprecationLevel.WARNING
)
fun BaseUi.elementExistsByText(visibleText: String): Boolean {
    return elementIsPresentByText(visibleText)
}

/**
 * Verifies that the element is on screen immediately when called,
 * without performing any waits before that.
 *
 * @param clazz represents the class of the element you want to fetch.
 * @return This method returns a boolean, which lets you decide what
 * to do with the result of it (fail the test or try again, for example)
 */
fun BaseUi.elementIsPresentByClass(clazz: String): Boolean {

    Log.message("Trying to find some element that contains the class '$clazz'")
    var attempts = 0
    var elementIsPresent = device.findObjects(By.clazz(clazz)).size > 0

    while (elementIsPresent || attempts == 3) {
        attempts++
        elementIsPresent = device.findObjects(By.clazz(clazz)).size > 0
    }

    when {
        elementIsPresent -> {
            Log.message("The '$clazz' has been found")
        }
        else -> Log.message("Element '$clazz' not found")
    }
    return elementIsPresent
}

@Deprecated(
    "Only to maintain backwards compatibility and will be removed soon.",
    ReplaceWith("elementIsPresentById(id)"), DeprecationLevel.WARNING
)
fun BaseUi.elementExistsById(id: String): Boolean {
    return elementIsPresentById(id)
}