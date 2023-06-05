package tictactoe
import java.lang.Double.parseDouble
fun displayBoard(input: List<MutableList<Char>>) {
    var countX = 0
    var countO = 0
    var countU = 0
    println("---------")
    println("| ${input[0].joinToString(" ")} |")
    println("| ${input[1].joinToString(" ")} |")
    println("| ${input[2].joinToString(" ")} |")
    println("---------")
    for (i in input.indices) {
        if (input[i][0].toString() == "X") ++countX
        if (input[i][0].toString() == "O") ++countO
        if (input[i][0].toString() == "_") ++countU
        if (input[i][1].toString() == "X") ++countX
        if (input[i][1].toString() == "O") ++countO
        if (input[i][1].toString() == "_") ++countU
        if (input[i][2].toString() == "X") ++countX
        if (input[i][2].toString() == "O") ++countO
        if (input[i][2].toString() == "_") ++countU
    }
    gameplay(input)
}
fun gameplay(input: List<MutableList<Char>>) {
    var turns = 1

    while (true) {
        var location = readln()

        try {
            val num = parseDouble(location)
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
            continue
        }
        val locationAsList = location.toList()
        val coord1 = locationAsList[0].code
        val coord2 = locationAsList[1].code
        if (input[coord1 - 1][coord2 - 1] == 'X' || input[coord1 - 1][coord2 - 1] == 'O') {
            println("This cell is occupied! Choose another one!")
            continue
        }

    }
}
fun winConditions(input: List<Char>, countX: Int, countO: Int, countU: Int) {
    var winX = false
    var winO = false
    var impossible = false

    if (input.subList(0, 3).joinToString("") == "XXX") winX = true // Top row
    if (input.subList(3, 6).joinToString("") == "XXX") winX = true // Middle row
    if (input.subList(6, 9).joinToString("") == "XXX") winX = true // Bottom row
    if (input[0].toString() + input[3] + input[6] == "XXX") winX = true // First column
    if (input[1].toString() + input[4] + input[7] == "XXX") winX = true // Second column
    if (input[2].toString() + input[5] + input[8] == "XXX") winX = true // Third column
    if (input[0].toString() + input[4] + input[8] == "XXX") winX = true // Diagonal
    if (input[2].toString() + input[4] + input[6] == "XXX") winX = true // Diagonal

    if (input.subList(0, 3).joinToString("") == "OOO") winO = true
    if (input.subList(3, 6).joinToString("") == "OOO") winO = true
    if (input.subList(6, 9).joinToString("") == "OOO") winO = true
    if (input[0].toString() + input[3] + input[6] == "OOO") winO = true
    if (input[1].toString() + input[4] + input[7] == "OOO") winO = true
    if (input[2].toString() + input[5] + input[8] == "OOO") winO = true
    if (input[0].toString() + input[4] + input[8] == "OOO") winO = true
    if (input[2].toString() + input[4] + input[6] == "OOO") winO = true

    if (countO - countX !in -1..1 || winX && winO) {
        impossible = true
        println("Impossible")
    } // Neither X nor O can have too many turns and both cannot win
    if (winX && !winO) println("X wins")
    if (!winX && winO) println("O wins")
    if (!winX && !winO && countU == 0) println("Draw")
    if (!winX && !winO && !impossible && countU > 0) println("Game not finished")
}
fun main() {
    val input = readln()
    val board = mutableListOf(
        mutableListOf(input[0], input[1], input[2]),
        mutableListOf(input[3], input[4], input[5]),
        mutableListOf(input[6], input[7], input[8])
    )
    displayBoard(board)


}