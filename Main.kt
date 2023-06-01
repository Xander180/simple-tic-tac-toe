package tictactoe

fun main() {
    val input = readln().toMutableList()
    println("---------")
    print("| ")
    for (i in 0 until input.size) {
        if (i == 3 || i == 6) {
            print("|")
            print("\n")
            print("| ")
        }
        print(input[i])
        print(" ")
    }
    print("|\n")
    println("---------")
}