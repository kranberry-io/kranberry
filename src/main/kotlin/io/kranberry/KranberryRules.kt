package io.kranberry

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import io.kranberry.environment.DeviceHandler.testEnvironmentProperties
import io.kranberry.environment.TestHandler.currentTestClassName
import io.kranberry.environment.TestHandler.currentTestMethodName
import io.kranberry.environment.TestHandler.device
import io.kranberry.environment.TestHandler.failedTestCount
import io.kranberry.environment.TestHandler.isANewTestsClass
import io.kranberry.environment.TestHandler.passedTestCount
import io.kranberry.environment.TestHandler.testClassName
import io.kranberry.environment.TestHandler.testResult
import io.kranberry.environment.TestHandler.updateSummary
import io.kranberry.log.Log
import io.kranberry.outputs.CsvHandler.writeCsvResult
import io.kranberry.outputs.ScreenshotHandler.setScreenshotsName
import io.kranberry.outputs.ScreenshotHandler.takeScreenshot
import org.junit.rules.TestWatcher
import org.junit.runner.Description

open class KranberryRules : TestWatcher() {
    var testClassPrefix = testEnvironmentProperties.testClassPrefix

    override fun failed(e: Throwable?, description: Description?) {
        failedTestCount++
        val methodName = description?.methodName

        setScreenshotsName("failed_$methodName")
        testResult("FAILED")
        takeScreenshot()
        Log.testFailed(e)
    }

    override fun starting(description: Description?) {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        currentTestClassName = description!!.className.removePrefix(testClassPrefix)
        currentTestMethodName = description.methodName

        setScreenshotsName(currentTestMethodName)

        when {
            testClassName != currentTestClassName -> {
                testClassName(currentTestClassName)
                Log.startClass()
            }
            else -> {
                isANewTestsClass = false
            }
        }
        Log.startTest()
    }

    override fun succeeded(description: Description?) {
        passedTestCount++
        testResult("PASSED")
        Log.testPassed(currentTestClassName, currentTestMethodName)
    }

    override fun finished(description: Description?) {
        updateSummary()
        writeCsvResult()
        Log.testSummary()
    }
}
