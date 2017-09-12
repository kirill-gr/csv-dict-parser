package ru.grushetsky

fun main(args: Array<String>) {
    // TODO parse input params
    val (fileName, outputPath) = parseArgs(args)
    // TODO check file exists
    checkExists(fileName)
    // TODO create output file
    createOutputFile()
    // TODO read file and open output file
    // TODO parse row
    parse()
    // TODO save parsed data to an output file
    saveOutputFile()
}

fun parseArgs(args: Array<String>): Pair<String, String> {
    return Pair(args.first(), args[1])
}

fun saveOutputFile() {
    TODO("not implemented")
}

fun parse() {
    TODO("not implemented")
}

fun createOutputFile() {
    TODO("not implemented")
}

fun checkExists(fileName: String): Boolean {
    TODO("not implemented")
}
