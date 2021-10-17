package io.kranberry

import androidx.test.ext.junit.runners.AndroidJUnit4
import io.kranberry.environment.AppHandler.openApp
import io.kranberry.feature.FlowerFinder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SampleTest {

    @Rule
    @JvmField
    val testRule = KranberryRules()

    @Test
    fun openFlowerFinder() {
        openApp()

        FlowerFinder()
            .shouldSeeFlowerFinderHomePage()
            .shouldSeeFlower("Dahlia")
    }
}