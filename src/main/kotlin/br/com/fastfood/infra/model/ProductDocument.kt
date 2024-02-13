package br.com.fastfood.infra.model

import br.com.fastfood.infra.enums.ProductCategory
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document(collection = "product")
data class ProductDocument(
        @Id @Field(name = "_id")
        val id: ObjectId? = null,
        val name: String,
        @Indexed(unique = true)
        val code: String,
        val price: Double,
        val quantity:  Number,
        val category: ProductCategory,
        val dateValidate: LocalDateTime

)
