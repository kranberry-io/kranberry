package io.kranberry

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import io.kranberry.environment.TestHandler.device
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 21)

class SampleTest {

    @Rule
    @JvmField
    val testRule = KranberryRules()

    @Test
    fun openDeviceSettings() {
        App(device)
                .open()
    }
}