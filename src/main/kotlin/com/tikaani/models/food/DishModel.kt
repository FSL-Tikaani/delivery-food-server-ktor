package com.tikaani.models.food

import kotlinx.serialization.Serializable
import org.bson.Document

@Serializable
data class DishModel(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val ingredients: IngredientsModel = IngredientsModel(),
    val consist: List<ConsistModel> = listOf(),
    val price: Double = 1.0,
    val srcImg: String = "",
){
    fun toDocument(): Document{
        val document = Document()
        document["id"] = id
        document["name"] = name
        document["description"] = description
        document["ingredients"] = ingredients
        document["consist"] = consist
        document["price"] = price
        document["srcImg"] = srcImg

        return document
    }

    fun fromDocument(document: Document): DishModel {

        val ingredientsDocument = document["ingredients"] as Document
        val ingredients = IngredientsModel(
            ingredientsDocument["id"] as String,
            ingredientsDocument["dishWeight"] as Double,
            ingredientsDocument["dishCalories"] as Double,
            ingredientsDocument["dishProteins"] as Double,
            ingredientsDocument["dishFats"] as Double,
            ingredientsDocument["dishCarbohydrates"] as Double,
        )

        val consist = document["consist"] as List<Document>
        val consistList = consist.map {
            ConsistModel(
                it["id"] as String,
                it["name"] as String,
            )
        }

        val dish = DishModel(
            document["id"] as String,
            document["name"] as String,
            document["description"] as String,
            ingredients,
            consistList,
            document["price"] as Double,
            document["srcImg"] as String,
        )
        return dish
    }
}

