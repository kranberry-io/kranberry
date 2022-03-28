package io.kranberry

import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property

interface RunTestsPluginExtension {
    val packageName: Property<String>
    val packageTests: Property<String>
    val applicationId: Property<String>
    val apkOutputPath: Property<String>
    val androidTestApkOutputPath: Property<String>
    val testsRunner: Property<String>
}

class RunTestsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create("kranberryTests", RunTestsPluginExtension::class.java)
        extension.run {
            val assemble = project.tasks.findByName("assemble")
            val assembleAndroidTest = project.tasks.findByName("assembleAndroidTest")

            val getKranberryTestsResults = project.task("getKranberryTestsResults") { task ->
                task.doLast {
                    project.exec {
                        // Pull results
                        val resultsPackage = applicationId.getOrElse(packageName.get())
                        val pullPath = "/storage/emulated/0/Android/media/$resultsPackage"
                        it.commandLine("bash", "-l", "-c", "rm -rf kranberry-outputs")
                        it.commandLine("bash", "-l", "-c", "mkdir kranberry-outputs")
                        it.commandLine("bash", "-l", "-c", "adb pull $pullPath kranberry-outputs")
                    }
                }
            }

            val installKranberryApks = project.task("installKranberryApks") { task ->
                task.doFirst {
                    project.exec {
                        // Install App APK
                        if (apkOutputPath.isPresent) {
                            println("Install APK: ${apkOutputPath.get()}")
                            it.commandLine(
                                "bash", "-l", "-c",
                                "pwd"
                            )
                            it.commandLine(
                                "bash", "-l", "-c",
                                "adb install ${apkOutputPath.get()}"
                            )
                        }
                    }
                }
                task.doLast {
                    println("Installed APKs")
                }
            }.dependsOn(assemble)
                .mustRunAfter(assemble)

            val installKranberryTestApks = project.task("installKranberryTestApks") { task ->
                task.doFirst {
                    project.exec {
                        // Install Android Test APK
                        if (androidTestApkOutputPath.isPresent) {
                            println("Install Android Test: ${androidTestApkOutputPath.get()}")
                            it.commandLine(
                                "bash", "-l", "-c",
                                "pwd"
                            )
                            it.commandLine(
                                "bash", "-l", "-c",
                                "adb install ${androidTestApkOutputPath.get()}"
                            )
                        }
                    }
                }
                task.doLast {
                    println("Installed Test APKs")
                }
            }.dependsOn(installKranberryApks, assembleAndroidTest)
                .mustRunAfter(installKranberryApks, assembleAndroidTest)

            project.task("runKranberryTests") { task ->
                task.doLast {
                    if (packageName.isPresent.not()) {
                        throw GradleException("Package name must be set to run runKranberryTests Gradle task")
                    }

                    project.exec {
                        // Clean up logcat
                        it.commandLine("bash", "-l", "-c",
                            "adb shell logcat -b all -c")

                        // Configure logcat
                        it.commandLine("bash", "-c",
                            "adb logcat *:S KRANBERRY_LOG:V & LOGCAT_PID=\$\$!",)

                        // Run tests
                        val testsPackage = packageTests.getOrElse(packageName.get())
                        it.commandLine("bash", "-c",
                            "adb shell am instrument -w -e package ${packageName.get()} ${testsPackage}/${testsRunner.getOrElse("androidx.test.runner.AndroidJUnitRunner")}" )
                    }
                }.dependsOn(installKranberryTestApks)
                    .mustRunAfter(installKranberryTestApks)
                    .finalizedBy(getKranberryTestsResults)
            }
        }
    }
}