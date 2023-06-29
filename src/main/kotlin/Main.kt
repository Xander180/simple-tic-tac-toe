package tictactoe

import kotlin.system.exitProcess

var PLAYER_TURN = 1
var COUNT_U = 0
fun displayBoard(board: List<MutableList<Char>>) {
    var countX = 0
    var countO = 0
    println("---------")
    println("| ${board[0].joinToString(" ")} |")
    println("| ${board[1].joinToString(" ")} |")
    println("| ${board[2].joinToString(" ")} |")
    println("---------")
    for (i in board.indices) {
        if (board[i][0].toString() == "X") ++countX
        if (board[i][0].toString() == "O") ++countO
        if (board[i][0].toString() == " ") ++COUNT_U
        if (board[i][1].toString() == "X") ++countX
        if (board[i][1].toString() == "O") ++countO
        if (board[i][1].toString() == " ") ++COUNT_U
        if (board[i][2].toString() == "X") ++countX
        if (board[i][2].toString() == "O") ++countO
        if (board[i][2].toString() == " ") ++COUNT_U
    }
    var winX = false
    var winO = false

    if (board[0].joinToString("") == "XXX") winX = true // Top row
    if (board[1].joinToString("") == "XXX") winX = true // Middle row
    if (board[2].joinToString("") == "XXX") winX = true // Bottom row
    if (board[0][0].toString() + board[1][0] + board[2][0] == "XXX") winX = true // First column
    if (board[0][1].toString() + board[1][1] + board[2][1] == "XXX") winX = true // Second column
    if (board[0][2].toString() + board[1][2] + board[2][2] == "XXX") winX = true // Third column
    if (board[0][0].toString() + board[1][1] + board[2][2] == "XXX") winX = true // Diagonal
    if (board[0][2].toString() + board[1][1] + board[2][0] == "XXX") winX = true // Diagonal

    if (board[0].joinToString("") == "OOO") winO = true
    if (board[1].joinToString("") == "OOO") winO = true
    if (board[2].joinToString("") == "OOO") winO = true
    if (board[0][0].toString() + board[1][0] + board[2][0] == "OOO") winO = true
    if (board[0][1].toString() + board[1][1] + board[2][1] == "OOO") winO = true
    if (board[0][2].toString() + board[1][2] + board[2][2] == "OOO") winO = true
    if (board[0][0].toString() + board[1][1] + board[2][2] == "OOO") winO = true
    if (board[0][2].toString() + board[1][1] + board[2][0] == "OOO") winO = true

    if (winX || winO || PLAYER_TURN == 10) {
        winConditions(winX, winO)
    } else {
        gameplay(board)
    }

}

fun gameplay(board: List<MutableList<Char>>) {
    while (PLAYER_TURN < 10 && COUNT_U > 0) {
        val location = readln()
        val locationAsList = location.replace(" ", "").toList()


        if (location.split(" ")[0].toDoubleOrNull() == null || location.split(" ")[1].toDoubleOrNull() == null) {
            println("You should enter numbers!")
            continue
        }

        if (locationAsList[0].digitToInt() !in 1..3 || locationAsList[1].digitToInt() !in 1..3) {
            println("Coordinates should be from 1 to 3!")
            continue
        }

        if (board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] == 'X'
            || board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] == 'O'
        ) {
            println("This cell is occupied! Choose another one!")
            continue
        }

        when (PLAYER_TURN) {
            1 -> board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            3 -> board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            5 -> board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            7 -> board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            9 -> board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            2 -> board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'O'
            4 -> board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'O'
            6 -> board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'O'
            8 -> board[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'O'
        }
        PLAYER_TURN += 1
        COUNT_U = 0
        displayBoard(board)
    }
}

fun winConditions(winX: Boolean, winO: Boolean) {
    if (winX && !winO) println("X wins")
    if (!winX && winO) println("O wins")
    if (!winX && !winO && COUNT_U == 0) println("Draw")
    exitProcess(0)
}

fun main() {
    val board = mutableListOf(
        mutableListOf(' ', ' ', ' '),
        mutableListOf(' ', ' ', ' '),
        mutableListOf(' ', ' ', ' ')
    )
    displayBoard(board)
}