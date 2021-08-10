package io.kranberry.outputs

import android.os.Environment
import android.os.Environment.DIRECTORY_PICTURES
import io.kranberry.environment.TestHandler
import io.kranberry.environment.TestHandler.date
import io.kranberry.outputs.ScreenshotHandler.getTestResult
import java.io.File

object CsvHandler {

    private val csvFileName = "/results.csv"

    private fun getExecutionCsvPath(): String {
        return Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES).absolutePath +
                "/Screenshots/$date"
    }

    private fun getCsvDevicePath(): String {
        val deviceCsvPath =
            File(getExecutionCsvPath())
        if (!deviceCsvPath.exists()) deviceCsvPath.mkdirs()
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