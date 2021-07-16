package io.kranberry

import android.util.Log
import io.kranberry.Color.WHITE
import io.kranberry.Color.YELLOW
import io.kranberry.Color.RED
import io.kranberry.Color.GREEN
import io.kranberry.Color.CYAN
import io.kranberry.Color.RESET
import io.kranberry.environment.DeviceHandler.testEnvironmentProperties
import io.kranberry.wrapper.BuildConfig

object Log {
    private val TAG = testEnvironmentProperties.logTag
    private val debugMode = BuildConfig.DEBUG

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

    fun print(msg: String) {
        Log.i(TAG, msg)
    }

    private fun print(msg: String, color: Color) {
        when {
            debugMode -> {
                Log.i(TAG, msg)
            }
            else -> {
                Log.i(TAG, color.ansi + msg + RESET.ansi)
            }
        }
    }
}
