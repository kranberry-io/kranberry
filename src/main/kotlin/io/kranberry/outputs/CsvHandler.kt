package io.kranberry.outputs

import android.os.Environment
import androidx.test.platform.app.InstrumentationRegistry
import io.kranberry.environment.TestHandler
import io.kranberry.environment.TestHandler.date
import io.kranberry.log.Log
import io.kranberry.outputs.ScreenshotHandler.getTestResult
import java.io.File

object CsvHandler {

    private const val csvFileName = "/results.csv"

    private fun getExecutionCsvPath(): String {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        Log.info("External files dir for app: " +
                "${context.externalMediaDirs.firstOrNull()?.absolutePath}")
        Log.info("External storage state: " +
                Environment.getExternalStorageState(context.externalMediaDirs.firstOrNull())
        )
        val csvPath = context.externalMediaDirs.firstOrNull()?.absolutePath

        Log.info("CSV path: $csvPath")
        return (csvPath ?:
                throw IllegalStateException("It was not possible to access apps external files dir")) +
                "/Screenshots/$date"
    }

    fun getCsvDevicePath(): String {
        val deviceCsvPath =
            File(getExecutionCsvPath())
        when {
            !deviceCsvPath.exists() -> {
                Log.alert("${InstrumentationRegistry
                    .getInstrumentation().context}")
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