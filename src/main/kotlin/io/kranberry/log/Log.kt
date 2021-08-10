package io.kranberry.log

import android.util.Log
import io.kranberry.environment.DeviceHandler.testEnvironmentProperties
import io.kranberry.environment.TestHandler.currentTestClassName
import io.kranberry.environment.TestHandler.currentTestMethodName
import io.kranberry.environment.TestHandler.failedRate
import io.kranberry.environment.TestHandler.failedTestCount
import io.kranberry.environment.TestHandler.passedRate
import io.kranberry.environment.TestHandler.passedTestCount
import io.kranberry.environment.TestHandler.totalTestCount
import io.kranberry.log.Color.*

object Log {
    private val tag = testEnvironmentProperties.logTag
    private val printColoredLogs = testEnvironmentProperties.printColoredLogs

    fun info(msg: String) {
        print(msg, RESET)
    }

    fun alert(msg: String) {
        print(msg, YELLOW)
    }

    fun success(msg: String) {
        print(msg, GREEN)
    }

    fun error(msg: String) {
        print(msg, RED)
    }

    fun message(msg: String) {
        print(msg, CYAN)
    }

    fun startTest() {
        when {
            printColoredLogs -> {
                Log.i(
                    tag, coloredTestLogPrefix() +
                            "${YELLOW.ansi}Starting test!${RESET.ansi}"
                )
            }
            else -> {
                Log.i(tag, "$currentTestClassName | $currentTestMethodName: Starting test!")
            }
        }
    }

    fun startClass() {
        when {
            printColoredLogs -> {
                Log.i(
                    tag, coloredClassLogPrefix() +
                            "${YELLOW.ansi}Starting test!${RESET.ansi}"
                )
            }
            else -> {
                Log.i(tag, "$currentTestClassName | Starting test!")
            }
        }
    }

    fun testFailed(e: Throwable?) {
        when {
            printColoredLogs -> {
                Log.i(
                    tag, coloredTestLogPrefix() +
                            "${RED.ansi}The test failed because:${RESET.ansi}", e
                )
            }
            else -> {
                Log.i(
                    tag, "$currentTestClassName | " +
                            "$currentTestMethodName: The test failed because:", e
                )
            }
        }
    }

    fun testPassed(currentTestClassName: String, currentTestMethodName: String) {
        when {
            printColoredLogs -> {
                Log.i(
                    tag, coloredTestLogPrefix() +
                            "${GREEN.ansi}Test successfully executed!${RESET.ansi}"
                )
            }
            else -> {
                Log.i(
                    tag, "$currentTestClassName | " +
                            "$currentTestMethodName: Test successfully executed!"
                )
            }
        }
    }

    private fun coloredTestLogPrefix(): String {
        return "${BLUE.ansi}${currentTestClassName}${RESET.ansi}" +
                " | ${MAGENTA.ansi}${currentTestMethodName}:${RESET.ansi} "
    }

    private fun coloredClassLogPrefix(): String {
        return "${BLUE.ansi}${currentTestClassName}${RESET.ansi} | "
    }

    private fun print(msg: String, color: Color) {
        when {
            printColoredLogs -> {
                Log.i(tag, coloredTestLogPrefix() + color.ansi + msg + RESET.ansi)
            }
            else -> {
                Log.i(tag, msg)
            }
        }
    }

    fun testSummary() {
        when {
            printColoredLogs -> {
                Log.i(
                    tag, "\n${BLUE.ansi}Execution Summary:${RESET.ansi}\n" +
                            "Executed: $totalTestCount | " +
                            "${GREEN.ansi}Passed: $passedTestCount ($passedRate%)${RESET.ansi} | " +
                            "${RED.ansi}Failed: $failedTestCount ($failedRate%)${RESET.ansi}\n"
                )
            }
            else -> {
                Log.i(
                    tag, "\nExecution Summary:\n" +
                            "Executed: $totalTestCount | " +
                            "Passed: $passedTestCount ($passedRate%) | " +
                            "Failed: $failedTestCount ($failedRate%)\n"
                )
            }
        }
    }
}
