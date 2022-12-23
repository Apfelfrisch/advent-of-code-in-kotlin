import kotlin.system.exitProcess

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

fun Any?.dd(): Unit {
    kotlin.io.println(this)
    exitProcess(1)
}