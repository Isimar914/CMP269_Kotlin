data class Laptop(val brand: String, val ramGB: Int)

fun Int.toLehmanGigabytes(): String {
    return "$this GB (Lehman Standard)"
}

fun main() {
    val laptop1 = Laptop("Mac", 16)
    val laptop2 = Laptop("Window", 8)

    println("${laptop1.brand}: ${laptop1.ramGB.toLehmanGigabytes()}")
    println("${laptop2.brand}: ${laptop2.ramGB.toLehmanGigabytes()}")
}