package com.example.myapplication

import kotlin.reflect.KClass


fun main () {
    //exercise 1
    class Employee (var fName: String, var lName: String, var mSalary: Double) {
        init {
            if (mSalary < 0) {
                mSalary = 0.0
            }
        }

        fun getYearlySalary(): Double {
            return mSalary * 12
        }
    }

    var employeeList: MutableList<Employee> = mutableListOf(
        Employee(fName = "Anakin", lName = "Skywalker", mSalary = 12.0),
        Employee(fName = "Maze", lName = "Window", mSalary = 25.49846516485)
    )

    for (employee in employeeList) {
        println("original salary of ${employee.fName+" "+employee.lName} is ${employee.getYearlySalary()}")
        employee.mSalary *= 1.1
        println("new salary of ${employee.fName+" "+employee.lName} is ${employee.getYearlySalary()}")
    }

    //exercise 2        not done!
    open class Computer (chargingPort: String,) {
        var isOn = false

        open fun togglePower () {
            isOn = !isOn
        }

        open fun openCalculator () {
            println("enter problem")
            var problem = readln()

            problem = problem.replace(" ","")
            println(problem.split("+-*/"))
        }
    }

    val computer = Computer("usb-C")
    computer.openCalculator()


    //exercise 3
    open class Product (name:String, price: Double, quantity: Int) {
        var productCategory: String = "undefined"
        open fun identifyProductCategory () {
            productCategory = "undefined"
        }
    }
    class Shoe (name:String, price: Double, quantity: Int):Product(name=name,price=price,quantity=quantity) {
        override fun identifyProductCategory() {
            productCategory = this::class.simpleName.toString()
            println("i am a $productCategory")
        }
    }
    //you can do the same with a T-shirt and book,
    //but it would be better if you had an init-block that identified it for you.

    class Tshirt (name:String, price: Double, quantity: Int):Product(name=name,price=price,quantity=quantity) {
        init {productCategory = this::class.simpleName.toString()}
    }

    //exercise 4
    /*senior guy usses abstract class, witch forces subclasses
    they also makes an initial block that uses require to check if everything is nice and good<3
    they use private val, witch limites the varieble to the current scope so it cannot be acceced from outside
    also uses abstract on functions
    */

    //optional exercise
    open class Car (speed: Int,var regularPrice: Double,color: String) {
        open fun getSalePrice ():Double {return regularPrice}
    }
    class Truck (val weight:Int,speed: Int,regularPrice: Double,color: String):Car(speed,regularPrice,color) {
        override fun getSalePrice(): Double {
            if (weight > 2000) {
                return regularPrice * 0.9
            }
            else {return regularPrice * 0.8}
        }
    }
    class Ford (year:Int,val manufacturerDiscount:Int,speed: Int,regularPrice: Double,color: String):Car(speed,regularPrice,color) {
        override fun getSalePrice(): Double {
            return if (manufacturerDiscount > 0) {
                regularPrice * (1-manufacturerDiscount)
            }
            else {super.getSalePrice()}
        }
    }
    class AutoShop {
        fun main (): MutableList<Double> {
            val CarList = mutableListOf(
                Truck(3000,120,70000.00,"red"),
                Ford(2024,0,180,64999.99,"black"),
                Ford(1981,50,105,8000.00,"yellow"),
                Car(210,120000.00,"orange")
            )
            val priceList = mutableListOf<Double>()
            for (car in CarList) {priceList.add(car.getSalePrice())}
            return priceList
        }
    }
}
