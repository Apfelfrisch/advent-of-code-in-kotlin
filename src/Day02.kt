import Hand.*
import java.io.File

enum class Hand(val score: Int) {
    Rock(1),
    Paper(2),
    Scissors(3);
}

enum class Result(val score: Int) {
    Loose(0),
    Draw(3),
    Win(6),
}

private fun Hand.winningHand(): Hand {
    return when(this) {
        Rock -> Scissors
        Paper -> Rock
        Scissors -> Paper
    };
}

private fun Hand.loosingHand(): Hand {
    return when(this) {
        Rock -> Paper
        Paper -> Scissors
        Scissors -> Rock
    };
}

private fun Char.toHand(): Hand {
    return when (this) {
        'A', 'X' -> Hand.Rock
        'B', 'Y' -> Hand.Paper
        'C', 'Z' -> Hand.Scissors
        else -> {
            error("Unknown Hand $this")
        }
    }
}

private fun Char.toResult(): Result {
    return when (this) {
        'X' -> Result.Loose
        'Y' -> Result.Draw
        'Z' -> Result.Win
        else -> {
            error("Unknown Result $this")
        }
    }
}

private fun Hand.getMissingHand(myResult: Result): Hand {
    return when(myResult) {
        Result.Loose -> this.winningHand()
        Result.Draw -> this
        Result.Win -> this.loosingHand()
    }
}

private fun Hand.playsAgainst(opponent: Hand): Result {

    if (opponent == this) {
        return Result.Draw
    }

    if (opponent.winningHand() == this) {
        return Result.Loose
    }

    return Result.Win
}

private fun partOne(input: List<String>): Int {
    return input.sumOf { game -> Int
        val opponentsHand = game[0].toHand();
        val myHand = game[2].toHand();

        myHand.playsAgainst(opponentsHand).score + myHand.score
    };
}

private fun partTwo(input: List<String>): Int {

    return input.sumOf { game -> Int
        val opponentHand = game[0].toHand();
        val result = game[2].toResult();

        result.score + opponentHand.getMissingHand(result).score
    }
}

fun main() {
    val input = File("inputs/Day02.txt").readLines()

    println(partOne(input))
    println(partTwo(input))
}