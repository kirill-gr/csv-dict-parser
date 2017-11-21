package ru.grushetsky

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

internal class AppTest {
    @Test
    fun `should return two strings when array of two strings passed`() {
        val fileName = "file"
        val args = arrayOf(fileName)

        val fileNameActual = parseArgs(args)

        assertEquals(fileName, fileNameActual)
    }

    @Test
    fun `should throw if file doesn't exist`() {
        assertThrows(
                IllegalArgumentException::class.java,
                { getInputFile("test") },
                "File test doesn't exist"
        )
    }

    @TestFactory
    fun `should throw if N of arguments doesn't match`() = listOf(
            arrayOf<String>() to "No arguments specified",
            arrayOf("foo", "bar") to "Too many arguments"
    ).map { (arguments, errorMessage) ->
        DynamicTest.dynamicTest("on ${arguments.size} arguments -> $errorMessage") {
            assertThrows(
                    IllegalArgumentException::class.java,
                    { parseArgs(arguments) },
                    errorMessage
            )
        }
    }
}