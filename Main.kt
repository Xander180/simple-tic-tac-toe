package tictactoe

fun main() {
    val input = readln().toMutableList()
    var winX = false
    var winO = false
    var countX = 0
    var countO = 0
    var countU = 0
    println("---------")
    print("| ")
    for (i in 0 until input.size) {
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
    if (countO - countX !in -1..1) println("Impossible")


    if (input.subList(0, 3).joinToString("") == "XXX") winX = true
    if (input.subList(3, 6).joinToString("") == "XXX") winX = true
    if (input.subList(6, 9).joinToString("") == "XXX") winX = true
    if (input[0].toString() + input[3] + input[6] == "XXX") winX = true
    if (input[1].toString() + input[4] + input[7] == "XXX") winX = true
    if (input[2].toString() + input[5] + input[8] == "XXX") winX = true
    if (input[0].toString() + input[4] + input[8] == "XXX") winX = true
    if (input[2].toString() + input[4] + input[6] == "XXX") winX = true

    if (input.subList(0, 3).joinToString("") == "OOO") winO = true
    if (input.subList(3, 6).joinToString("") == "OOO") winO = true
    if (input.subList(6, 9).joinToString("") == "OOO") winO = true
    if (input[0].toString() + input[3] + input[6] == "OOO") winO = true
    if (input[1].toString() + input[4] + input[7] == "OOO") winO = true
    if (input[2].toString() + input[5] + input[8] == "OOO") winO = true
    if (input[0].toString() + input[4] + input[8] == "OOO") winO = true
    if (input[2].toString() + input[4] + input[6] == "OOO") winO = true

    if (winX && !winO) println("X wins")
    if (!winX && winO) println("O wins")






}

/*
1. Create "Game not finished" condition
    a. Not impossible
    b. When neither winX nor winO == true AND board NOT filled
2. Create Draw condition
    a. When neither winX nor winO == true AND board is filled
3. Create X Wins Condition
    a. X count >= 3
    b. winX == true && winO == false -- DONE (2)
    c. "XXX" is true (including diagonals) -- DONE(1)
4. Create O wins condition
    a. O count >= 3
    b. winO == true && winX == false -- DONE (2)
    c. "OOO" is true (including diagonals) -- DONE(2)
5. Create impossible condition
    a. countX - countO is not between -1 and 1 -- DONE (2)
    b. winX and winO == true
 */