package tictactoe

fun main() {
    val input = readln().toList()
    var winX = false
    var winO = false
    var impossible = false
    var countX = 0
    var countO = 0
    var countU = 0
    println("---------")
    print("| ")
    for (i in input.indices) {
        if (i == 3 || i == 6) {
            print("|")
            print("\n")
            print("| ")
        }
        if (input[i].toString() == "X") ++countX
        if (input[i].toString() == "O") ++countO
        if (input[i].toString() == "_") ++countU
        print(input[i])
        print(" ")
    }
    print("|\n")
    println("---------")



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