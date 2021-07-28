package io.kranberry.ui

import io.kranberry.Log

fun BaseUi.inputTextById(id: String, text: String): Boolean {
    val input = findElementById(id)
    input.text = text
    return if (input.text == text) {
        Log.message("The text '$text' was entered in the field 'id=$id'")
        true
    } else false
}

fun BaseUi.inputTextByIndex(index: Int, text: String): Boolean {
    val input = findElementByIndex(index)
    input.click()
    input.text = text
    return if (input.text == text) {
        Log.message("The text '$text' was entered in the field 'id=$index'")
        true
    } else false
}