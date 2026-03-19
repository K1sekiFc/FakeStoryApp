package com.checky.fstory.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    lambda()
    threads()
    courutinesVsThreads()
}

fun courutinesVsThreads() {
    newTopic("Courutines vs Threads")
    runBlocking {
        (1..1_000_000).forEach{ _ ->
            launch { delay(someTime())
            println("*")}
        }
    }
}
private const val Separator="============"
fun newTopic(topic:String) {
println("\n$Separator $topic $Separator\n")

//    (1..1_000_000).forEach {
//        thread {
//            Thread.sleep(someTime())
//            print("*")
//        }
//    }
}

fun threads() {
    newTopic("Threads")
    println(multithread(2,3))
    multithreadLambda(2,3){
        println("T+L $it")
    }
}

fun multithread(x: Int,y: Int):Int {
    var result = 0
    thread {
        Thread.sleep(someTime())
        result = x * y
    }
//    Thread.sleep(2_100)
    return result
}

fun multithreadLambda(x: Int,y: Int,callback:(result:Int)->Unit) {
    var result = 0
    thread {
        Thread.sleep(someTime())
        result = x * y
        callback (result)
    }
}

fun someTime(): Long = Random.nextLong(500,2_000)

fun lambda() {
    newTopic("Lambda")

    println(multi(2,3))

   multilambda(2,3) {result ->
        println(result)
    }
}

fun multilambda(x: Int, y: Int,callback:(result:Int)->Unit) {
    callback(x*y)
}

fun multi(x: Int, y: Int): Int {
    return x * y
}
