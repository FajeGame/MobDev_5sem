import kotlin.math.sqrt

class Vector(val x: Double, val y: Double, val z: Double) {

    fun length(): Double {
        return sqrt(x * x + y * y + z * z)
    }

    fun dotProduct(other: Vector): Double {
        return x * other.x + y * other.y + z * other.z
    }

    infix fun dot(other: Vector): Double {
        return this.dotProduct(other)
    }

    operator fun times(other: Vector): Double {
        return this.dotProduct(other)
    }

    override fun toString(): String {
        return "Vector($x, $y, $z)"
    }
}

fun dotProduct(v1: Vector, v2: Vector): Double {
    return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z
}

fun main() {
    val v1 = Vector(1.0, 2.0, 3.0)
    val v2 = Vector(3.0, 2.0, 1.0)
    val v3 = Vector(4.0, 5.0, 6.0)

    println("Вектор 1: $v1")
    println("Вектор 2: $v2")
    println("Вектор 3: $v3")
    println()

    println("Длина v1: ${v1.length()}")
    println("Длина v2: ${v2.length()}")
    println("Длина v3: ${v3.length()}")
    println()

    println("Скалярное произведение v1 и v2 (метод): ${v1.dotProduct(v2)}")
    println("Скалярное произведение v1 и v3 (метод): ${v1.dotProduct(v3)}")
    println()

    println("Скалярное произведение v1 и v2 (infix): ${v1 dot v2}")
    println("Скалярное произведение v2 и v3 (infix): ${v2 dot v3}")
    println()

    println("Скалярное произведение v1 и v2 (оператор): ${v1 * v2}")
    println("Скалярное произведение v1 и v3 (оператор): ${v1 * v3}")
    println()

    println("Скалярное произведение v1 и v2 (внешняя): ${dotProduct(v1, v2)}")
    println("Скалярное произведение v2 и v3 (внешняя): ${dotProduct(v2, v3)}")
    println()
}
