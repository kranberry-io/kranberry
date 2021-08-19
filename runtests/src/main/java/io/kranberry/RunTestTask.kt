package io.kranberry

import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.TaskAction

class RunTestTask: Exec() {

    @TaskAction
    fun runKranberryTest() {
        println("hello from runKranberryTest")
    }
}