package tictactoe
var PLAYER_TURN = 1
var COUNT_U = 0
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
        if (input[i][0].toString() == "_") ++COUNT_U
        if (input[i][1].toString() == "X") ++countX
        if (input[i][1].toString() == "O") ++countO
        if (input[i][1].toString() == "_") ++COUNT_U
        if (input[i][2].toString() == "X") ++countX
        if (input[i][2].toString() == "O") ++countO
        if (input[i][2].toString() == "_") ++COUNT_U
    }
<<<<<<< HEAD
    var winX = false
    var winO = false

    if (input[0].joinToString("") == "XXX") winX = true // Top row
    if (input[1].joinToString("") == "XXX") winX = true // Middle row
    if (input[2].joinToString("") == "XXX") winX = true // Bottom row
    if (input[0][0].toString() + input[1][0] + input[2][0] == "XXX") winX = true // First column
    if (input[0][1].toString() + input[1][1] + input[2][1] == "XXX") winX = true // Second column
    if (input[0][2].toString() + input[1][2] + input[2][2] == "XXX") winX = true // Third column
    if (input[0][0].toString() + input[1][1] + input[2][2] == "XXX") winX = true // Diagonal
    if (input[0][2].toString() + input[1][1] + input[2][0] == "XXX") winX = true // Diagonal

    if (input[0].joinToString("") == "OOO") winO = true
    if (input[1].joinToString("") == "OOO") winO = true
    if (input[2].joinToString("") == "OOO") winO = true
    if (input[0][0].toString() + input[1][0] + input[2][0] == "OOO") winO = true
    if (input[0][1].toString() + input[1][1] + input[2][1] == "OOO") winO = true
    if (input[0][2].toString() + input[1][2] + input[2][2] == "OOO") winO = true
    if (input[0][0].toString() + input[1][1] + input[2][2] == "OOO") winO = true
    if (input[0][2].toString() + input[1][1] + input[2][0] == "OOO") winO = true

    if (winX || winO || PLAYER_TURN == 10) {
        winConditions(input, countX, countO, winX, winO)
    } else {
        gameplay(input)
    }

}
fun gameplay(input: List<MutableList<Char>>) {
    while (PLAYER_TURN < 10 && COUNT_U > 0) {
=======
    gameplay(input)
}
fun gameplay(input: List<MutableList<Char>>) {
    while (PLAYER_TURN < 10 || COUNT_U > 0) {
>>>>>>> fba4bf865cc224c94548c890429f9a1f662e9bdd
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

        if (input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] == 'X'
<<<<<<< HEAD
            || input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] == 'O') {
=======
            || input[locationAsList[1].digitToInt() - 1][locationAsList[1].digitToInt() - 1] == 'O') {
>>>>>>> fba4bf865cc224c94548c890429f9a1f662e9bdd
            println("This cell is occupied! Choose another one!")
            continue
        }

        when (PLAYER_TURN) {
            1 -> input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            3 -> input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            5 -> input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            7 -> input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            9 -> input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'X'
            2 -> input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'O'
            4 -> input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'O'
            6 -> input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'O'
            8 -> input[locationAsList[0].digitToInt() - 1][locationAsList[1].digitToInt() - 1] = 'O'
        }
        PLAYER_TURN += 1
        COUNT_U = 0
        displayBoard(input)
<<<<<<< HEAD
    }
}
fun winConditions(input: List<MutableList<Char>>, countX: Int, countO: Int, winX: Boolean, winO: Boolean) {
    var impossible = false

    /*if (countO - countX !in -1..1 || winX && winO) {
        impossible = true
        println("Impossible")
    }*/ // Neither X nor O can have too many turns and both cannot win
    if (winX && !winO) println("X wins")
    if (!winX && winO) println("O wins")
    if (!winX && !winO && COUNT_U == 0) println("Draw")
    if (!winX && !winO && /*!impossible &&*/ COUNT_U > 0) println("Game not finished")
    return
=======
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
>>>>>>> fba4bf865cc224c94548c890429f9a1f662e9bdd
}
fun main() {
    val input = readln()
    val board = mutableListOf(
        mutableListOf(input[0], input[1], input[2]),
        mutableListOf(input[3], input[4], input[5]),
        mutableListOf(input[6], input[7], input[8])
    )
    displayBoard(board)


<<<<<<< HEAD
}
=======
}

/*
1. Move existing code into separate functions -- DONE
    a. Request user input in main() to create board -- DONE
    b. Call function that displays board -- DONE

2. Create function for playing
    a. Prompt user to make a move (2 coordinate numbers) -- DONE
        I. Turn into list -- DONE
    b. Create a counter to limit number of moves to 9(?) (X goes first)
    c. Based on coordinates, edit table to reflect where X or O is placed
        I. Print "This cell is occupied! Choose another one!" if the cell is not empty. -- DONE
        II. Print "You should enter numbers!" if the user enters non-numeric symbols in the coordinates input. -- DONE
        III. Print "Coordinates should be from 1 to 3!" if the user enters coordinates outside the game grid. -- DONE
        IV. Keep prompting user if input is invalid -- DONE
        V. If input is correct, display changed board -- DONE
 */
>>>>>>> fba4bf865cc224c94548c890429f9a1f662e9bdd
