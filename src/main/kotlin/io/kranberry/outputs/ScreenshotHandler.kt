package io.kranberry.outputs

import io.kranberry.environment.DeviceHandler
import io.kranberry.environment.DeviceHandler.getTestsOutputsDevicePath
import io.kranberry.environment.TestHandler.currentTestCaseId
import io.kranberry.environment.TestHandler.currentTestResult
import io.kranberry.environment.TestHandler.getCurrentTime
import io.kranberry.environment.TestHandler.testClassName
import java.io.File

object ScreenshotHandler {

    private var count: Int = 0
    private val device = DeviceHandler.getDevice()
    private var currentTestCaseName = ""


    private const val screenshotScale = 1.0F
    private const val screenshotQuality = 20
    private const val screenshotPath = "/screenshots"


    private fun getExecutionScreenshotPath(): String {
        return getTestsOutputsDevicePath() + screenshotPath
    }

    fun getTestResult(): String {
        return when (currentTestCaseId) {
            "" -> {
                "---,$currentTestResult\n"
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

    fun getScreenshotDevicePath(): File {
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