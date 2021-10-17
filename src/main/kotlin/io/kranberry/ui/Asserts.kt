package io.kranberry.ui

import io.kranberry.log.Log
import io.kranberry.outputs.ScreenshotHandler.takeScreenshot
import org.junit.Assert.fail

fun BaseUi.assertTrue(assumption: Boolean) {
    when {
        assumption -> {
            Log.success("Successful validation!")
            takeScreenshot()
        }
        else -> {
            takeScreenshot()
            fail("Validation unsuccessful!")
        }
    }
}

fun BaseUi.assertFalse(index: Int, text: String): Boolean {
    val input = findElementByIndex(index)
    input.click()
    input.text = text
    return if (input.text == text) {
        Log.message("The text '$text' was entered in the field 'id=$index'")
        true
    } else false
}