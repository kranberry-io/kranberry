package io.kranberry.environment

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import io.kranberry.environment.PropertyReader.getProperty
import io.kranberry.environment.TestHandler.date
import io.kranberry.environment.TestHandler.device
import io.kranberry.log.Log
import io.kranberry.outputs.CsvHandler.getCsvDevicePath
import io.kranberry.outputs.ScreenshotHandler.getScreenshotDevicePath
import org.hamcrest.CoreMatchers
import java.io.File

object DeviceHandler {

    val testEnvironmentProperties = getProperty()
    val APP_PACKAGE = testEnvironmentProperties.appPackages[0]
    private val TIMEOUT = testEnvironmentProperties.defaultTimeout

    private lateinit var appPackage: String

    fun start(appPackage: String): UiDevice {
        Log.info("Starting the app: '$appPackage'")
        DeviceHandler.appPackage = appPackage

        executeDeviceCommands(device)
        device.pressHome()

        waitForLauncher(device)
        startApp()
        waitAppStart(device)
        createDevicePaths()
        return device
    }

    private fun clearApplicationData(appPackage: String) {
        when {
            testEnvironmentProperties.clearApplicationDataBeforeTesting -> {
                device.executeShellCommand("pm clear $appPackage")
            }
        }
    }

    private fun executeDeviceCommands(device: UiDevice) {
        device.executeShellCommand("settings put secure show_ime_with_hard_keyboard 0")
        device.executeShellCommand("settings put global window_animation_scale 0")
        device.executeShellCommand("settings put global transition_animation_scale 0")
        device.executeShellCommand("settings put global animator_duration_scale 0")
    }

    fun getDevice(): UiDevice {
        return device
    }

    private fun waitForLauncher(device: UiDevice) {
        val launcherPackage = getLauncherPackageName()
        ViewMatchers.assertThat(launcherPackage, CoreMatchers.notNullValue())
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), TIMEOUT)
    }

    private fun startApp() {
        val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent: Intent = context.packageManager.getLaunchIntentForPackage(APP_PACKAGE)
            ?: throw IllegalStateException("You must have the app installed to run this test.")
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        context.startActivity(intent)
    }

    private fun waitAppStart(device: UiDevice) {
        device.wait(Until.hasObject(By.pkg(appPackage).depth(0)), TIMEOUT)
    }

    private fun getLauncherPackageName(): String? {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)

        val packageManager =
            InstrumentationRegistry.getInstrumentation().targetContext.packageManager
        val resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return resolveInfo?.activityInfo?.packageName
    }

    private fun createDevicePaths(): Boolean {
        val csvPath = getCsvDevicePath()
        val screenShotPath = getScreenshotDevicePath().toString()
        return File(csvPath).exists() && File(screenShotPath).exists()
    }

    fun getTestsOutputsDevicePath(): String {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val testsOutputsPath = context.externalMediaDirs.firstOrNull()?.absolutePath
        return (testsOutputsPath
            ?: throw IllegalStateException("It was not possible to access apps external files dir")) +
                "/kranberryTestsOutputs/${date}"
    }
}
