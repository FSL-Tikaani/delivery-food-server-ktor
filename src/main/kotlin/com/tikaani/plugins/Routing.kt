package com.tikaani.plugins

import com.tikaani.database.DatabaseMongo
import com.tikaani.models.food.DishModel
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/create-dish"){
             val dish = call.receive<DishModel>()
            println("Сервер получил: " + dish.price)
        }

        get("/all-dishes"){
            val data = DatabaseMongo.getAllDishes()
            call.respond(data)
        }
        get("/create"){
            DatabaseMongo.addDish()
            call.respond("created")
        }

    }
}
