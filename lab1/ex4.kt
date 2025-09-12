import kotlin.math.sqrt

fun simpNum(n: Int): Boolean{
    for(i in 2..sqrt(n.toDouble()).toInt()){
        if(n % i == 0){
            return false
        }
    }
    return true
}

fun main(){
    val n = readln().toInt()
    var kol = 1
    var num = 2
    while(kol <= n){
        if(simpNum(num)) {
            println("$kol-e число: " + num)
            kol++
        }
        num++
    }
}