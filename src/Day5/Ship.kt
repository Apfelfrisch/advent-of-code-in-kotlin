package Day5

fun shipFromInput(input: List<String>): Ship {
    val stacks = Array(9) { mutableListOf<Char>() }

    input.first().lines().forEach { line ->
        line.chunked(4).forEachIndexed { index, crate ->
            if (crate.contains("[")) {
                stacks[index].add(
                    crate.replace("[", "").replace("]", "").trim().first()
                )
            }
        }
    }

    return Ship(stacks)
}

class Ship (val stacks: Array<MutableList<Char>>) {
    fun moveCreates(amount:Int, from: Int, to: Int) {
        for (i in 1..amount) {
            stacks[to -1].add(0, stacks[from -1].removeFirst())
        }
    }

    fun moveCreates9001(amount:Int, from: Int, to: Int) {
        val tmp = mutableListOf<Char>()

        for (i in 1..amount) {
            tmp.add(stacks[from -1].removeFirst())
        }

        tmp.reversed().forEach {
            stacks[to -1].add(0, it)
        }
    }
}