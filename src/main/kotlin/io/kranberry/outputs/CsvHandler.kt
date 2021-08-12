package io.kranberry.outputs

import android.app.Instrumentation
import android.content.Context
import android.os.Build
import android.os.Environment
import android.os.Environment.DIRECTORY_PICTURES
import androidx.annotation.RequiresApi
import androidx.test.platform.app.InstrumentationRegistry
import io.kranberry.environment.TestHandler
import io.kranberry.environment.TestHandler.date
import io.kranberry.log.Log
import io.kranberry.outputs.ScreenshotHandler.getTestResult
import java.io.File

object CsvHandler {

    private const val csvFileName = "/results.csv"

    private fun getExecutionCsvPath(): String {
        return Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES).absolutePath +
                "/Screenshots/$date"
    }

    fun getCsvDevicePath(): String {

        val deviceCsvPath: File =
            File(getExecutionCsvPath())
        when {
            !deviceCsvPath.exists() -> {
                Log.alert("${InstrumentationRegistry
                    .getInstrumentation().context}")
                deviceCsvPath.mkdirs()}
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