package ru.grushetsky

import java.io.File

fun main(args: Array<String>) {
    val fileName = parseArgs(args)
    val inputFile = getInputFile(fileName)
    val outputFile = getOutputFile(fileName)
    parse()
    saveOutputFile()
}

fun parseArgs(args: Array<String>): String {
    when (args.size) {
        0 -> throw IllegalArgumentException("No arguments specified")
        1 -> return args.first()
        else -> throw IllegalArgumentException("Too many arguments")
    }
}

fun saveOutputFile() {
    // TODO save parsed data to an output file
    TODO("not implemented")
}

fun parse() {
    // TODO read file and open output file
    // TODO parse row
    TODO("not implemented")
}

fun getInputFile(fileName: String): File {
    val file = File(fileName)
    if (!file.canRead()) {
        throw IllegalArgumentException("File $fileName doesn't exist or is not accessible")
    }
    return file
}

fun getOutputFile(fileName: String): File {
    val outputFileName = fileName + ".json"
    val file = File(outputFileName)
    if (file.exists()) {
        throw IllegalArgumentException("File $outputFileName already exists, delete it first")
    }
    if (!file.canWrite()) {
        throw IllegalArgumentException("File $outputFileName is not writable")
    }
    return file
}
