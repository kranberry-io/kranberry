package io.kranberry

import android.os.Environment
import android.os.Environment.DIRECTORY_PICTURES
import io.kranberry.environment.DeviceHandler
import io.kranberry.environment.TestHandler.currentTestCaseId
import io.kranberry.environment.TestHandler.currentTestResult
import io.kranberry.environment.TestHandler.testClassName
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object ScreenshotHandler {

    private var count: Int = 0
    private val device = DeviceHandler.getDevice()
    private val dateFormat = SimpleDateFormat("yyyy_MM_dd_HH:mm:ss")
    private val now = Date()
    private val date: String = dateFormat.format(now)
    private var currentTestCaseName = ""


    private const val screenshotScale = 1.0F
    private const val screenshotQuality = 20

    fun getExecutionScreenshotPath(): String {
        return Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES).absolutePath + "/Screenshots/${date}"
    }

    fun getTestResult(): String {
        return when (currentTestCaseId) {
            "" -> {
                "$currentTestResult\n"
            }
            else -> "$currentTestCaseId,$currentTestResult\n"
        }
    }

    fun takeScreenshot() {
        device.waitForIdle()
        device.takeScreenshot(
            File(getScreenshotDevicePath(), getScreenshotName()),
            screenshotScale,
            screenshotQuality
        )
    }

    fun takeScreenshot(screenshotName: String?) {
        device.takeScreenshot(
            File(getScreenshotDevicePath(), "$screenshotName.png"),
            screenshotScale,
            screenshotQuality
        )
    }

    fun setScreenshotsName(testcaseName: String) {
        currentTestCaseName = testcaseName
        count = 0
    }

    private fun getScreenshotName(): String = when (currentTestCaseName) {
        "" -> "${"Screenshot"}_${getCurrentTime()}.png"
        else -> "$testClassName-${normalize(currentTestCaseName)}.png"
    }

    private fun getCurrentTime(): String {
        val formatCurrentTime = SimpleDateFormat("HHmmss")
        return formatCurrentTime.format(now)
    }

    private fun getScreenshotDevicePath(): File? {
        val deviceScreenshotsPath =
            File(getExecutionScreenshotPath() + "/${currentTestResult}/$currentTestCaseId/")
        if (!deviceScreenshotsPath.exists()) deviceScreenshotsPath.mkdirs()
        return deviceScreenshotsPath
    }

    private fun normalize(testName: String): String {
        val regex = "([a-z])([A-Z]+)"
        val replacement = "$1_$2"
        count++
        return testName
            .replace(regex.toRegex(), replacement)
            .toLowerCase() + "_" + count
    }
}