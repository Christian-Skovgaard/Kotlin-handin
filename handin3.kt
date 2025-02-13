package com.example.myapplication

//imports needed for current data in exercise 2
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
@RequiresApi(Build.VERSION_CODES.O)

enum class Vote {UPVOTE, DOWNVOTE}


fun main () {
    //exercise 1
    class Article (val title: String, val author: String) {
        override fun toString():String {
            return "${title} written by ${author}"
        }
    }

    arrayListOf(
        Article("26 måder at gøre dit liv værre med AI","Laurits Munk"),
        Article("Mit hår gjorde mig Liberal","Elias"),
        Article("Sådan styler du dit hår med inspiration fra trolls","Laurits"),
        Article("Kunsten af at reflektere kritiske spørgsmål fra elever","Niklas"),
        Article("10 gode undskyldninger for at gå fra din undervisning","Niklas")
    ).forEach { println(it.toString())}

    //exercise 2        //not done!
    class RedditPost (val title: String, val author: String) {

        private var voteBalance = 1
        private val postDate = LocalDate.now()

        fun getVoteBalance ():Int {return voteBalance}

        fun vote (vote:Vote) {
            if (vote==Vote.UPVOTE) {voteBalance++}
            else {voteBalance--}
        }

        override fun toString(): String {
            return "RedditPost(voteBalance=$voteBalance, author='$author')"
        }
    }

    val post = RedditPost("awds","awdas")
    println(post.getVoteBalance())

    fun sortPostsByVoteBalance (postList:List<RedditPost>):List<RedditPost> {
        //har prøvet at implementere insertionsort
        val sortedList = postList.toMutableList()
        var i = 1
        var j = i
        while (i < postList.size) {
            while (i > 0 && sortedList[i].getVoteBalance() < sortedList[i-1].getVoteBalance()) {
                val temp = sortedList[i]
                sortedList[i] = sortedList[i-1]
                sortedList[i-1] = temp
                i--
            }
            j++
            i = j
        }
        return sortedList.toList()
    }

    val postList = listOf(
        RedditPost("Why windows beats Mac","Felix"),
        RedditPost("How to cure brainrot","Elias"),
        RedditPost("This is how i met your mother","Elias"),
        RedditPost("How to sell Elon Musk","Elias"),
        RedditPost("53 usecases for a Caterpillar 323D3 tracked excavator","Christian")
        )

    fun assignVotes () {
        var i = 0
        while (i < 205) {
            postList[0].vote(Vote.UPVOTE)
            i++
        }
        i=0
        while (i < 310) {
            postList[1].vote(Vote.UPVOTE)
            i++
        }
        i=0
        while (i < 223) {
            postList[2].vote(Vote.UPVOTE)
            i++
        }
        i=0
        while (i < 25) {
            postList[3].vote(Vote.UPVOTE)
            i++
        }
        i=0
        while (i < 130) {
            postList[4].vote(Vote.UPVOTE)
            i++
        }
    }
    assignVotes()

    println(postList)
    println(sortPostsByVoteBalance(postList))

    //exercise 3
    class RedditFrontPage () {
        val postList: MutableList<RedditPost> = mutableListOf()

        fun deletePostByIndex (index:Int) {postList.removeAt(index)}
    }


    //exercise 4
    fun getWordFrequencyFromList (list: List<String>):MutableMap<String, Int> {
        val set: MutableSet<String> = mutableSetOf()
        for (word in list) {set.add(word)}
    println(set)
        val wordMap = mutableMapOf<String, Int>()
        for (word in set) {wordMap.put(word, 0)}
        for (word in list) {wordMap.put(word, ((wordMap[word] as Int) + 1))}
        return wordMap
    }
    val words = listOf("apple", "banana", "apple", "orange", "banana", "apple", "orange", "banana", "apple","banana", "apple", "orange", "banana","banana", "apple", "orange", "apple", "orange", "banana")
    println(getWordFrequencyFromList(words))

    //exercise 5
    class Product (val name: String) {
        var quantity: Int = 0
    }
    val inventory: MutableMap<String, Product> = mutableMapOf()
    fun addProduct (productName: String) {
        if (!inventory.containsKey(productName)){
            inventory.put(productName, Product(productName))
        } else {
            println("ProductName already in use")
        }
    }
    fun removeProduct (productName: String) {inventory.remove(productName)}
    fun displayInventory () {
        for (product in inventory) {
            println(product.key + " = " + product.value.quantity)
        }
    }

    addProduct("apple")
    inventory["apple"]?.quantity = 5
    addProduct("Caterpillar 323D3 tracked excavator")
    inventory["Caterpillar 323D3 tracked excavator"]?.quantity = 1
    displayInventory()



}