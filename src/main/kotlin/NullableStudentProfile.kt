fun main() {
    val studentName: String = "Isimar"
    val middleName: String? = null

    println("Welcome, $studentName ${middleName ?: "No Middle Name"}!")
}