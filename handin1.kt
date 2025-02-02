package com.example.myapplication

fun main () {

    //exercise 1
    fun checkVoterEligibility () {
        println("Please enter your age")
        try {
            val input: Int = readLine()!!.toInt()
            if (input >= 18) {println("You are eligible to vote")}
            else {println("You are not eligible to vote")}
        } catch (e: Exception) {
            println("that is not a valid age, try again");
            checkVoterEligibility();
        }
    }
    // checkVoterEligibility()

    //exercise 2
    fun getMax (n1:Int, n2:Int, n3:Int):Int {
        var output: Int = n1
        if (n2 > output) {output = n2}
        if (n3 > output) {output = n3}
        return output
    }
    fun getMin (n1:Int, n2:Int, n3:Int):Int {
        var output: Int = n1
        if (n2 < output) {output = n2}
        if (n3 < output) {output = n3}
        return output
    }
    // println(getMax(1,18,8))
    // println(getMin(1,18,-8))


    //exercise 3
    fun calculateAverage (list: List<Int>): Int {
        var average: Int = 0
        for (number in list) {
            average += number
        }
        average /= list.size
        return average
    }
    // println(calculateAverage(listOf(2,456,78,35,45,73,5)))

    //exercise 4
    fun cprChecker (cprnr: String): Boolean {
        return (
            cprnr.length == 10
            && cprnr[0].digitToInt()+cprnr[1].digitToInt() <= 31
            && cprnr[2].digitToInt()+cprnr[3].digitToInt() <= 12
        )}
    // println(cprChecker("2412241234"))

    //exercise 5
    fun playFizzBuzz () {
        for (i in 1..100) {
            if (i % 3 == 0 && i % 5 == 0) {println("FizzBuzz")}
            else if (i % 3 == 0) {println("Fizz")}
            else if (i % 5 == 0) {println("Buzz")}
            else {println(i)}
        }
    }
    // playFizzBuzz()

    //exercise 6
    fun nameAbbreviator (name: String): String {
        var Abbreviation: String;
        val nameList = name.split(" ").toMutableList()
        var i = 0
        while (i < nameList.size-1) {
            nameList[i] = nameList[i][0] + "."
            i++
        }
        return nameList.joinToString(separator = " ")
    }
    // println(nameAbbreviator("Christian Skovgaard Nielsen"))

    //exercise 7
    fun calculateGrade (grade: Int): String {
        if(grade > 100) {return "wow, that's incredible!!!😮"}
        else if (grade >= 90) {return "A"}
        else if (grade >= 80) {return "B"}
        else if (grade >= 70) {return "C"}
        else if (grade >= 60) {return "D"}
        else {return "F"}
    }
    // println(calculateGrade(160))

    //exercise 8
    fun filterWordsByLength (strList: List<String>, minLength: Int): MutableList<String> {
        val returnList = mutableListOf<String>()
        for (str in strList) {
            if (str.length > minLength) {
                returnList.add(str)
            }
        }
        return returnList
    }
    // println(filterWordsByLength(mutableListOf("hello","there","general","Kenobi","yes"),5))

    //advanced
    fun ISBNValidator (ISBN: String): Boolean {
        var i = 0
        val ISBNList: MutableList<Int> = mutableListOf()
        while(i < ISBN.length) {
            if (ISBN[i] == '-') {}
            else if (ISBN[i].toLowerCase() == 'x') {ISBNList.add(10)}
            else {ISBNList.add(ISBN[i].digitToInt())}
            i++
        }
        i = 10
        var sum = 0
        for (digit in ISBNList) {
            sum += digit * i
            i--
        }
        if (sum % 11 == 0) {return true}
        else {return false}
    }
    // println(ISBNValidator("3-598-21508-8"))
}