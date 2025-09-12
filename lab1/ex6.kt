import kotlin.math.sqrt

fun main() {
    println("Уравнение вида: ax² + bx + c = 0")
    println()

    print("Введите коэффициент a: ")
    val a = readln()!!.toDouble()

    print("Введите коэффициент b: ")
    val b = readln()!!.toDouble()

    print("Введите коэффициент c: ")
    val c = readln()!!.toDouble()

    println()
    println("Уравнение: ${formatEquation(a, b, c)}")
    println()

    quadraticRoot(a, b, c)
}

fun sqr(n: Double): Double {
    return n * n
}

fun discriminant(a: Double, b: Double, c: Double): Double {
    return sqr(b) - 4 * a * c
}

fun rootsNumber(a: Double, b: Double, c: Double): Int {
    val d = discriminant(a, b, c)

    return when {
        d > 0 -> 2
        d == 0.0 -> 1
        else -> 0
    }
}

fun quadraticRoot(a: Double, b: Double, c: Double) {
    val d = discriminant(a, b, c)
    val rootsCount = rootsNumber(a, b, c)

    println("Дискриминант D = $d")
    println("Количество корней: $rootsCount")
    println()

    when (rootsCount) {
        2 -> {
            val x1 = (-b + sqrt(d)) / (2 * a)
            val x2 = (-b - sqrt(d)) / (2 * a)
            println("Два действительных корня:")
            println("x₁ = $x1")
            println("x₂ = $x2")
        }
        1 -> {
            val x = -b / (2 * a)
            println("Один действительный корень (кратный):")
            println("x = $x")
        }
        0 -> {
            println("Действительных корней нет")
            val realPart = -b / (2 * a)
            val imaginaryPart = sqrt(-d) / (2 * a)
            println("Комплексные корни:")
            println("x₁ = $realPart + ${imaginaryPart}i")
            println("x₂ = $realPart - ${imaginaryPart}i")
        }
    }
}

fun formatEquation(a: Double, b: Double, c: Double): String {
    val equation = StringBuilder()

    when {
        a == 1.0 -> equation.append("x²")
        a == -1.0 -> equation.append("-x²")
        a != 0.0 -> equation.append("${formatCoefficient(a)}x²")
    }

    when {
        b > 0 -> equation.append(" + ${formatCoefficient(b)}x")
        b < 0 -> equation.append(" - ${formatCoefficient(-b)}x")
    }

    when {
        c > 0 -> equation.append(" + $c")
        c < 0 -> equation.append(" - ${-c}")
    }

    equation.append(" = 0")
    return equation.toString()
}

fun formatCoefficient(n: Double): String {
    return if (n % 1 == 0.0) n.toInt().toString() else n.toString()
}