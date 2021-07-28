package io.kranberry

import android.util.Log
import io.kranberry.Color.*
import io.kranberry.environment.DeviceHandler.testEnvironmentProperties

object Log {
    private val tag = testEnvironmentProperties.logTag
    private val printColoredLogs = testEnvironmentProperties.printColoredLogs

    fun info(msg: String) {
        print(msg, WHITE)
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

    fun startTest(currentTestClassName: String, currentTestMethodName: String ){
        when {
            printColoredLogs -> {
                Log.i(tag, "${BLUE.ansi}${currentTestClassName}${RESET.ansi}" +
                        " | ${MAGENTA.ansi}${currentTestMethodName}:${RESET.ansi} " +
                        "${YELLOW.ansi}Starting test!${RESET.ansi}")
            }
            else -> {
                Log.i(tag, "$currentTestClassName | $currentTestMethodName: Starting test!")
            }
        }
    }

    fun testFailed(currentTestClassName: String, currentTestMethodName: String, e: Throwable? ){
        when {
            printColoredLogs -> {
                Log.i(tag, "${BLUE.ansi}${currentTestClassName}${RESET.ansi}" +
                        " | ${MAGENTA.ansi}${currentTestMethodName}:${RESET.ansi} " +
                        "${RED.ansi}The test failed because:${RESET.ansi}", e)
            }
            else -> {
                Log.i(tag, "$currentTestClassName | " +
                        "$currentTestMethodName: The test failed because:", e)
            }
        }
    }

    fun testPassed(currentTestClassName: String, currentTestMethodName: String ){
        when {
            printColoredLogs -> {
                Log.i(tag, "${BLUE.ansi}${currentTestClassName}${RESET.ansi}" +
                        " | ${MAGENTA.ansi}${currentTestMethodName}:${RESET.ansi} " +
                        "${GREEN.ansi}Test successfully executed!${RESET.ansi}")
            }
            else -> {
                Log.i(tag, "$currentTestClassName | " +
                        "$currentTestMethodName: Test successfully executed!")
            }
        }
    }

    private fun print(msg: String, color: Color) {
        when {
            printColoredLogs -> {
                Log.i(tag, color.ansi + msg + RESET.ansi)
            }
            else -> {
                Log.i(tag, msg)
            }
        }
    }

}
