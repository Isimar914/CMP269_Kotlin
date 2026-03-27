package com.example

import io.ktor.server.application.*
import io.ktor.server.http.content.staticResources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Server is online at Lehman College.")
        }
        get("/greet/{name}") {
            val name = call.parameters["name"]
            call.respondText("Hello, $name! Welcome to CMP 269.")
        }
        val grades = mapOf("123" to 95, "456" to 82)
        get("/grade/{studentId}") {
            val studentId = call.parameters["studentId"]
            val grade = grades[studentId]

            if (grade != null) {
                call.respondText("Grade is $grade")
            } else {
                call.respond(io.ktor.http.HttpStatusCode.NotFound, "Student not found")
            }
        }
        staticResources("/static", "static")
        @Serializable
        data class Stock(val symbol: String, val price: Double)
        get("/api/stock/{symbol}") {
            val symbol = call.parameters["symbol"] ?:"unkown"
            val stockObject = Stock(symbol, 150.25)
            call.respond(stockObject)
        }
    }
}
