package ru.grushetsky

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

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
                {getInputFile("test")},
                "File test doesn't exist"
        )
    }

}