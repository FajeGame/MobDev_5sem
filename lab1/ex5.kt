fun biggestFor(x: Array<Int>): ArrayList<Int> {
    val n = arrayListOf<Int>()

    for (j in 1 until x.size - 1) {
        if (x[j] > x[j - 1] && x[j] > x[j + 1]) {
            n.add(x[j])
        }
    }
    return n
}

fun biggestWhile(x: Array<Int>): ArrayList<Int>{
    val n = arrayListOf<Int>()
    var j = 1
    while(j < x.size - 1) {
        if (x[j] > x[j - 1] && x[j] > x[j + 1]) {
            n.add(x[j])
        }
        j++
    }

    return n
}

fun biggestForEach(x: Array<Int>): ArrayList<Int>{
    val n = arrayListOf<Int>()

    (1 until x.size - 1).forEach { j ->
        if (x[j] > x[j - 1] && x[j] > x[j + 1]) {
            n.add(x[j])
        }
    }

    return n
}

fun calculateWithFor(x: Array<Int>): Array<Int> {
    var product = 1
    var min = x[0]
    var max = x[0]

    for (i in x.indices) {
        product *= x[i]
        if (x[i] < min) min = x[i]
        if (x[i] > max) max = x[i]
    }

    return arrayOf(product, min, max)
}

fun calculateWithWhile(x: Array<Int>): Array<Int> {
    var product = 1
    var min = x[0]
    var max = x[0]
    var i = 0

    while (i < x.size) {
        product *= x[i]
        if (x[i] < min) min = x[i]
        if (x[i] > max) max = x[i]
        i++
    }

    return arrayOf(product, min, max)
}

fun calculateWithForEach(x: Array<Int>): Array<Int> {
    var product = 1
    var min = x[0]
    var max = x[0]

    x.forEach { element ->
        product *= element
        if (element < min) min = element
        if (element > max) max = element
    }

    return arrayOf(product, min, max)
}

fun calculateWithReduce(x: Array<Int>): Array<Int> {
    val product = x.reduce { acc, element -> acc * element }
    val min = x.min()
    val max = x.max()

    return arrayOf(product, min, max)
}

fun calculateWithMinMax(x: Array<Int>): Array<Int> {
    var product = 1
    x.forEach { product *= it }
    val min = x.min()
    val max = x.max()

    return arrayOf(product, min, max)
}

fun main(){
    val numbers: Array<Int> = Array(5, {(0..20).random()})
    for(number in numbers){
        print("$number \t")
    }
    println()
    println("Числа больше соседних:")
    println(biggestFor(numbers))
    println(biggestWhile(numbers))
    println(biggestForEach(numbers))
    println("Произведение, мин и макс: ")
    println(calculateWithFor(numbers).joinToString())
    println(calculateWithWhile(numbers).joinToString())
    println(calculateWithForEach(numbers).joinToString())
    println(calculateWithReduce(numbers).joinToString())
    println(calculateWithMinMax(numbers).joinToString())
}