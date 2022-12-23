import java.io.File

val input = File("inputs/Day04.txt").readLines()

fun main() {
    val part1 = input.mapToPairs().count { isFullyOverlapped(it) }

    println(part1)

    val part2 = input.mapToPairs().count { countOverlapping(it) > 0 }

    println(part2)
}

private fun List<String>.mapToPairs() = this.map { it.split(",").first().toRange() to it.split(",").last().toRange() }

private fun String.toRange(): IntRange {
    val (a, b) = this.split("-")
    return a.toInt()..b.toInt()
}

private fun countOverlapping(pair: Pair<IntRange, IntRange>) = pair.first.intersect(pair.second).size

private fun isFullyOverlapped(pair: Pair<IntRange, IntRange>): Boolean {
    if (pair.first.first <= pair.second.first && pair.first.last >= pair.second.last) {
        return true
    }

    if (pair.second.first <= pair.first.first && pair.second.last >= pair.first.last) {
        return true
    }

    return false
}
