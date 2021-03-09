package io.kranberry.environment

import java.io.FileInputStream
import java.lang.System.getProperty
import java.util.*

class PropertyReader {

    fun getProperty() {
        val properties = Properties()

        val propertiesFile = getProperty("user.dir") + "kranberry.properties"

        val inputStream = FileInputStream(propertiesFile)
        properties.load(inputStream)

        properties.forEach{(k, v) -> println("key = $k, value = $v")}
    }
}