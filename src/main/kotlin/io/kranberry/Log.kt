package io.kranberry

import android.util.Log
import io.kranberry.Color.*

object Log {
    const val TAG = "KRANBERRY"

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

    fun print(msg: String){
        Log.i(TAG, msg)
    }

    private fun print(msg: String, color: Color) {
        Log.i(TAG, color.ansi + msg + RESET.ansi)
    }
}