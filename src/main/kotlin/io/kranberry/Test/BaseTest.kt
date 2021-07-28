package io.kranberry.Test

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.uiautomator.UiDevice
import io.kranberry.Log
import io.kranberry.ScreenshotHandler
import io.kranberry.TestRules
import io.kranberry.environment.DeviceHandler.getDevice
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 21)

open class BaseTest {

    lateinit var device: UiDevice

    @Rule
    @JvmField
    val name = TestName()

    @Rule
    @JvmField
    val testRule = TestRules()

    @Before
    fun setUp() {
        ScreenshotHandler.setScreenshotsName(name.methodName)
        device = getDevice()
    }

    @Test
    fun kranberry(){
        Log.alert("Starting tests with the Kranberry library!")
    }
}