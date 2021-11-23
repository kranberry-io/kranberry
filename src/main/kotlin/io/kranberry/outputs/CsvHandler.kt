package io.kranberry.outputs

import io.kranberry.environment.DeviceHandler.getTestsOutputsDevicePath
import io.kranberry.environment.TestHandler
import io.kranberry.log.Log
import io.kranberry.outputs.ScreenshotHandler.getTestResult
import java.io.File

object CsvHandler {

    private const val csvFolderName = "/csv"
    private const val csvFileName = "/results.csv"

    private fun getExecutionCsvPath(): String {
        return getTestsOutputsDevicePath() + csvFolderName
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
        val csvFilePath = getCsvDevicePath() + csvFileName
        return File(csvFilePath)
    }

    fun writeCsvResult() {
        if (!TestHandler.reportHasHeader) {
            csvResultFile()
                .appendText("sep=,\nTEST_CLASS,TEST_METHOD,TEST_ID,RESULT\n")
            TestHandler.reportHasHeader = true
        }
        csvResultFile()
            .appendText("${TestHandler.currentTestClassName},${TestHandler.currentTestMethodName}," + getTestResult())
    }
}