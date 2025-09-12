fun main(){
    var ent = readln().toInt()
    var kol = 0
    var sum = 0
    while(ent != 0){
        kol++
        sum += ent
        ent = readln().toInt()
    }
    var sred = sum / kol
    println("Кол-во чисел: $kol")
    println("Сумма чисел: $sum")
    println("Сред. ар. чисел: $sred")
}