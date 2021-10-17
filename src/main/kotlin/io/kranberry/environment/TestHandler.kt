package io.kranberry.environment

import androidx.test.uiautomator.UiDevice
import java.text.SimpleDateFormat
import java.util.*
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
    var isANewTestsClass: Boolean = true

    private val dateFormat = SimpleDateFormat("yyyy_MM_dd_HHmmss")
    private val now = Date()
    val date: String = dateFormat.format(now)


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

    fun getCurrentTime(): String {
        val formatCurrentTime = SimpleDateFormat("HHmmss")
        return formatCurrentTime.format(now)
    }
}
