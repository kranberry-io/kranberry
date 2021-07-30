package io.kranberry

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import io.kranberry.test.BaseTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 21)

class SampleTest : BaseTest() {

    @Test
    fun openGoogleChrome() {
        App(device)
                .open()
    }
}