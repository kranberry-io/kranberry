package io.kranberry.ui

fun BaseUi.getTextById(id: String): String {
    val element = findElementById(id)
    return element.text
}