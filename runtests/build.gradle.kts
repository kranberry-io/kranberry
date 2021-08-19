plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("maven-publish")
    id("com.gradle.plugin-publish") version "0.15.0"
}
apply(from = "../tools/lib-version.gradle")
apply(from = "../versions.gradle")

pluginBundle {
    website = "https://github.com/kranberry-io"
    vcsUrl = "https://github.com/kranberry-io/kranberry"
    tags = listOf("tests", "android", "kotlin", "ui-tests")
}

group = "io.github.kranberry-io"
version = project.extra["PUBLISH_VERSION"] ?: ""

gradlePlugin {
    plugins {
        create("runKranberryTestsPlugin") {
            id = "io.github.kranberry-io.runtests"
            displayName = "Run kranberry tests plugin"
            description = "Plugin that gives the ability of running kranberry tests in a easy way"
            implementationClass = "io.kranberry.RunTestsPlugin"
        }
    }
}

publishing {
    repositories {
        maven {
            name = "localPluginRepository"
            url = uri("../local-plugin-repository")
        }
    }
}

dependencies {
    val kotlinVersion = (project.extra["kotlin_version"] as String?) ?: ""
    implementation(kotlin("stdlib", kotlinVersion))
}