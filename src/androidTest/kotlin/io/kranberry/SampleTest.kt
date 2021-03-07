package io.kranberry

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.uiautomator.UiDevice
import io.kranberry.environment.DeviceHandler
import io.kranberry.screeen.App
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 21)

class SampleTest {

    private lateinit var device: UiDevice

    @Rule
    @JvmField
    val name = TestName()

    @Before
    fun setUp() {
        device = DeviceHandler.getDevice()
    }

    @Test
    fun openGoogleChrome() {
        App(device)
                .open()
    }
}