package io.kranberry.environment

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import io.kranberry.environment.PropertyReader.getProperty
import io.kranberry.wrapper.BuildConfig
import org.hamcrest.CoreMatchers

object DeviceHandler {

    private val libraryPackageName = BuildConfig.LIBRARY_PACKAGE_NAME

    val testEnvironmentProperties = getProperty()
    val APP_PACKAGE = testEnvironmentProperties.appPackages[0]
    val TIMEOUT = testEnvironmentProperties.defaultTimeout

    private lateinit var appPackage: String
    var testClassName: String = ""

    fun start(appPackage: String): UiDevice {
        DeviceHandler.appPackage = appPackage

        val device = getDevice()
        if (testEnvironmentProperties.clearApplicationDataBeforeTesting) {
            device.executeShellCommand("pm clear $appPackage")
        }

        device.executeShellCommand("settings put secure show_ime_with_hard_keyboard 0")
        device.executeShellCommand("settings put global window_animation_scale 0")
        device.executeShellCommand("settings put global transition_animation_scale 0")
        device.executeShellCommand("settings put global animator_duration_scale 0")
        device.executeShellCommand("pm grant net.test.cn.hml android.permission.ACCESS_FINE_LOCATION")
        device.executeShellCommand("pm grant net.test.cn.hml android.permission.WRITE_EXTERNAL_STORAGE")
        device.executeShellCommand("pm grant net.test.cn.hml android.permission.READ_EXTERNAL_STORAGE")
        device.executeShellCommand("pm grant net.test.fv android.permission.ACCESS_FINE_LOCATION")
        device.executeShellCommand("pm grant net.test.fv android.permission.WRITE_EXTERNAL_STORAGE")
        device.executeShellCommand("pm grant net.test.fv android.permission.READ_EXTERNAL_STORAGE")
        device.executeShellCommand("pm grant net.test.fv android.permission.CAMERA")
        device.executeShellCommand("pm grant com.test.tests.test android.permission.ACCESS_FINE_LOCATION")
        device.executeShellCommand("pm grant com.test.tests.test android.permission.WRITE_EXTERNAL_STORAGE")
        device.executeShellCommand("pm grant com.test.tests.test android.permission.READ_EXTERNAL_STORAGE")
        device.pressHome()

        waitForLauncher(device)
        startApp()
        waitAppStart(device)

        return device
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun grantPermissionsToPackageList(packages: MutableList<String>, permissions: MutableList<String> ) {

        InstrumentationRegistry
            .getInstrumentation()
            .uiAutomation
            .grantRuntimePermission("", "")
    }

    fun testClassName(testClassName: String) {
        DeviceHandler.testClassName = testClassName
    }

    fun getPackage(): String {
        return APP_PACKAGE
    }

    fun clearAppData() {
        InstrumentationRegistry.getInstrumentation()
            .uiAutomation.executeShellCommand("pm clear $APP_PACKAGE")
    }

    fun getDevice(): UiDevice {
        return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
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
}
