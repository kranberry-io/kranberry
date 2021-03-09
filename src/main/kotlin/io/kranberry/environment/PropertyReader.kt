package io.kranberry.environment

import androidx.test.platform.app.InstrumentationRegistry
import java.io.FileInputStream
import java.lang.System.getProperty
import java.nio.file.Paths
import java.util.*

class PropertyReader {

    fun getProperty() {
/*        val properties = Properties()

        val propertiesFile = "kranberry.properties"


        val inputStream = FileInputStream(propertiesFile)
        properties.load(inputStream)*/

        //val properties = Properties()
        val properties = readFileAsText("kranberry.properties")
        println(properties)

        //properties.forEach{(k, v) -> println("key = $k, value = $v")}
    }

    private fun readFileAsText(fileName: String): String {
        return InstrumentationRegistry
            .getInstrumentation()
            .context
            .resources
            .assets
            .open(fileName)
            .bufferedReader()
            .readText()
    }
}