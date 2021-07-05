package io.kranberry.environment

import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import java.io.FileInputStream

object PropertyReader {

    lateinit var propertiesFile: FileInputStream
    private const val PROPERTIES_FILE_PATH = "kranberry.properties.json"

    fun getProperty(): TestEnvironmentProperties {
        val jsonProperties = readFileAsText(PROPERTIES_FILE_PATH)
        return Gson().fromJson(jsonProperties, TestEnvironmentProperties::class.java)
    }

    private fun readFileAsText(fileName: String): String {
        try {
            return InstrumentationRegistry
                .getInstrumentation()
                .context
                .resources
                .assets
                .open(fileName)
                .bufferedReader()
                .readText()

        } catch (e: Exception) {
            throw RuntimeException(
                "kranberry.json configuration file not found in /src/androidTest/assets path." +
                        "For more information access: https://github.com/kranberry-io/kranberry#kranberry-properties-file"
            )
        }
    }
}