fun main(){
    val num = (1..10).random()
    var take = readln().toInt()
    while(take != num) {
        if(take > num) {
            println("Меньше")
        } else if(take < num) {
            println("Больше")
        }
        take = readln().toInt()
    }
        println("Угадал")
}