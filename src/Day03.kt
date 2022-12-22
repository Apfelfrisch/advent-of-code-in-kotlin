import java.io.File

private fun Char.getPriority(): Int {
    ('a'..'z').forEachIndexed { index, c ->
        if (c == this) {
            return index + 1
        }
    }

    ('A'..'Z').forEachIndexed { index, c ->
        if (c == this) {
            return index + 27
        }
    }

    error("Char $this is invalid")
}

fun main() {
    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf { backpack ->
            val (first, second, third) = backpack

            first
                .asIterable()
                .intersect(second.asIterable().toSet())
                .intersect(third.asIterable().toSet())
                .single()
                .getPriority()
        }
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { backpack ->
            val firstCompartment = backpack.substring(0, backpack.length / 2)
            val secondCompartment = backpack.substring(backpack.length / 2)

            val sharedItem= firstCompartment.asIterable().intersect(secondCompartment.asIterable().toSet()).single()

            sharedItem.getPriority()
        }
    }

    val input = File("inputs/Day03.txt").readLines()

    part1(input).println()
    part2(input).println()
}
