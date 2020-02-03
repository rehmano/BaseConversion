import java.util.Scanner
import kotlin.math.pow

/**
 * Name: Syed "Omar" Rehman
 * Date of creation: January 30, 2020
 * Class: CSC101
 * Purpose: Just a simple base conversion class emphasizing recursion
 */

fun main() {
    val read = Scanner(System.`in`)
    var iterations = 0
    while(true){

        printMenu(iterations == 0)
        val input = read.nextInt()

        println("Enter the value that you want converted: ")

        when(input){
            1 -> println("In binary: " + decToBinary(read.nextInt()))
            2 -> println("In hexadecimal: " + decToHex(read.nextInt()))
            3 -> println("In decimal: " + binaryToDec(read.next()))
            4 -> println("In decimal: " + hexToDec(read.next()))
        }

        iterations++
    }
}

fun printMenu(isStart: Boolean = false){
    if(isStart){
        println("Welcome to this base conversion application!")
    }
    println("--------------------------------------------")
    println("(1) Decimal to Binary")
    println("(2) Decimal to Hexadecimal")
    println("(3) Binary to Decimal")
    println("(4) Hexadecimal to Decimal")
}

fun decToBinary(decimalNum: Int, binaryString: String = "") : String {
    return if (decimalNum == 0) {
        binaryString.reversed()
    } else {
        decToBinary(decimalNum / 2, binaryString + (decimalNum % 2))
    }
}

fun binaryToDec(binaryString: String, decimalNum: Int = 0) : Int {
    return if(binaryString.isEmpty()){
        decimalNum
    } else {
        val decimalNumToAdd = if (binaryString.first() == '1') 2.0.pow(binaryString.length - 1).toInt() else 0
        binaryToDec(binaryString.drop(1), decimalNum + decimalNumToAdd)
    }
}

val hexSet: String = "0123456789ABCDEF"

fun decToHex(decimalNum: Int, hexString: String = ""): String {
    return if(decimalNum == 0){
        hexString.reversed()
    } else {
        decToHex(decimalNum / 16, hexString + hexSet[decimalNum % 16])
    }
}

fun hexToDec(hexString: String, decimalNum: Int = 0) : Int {
    return if(hexString.isEmpty()){
        decimalNum
    } else {
        val decimalNumToAdd = 16.0.pow(hexString.length - 1).toInt() * hexSet.indexOf(hexString.first())
        hexToDec(hexString.drop(1), decimalNum + decimalNumToAdd)
    }
}