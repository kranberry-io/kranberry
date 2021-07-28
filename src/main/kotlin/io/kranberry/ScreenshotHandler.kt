package io.kranberry

import android.os.Environment
import android.os.Environment.DIRECTORY_PICTURES
import io.kranberry.environment.DeviceHandler
import java.io.File


object ScreenshotHandler {

    private var count: Int = 0
    private val device = DeviceHandler.getDevice()
    //TODO private val date: String = now().format(DateTimeFormatter
    //            .ofPattern("yyyy_MM_dd_HHmmss"))
    private val date: String = "yyyy_MM_dd_HHmmss"
    private var currentTestCaseName = ""
    private var currentTestCaseId = ""
    private var currentTestResult = "PASSED"

    private const val screenshotScale = 1.0F
    private const val screenshotQuality = 20

    fun getExecutionScreenshotPath(): String {
        return Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES).absolutePath + "/Screenshots/${date}"
    }

    fun getTestResult(): String {
        return "$currentTestCaseId,$currentTestResult \n"
    }

    fun takeScreenshot() {
        device.waitForIdle()
        device.takeScreenshot(File(getScreenshotDevicePath(), getScreenshotName()), screenshotScale, screenshotQuality)
    }

    fun takeScreenshot(screenshotName: String?) {
        device.takeScreenshot(File(getScreenshotDevicePath(), "$screenshotName.png"), screenshotScale, screenshotQuality)
    }

    fun setScreenshotsName(testcaseName: String) {
        currentTestCaseName = testcaseName
        count = 0
    }

    fun testCaseId(testCaseId: String) {
        currentTestCaseId = testCaseId
    }

    fun testResult(testResult: String) {
        currentTestResult = testResult
    }

    private fun getScreenshotName(): String = when (currentTestCaseName) {
        "" -> "${"Screenshot"}_${getCurrentTime()}.png"
        //TODO  else -> "$testClassName-${normalize(currentTestCaseName)}.png"
        else -> "testClassName-${normalize(currentTestCaseName)}.png"
    }

    private fun getCurrentTime(): String {
        //TODO return now().format(DateTimeFormatter.ofPattern("HHmmss"))
        return "HHmmss"
    }

    private fun getScreenshotDevicePath(): File? {
        val deviceScreenshotsPath = File(getExecutionScreenshotPath() + "/${currentTestResult}/$currentTestCaseId/")
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