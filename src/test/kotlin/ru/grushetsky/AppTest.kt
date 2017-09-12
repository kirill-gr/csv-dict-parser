package ru.grushetsky

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AppTest {
    @Test
    fun `should return two strings when array of two strings passed`() {
        val fileName = "file"
        val dirName = "dir"
        val args = arrayOf(fileName, dirName)

        val (fileNameActual, dirNameActual) = parseArgs(args)

        assertEquals(fileName, fileNameActual)
        assertEquals(dirName, dirNameActual)
    }
}