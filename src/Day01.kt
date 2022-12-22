import java.io.File

private fun lastItems(input: List<String>, number: Int): List<Int> {
    return input.map { it.lines().sumOf { it.toInt() } }
        .sortedDescending()
        .take(number)
}

fun main() {
    fun part1(input: List<String>): Int {
        return lastItems(input, 1).sum()
    }

    fun part2(input: List<String>): Int {
        return lastItems(input, 3).sum()
    }

    // val input = readInput("Day01")
    val input = File("inputs/Day01.txt").readText().split("\n\n")
    part1(input).println()
    part2(input).println()
}