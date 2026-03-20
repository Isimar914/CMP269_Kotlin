data class WebResponse(
    val statusCode: Int,
    val statusMessage: String,
    val body:String?
)

fun main() {
    val success = WebResponse(200, "OK", "{\"Message\": \"Success!\"}")
    val notFound = WebResponse(404, "Not Found", null)

    println(success)
    println(notFound)
}
