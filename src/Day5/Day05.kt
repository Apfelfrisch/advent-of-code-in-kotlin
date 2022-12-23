package Day5

import java.io.File

private val input: List<String> = File("inputs/Day05.txt").readText().split("\n\n")

fun main() {
    val shipOne = shipFromInput(input)
    val shipTwo = shipFromInput(input)

    parseMovement(input).forEach {
        val amount = it[0]
        val from = it[1]
        val to = it[2]

        shipOne.moveCreates(amount, from, to)

        shipTwo.moveCreates9001(amount, from, to)
    }

    val part1 = shipOne.stacks.joinToString("") { it.first().toString() }
    val part2 = shipTwo.stacks.joinToString("") { it.first().toString() }

    check("DHBJQJCCW" == part1)
    check("WJVRLSJJT" == part2)
}

private fun parseMovement(input: List<String>): List<List<Int>> {
    return input.last().lines().map { line ->
        line
            .split(" ")
            .filterNot {
                it.contains("move") || it.contains("from") || it.contains("to")
            }
            .map { it.toInt() }
    }
}