package io.kranberry.feature

import io.kranberry.ui.BaseUi
import io.kranberry.ui.assertTrue
import io.kranberry.ui.elementIsPresentByTextContains

open class FlowerFinder : BaseUi() {

    fun shouldSeeFlowerFinderHomePage(): FlowerFinder {
        assertTrue(elementIsPresentByTextContains("Flower finder"))
        return this
    }

    fun shouldSeeFlower(flower: String) {
        assertTrue(elementIsPresentByTextContains(flower))

    }
}
