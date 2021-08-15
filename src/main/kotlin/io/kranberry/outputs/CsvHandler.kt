package io.kranberry.outputs

import io.kranberry.environment.DeviceHandler.getTestsOutputsDevicePath
import io.kranberry.environment.TestHandler
import io.kranberry.outputs.ScreenshotHandler.getTestResult
import java.io.File

object CsvHandler {

    private const val csvFileName = "/results.csv"

    private fun getExecutionCsvPath(): String {
        return getTestsOutputsDevicePath() + csvFileName
    }

    fun getCsvDevicePath(): String {
        val deviceCsvPath =
            File(getExecutionCsvPath())
        when {
            !deviceCsvPath.exists() -> {
                deviceCsvPath.mkdirs()
            }
        }
        return deviceCsvPath.toString()
    }

    private fun csvResultFile(): File {
        return File("${getCsvDevicePath()}$csvFileName")
    }

    fun writeCsvResult() {
        if (!TestHandler.reportHasHeader) {
            csvResultFile()
                .appendText("TEST_CLASS,TEST_METHOD,RESULT\n")
            TestHandler.reportHasHeader = true
        }
        csvResultFile()
            .appendText("${TestHandler.currentTestClassName},${TestHandler.currentTestMethodName}," + getTestResult())
    }
}