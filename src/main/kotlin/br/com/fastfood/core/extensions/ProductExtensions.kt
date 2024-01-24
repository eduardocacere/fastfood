package br.com.fastfood.core.extensions

import br.com.fastfood.adapter.persistence.model.ProductDocument
import br.com.fastfood.core.domain.Product
import br.com.fastfood.core.domain.request.ProductRequest
import br.com.fastfood.core.domain.response.ProductResponse
import org.bson.types.ObjectId

fun ProductDocument.toDomain(): Product =
        Product(
                id = id,
                name = name,
                code = code,
                price = price,
                quantity = quantity,
                category = category,
                dateValidate = dateValidate
        )

fun Product.toDocument(): ProductDocument =
        ProductDocument(
                id =  id,
                name = name,
                code = code,
                price = price,
                quantity = quantity,
                category = category,
                dateValidate = dateValidate
        )

fun ProductRequest.toDomain(): Product =
        Product(
                name = name,
                code = code,
                price = price,
                quantity = quantity,
                category = category,
                dateValidate = dateValidate
        )

fun Product.toResponse(): ProductResponse =
        ProductResponse(
                name = name,
                code = code,
                price = price,
                quantity = quantity,
                category = category,
                dateValidate = dateValidate
        )