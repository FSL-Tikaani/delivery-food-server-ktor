package com.tikaani.database

import com.tikaani.models.food.ConsistModel
import com.tikaani.models.food.DishModel
import com.tikaani.models.food.IngredientsModel
import kotlinx.coroutines.reactive.awaitLast
import org.litote.kmongo.coroutine.toList
import org.litote.kmongo.reactivestreams.KMongo


class DatabaseMongo {
    companion object {
        private val client = KMongo.createClient("mongodb://localhost:27017")
        private val database = client.getDatabase("delivery-app")

        suspend fun getAllDishes(): ArrayList<DishModel> {
            val collectionDish = database.getCollection("dishes")
            val dishes: ArrayList<DishModel> = arrayListOf()

            val data = collectionDish.find().toList()
            data.forEach {
                val dish = DishModel().fromDocument(it)
                dishes.add(dish)
            }

            return dishes
        }

        suspend fun addDish(){
            val dish = DishModel(
                "id1",
                "name_dish",
                "description_dish",
                IngredientsModel(
                    "id1",
                    1.0,
                    1.0,
                    1.0,
                    1.0,
                    1.0
                ),
                arrayListOf(
                    ConsistModel("id1", "name")
                ),
                1.0,
                "src_img"
            )

            val collectionDishes = database.getCollection("dishes")

            collectionDishes.insertOne(dish.toDocument()).awaitLast()
        }
    }
}