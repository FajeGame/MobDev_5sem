open class Vehicle {
    open var speed: Int = 0
    open var name: String = "Транспортное средство"

    open fun start() {
        println("$name начал движение со скоростью $speed км/ч")
    }

    open fun stop() {
        println("$name остановился")
    }

    open fun info() {
        println("Транспорт: $name, Макс. скорость: $speed км/ч")
    }
}

class Boat : Vehicle() {
    override var speed: Int = 40
    override var name: String = "Лодка"

    override fun start() {
        println("$name вышла в плавание со скоростью $speed км/ч")
    }

    override fun stop() {
        println("$name причалила к берегу")
    }

    override fun info() {
        println("Водный транспорт: $name, Скорость на воде: $speed км/ч")
    }
}

class Airplane : Vehicle() {
    override var speed: Int = 800
    override var name: String = "Самолет"

    override fun start() {
        println("$name взлетел со скоростью $speed км/ч")
    }

    override fun stop() {
        println("$name совершил посадку")
    }

    override fun info() {
        println("Воздушный транспорт: $name, Крейсерская скорость: $speed км/ч")
    }
}

class Tank : Vehicle() {
    override var speed: Int = 60
    override var name: String = "Танк"

    override fun start() {
        println("$name поехал по полю со скоростью $speed км/ч")
    }

    override fun stop() {
        println("$name остановился для прицеливания")
    }

    override fun info() {
        println("Боевая машина: $name, Макс. скорость по пересеченной местности: $speed км/ч")
    }
}

fun main() {
    val vehicles = listOf(
        Boat(),
        Airplane(),
        Tank()
    )

    for (vehicle in vehicles) {
        vehicle.info()
        vehicle.start()
        vehicle.stop()
        println()
    }
}