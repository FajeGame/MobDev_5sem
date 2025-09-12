class ArrayCalculator(private val array: Array<Int>) {

    fun sumOfPositive(): Int {
        var sum = 0
        for (element in array) {
            if (element > 0) {
                sum += element
            }
        }
        return sum
    }

    fun productOfElements(): Int {
        var product = 1
        for (element in array) {
            product *= element
        }
        return product
    }

    fun average(): Double {
        if (array.isEmpty()) return 0.0
        var sum = 0
        for (element in array) {
            sum += element
        }
        return sum.toDouble() / array.size
    }

    fun printArray() {
        println("Массив: ${array.joinToString()}")
    }
}

fun main() {
    val numbers = arrayOf(2, -5, 8, -3, 10, -1, 4)

    val calculator = ArrayCalculator(numbers)

    calculator.printArray()
    println()

    println("Сумма положительных элементов: ${calculator.sumOfPositive()}")
    println("Произведение всех элементов: ${calculator.productOfElements()}")
    println("Среднее арифметическое: ${calculator.average()}")

    println("\n" + "=".repeat(50))
}    