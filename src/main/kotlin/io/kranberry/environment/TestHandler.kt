package io.kranberry.environment

import androidx.test.uiautomator.UiDevice
import kotlin.math.round

object TestHandler {

    lateinit var device: UiDevice
    lateinit var currentTestMethodName: String
    lateinit var currentTestClassName: String
    var testClassName = ""
    var currentTestCaseId = ""

    var currentTestResult = "PASSED"

    var failedTestCount: Int = 0
    var passedTestCount: Int = 0
    var totalTestCount: Int = 0
    var passedRate: Double = 0.0
    var failedRate: Double = 0.0

    var reportHasHeader: Boolean = false


    fun testClassName(testClassName: String) {
        this.testClassName = testClassName
    }

    fun updateSummary() {
        totalTestCount++

        passedRate = round((passedTestCount.toDouble() / totalTestCount) * 100)
        failedRate = round((failedTestCount.toDouble() / totalTestCount) * 100)
    }

    fun testCaseId(testCaseId: String) {
        currentTestCaseId = testCaseId
    }

    fun testResult(testResult: String) {
        currentTestResult = testResult
    }
}
