package io.kranberry

import io.kranberry.ScreenshotHandler.getExecutionScreenshotPath
import io.kranberry.ScreenshotHandler.getTestResult
import io.kranberry.ScreenshotHandler.setScreenshotsName
import io.kranberry.ScreenshotHandler.takeScreenshot
import io.kranberry.ScreenshotHandler.testResult
import io.kranberry.environment.DeviceHandler.testEnvironmentProperties
import io.kranberry.environment.TestHandler.currentTestClassName
import io.kranberry.environment.TestHandler.currentTestMethodName
import io.kranberry.environment.TestHandler.failedTestCount
import io.kranberry.environment.TestHandler.passedTestCount
import io.kranberry.environment.TestHandler.reportHasHeader
import io.kranberry.environment.TestHandler.testClassName
import io.kranberry.environment.TestHandler.totalTestCount
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import java.io.File
import kotlin.math.round

open class TestRules() : TestWatcher() {
    var testClassPrefix = testEnvironmentProperties.testClassPrefix
    var kranberry = "kranberry"


    override fun failed(e: Throwable?, description: Description?) {
        val methodName = description?.methodName

        setScreenshotsName("failed_$methodName")
        testResult("FAILED")
        takeScreenshot()
        Log.testFailed(currentTestClassName, currentTestMethodName, e)

    }

    override fun starting(description: Description?) {

        currentTestClassName = description!!.className.removePrefix(testClassPrefix)
        currentTestMethodName = description.methodName

        if (testClassName != currentTestClassName) {
            testClassName(currentTestClassName)
            Log.alert("Starting tests of $currentTestClassName")
        }
       Log.startTest(currentTestClassName, currentTestMethodName)
    }

    override fun succeeded(description: Description?) {
        testResult("PASSED")
        Log.testPassed(currentTestClassName, currentTestMethodName)
    }

    override fun finished(description: Description?) {
        totalTestCount++
        writeResult()
        val passedRate = round((passedTestCount / totalTestCount)*100)
        val failedRate = round((failedTestCount / totalTestCount)*100)

        Log.info("\nExecution Summary:")
        Log.info("EXECUTED: ${totalTestCount.toInt()}")
        Log.success("PASSED: ${passedTestCount.toInt()} ($passedRate%)")
        Log.error("FAILED: ${failedTestCount.toInt()} ($failedRate%)")
    }

    private fun writeResult() {
        if(!reportHasHeader){
            File(getExecutionScreenshotPath() + "/results.csv")
                .appendText("CLASS,TEST_METHOD,RESULT\n")
            reportHasHeader = true
        }
        File(getExecutionScreenshotPath() + "/results.csv")
            .appendText("$currentTestClassName,$currentTestMethodName," + getTestResult())
    }
}