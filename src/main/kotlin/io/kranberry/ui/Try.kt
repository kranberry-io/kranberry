package io.kranberry.ui

fun BaseUi.tryBackUntilId(id: String, maximumAttempts: Int): Boolean {
    var attempts = 1
    var isDesiredId = elementIsPresentById(id)

    while (!isDesiredId && attempts <= maximumAttempts) {
        attempts++
        backUsingDeviceButton()
        isDesiredId = elementIsPresentById(id)
    }
    return isDesiredId
}