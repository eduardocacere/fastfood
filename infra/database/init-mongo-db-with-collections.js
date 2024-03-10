db.createCollection("order");
db.createCollection("client");
db.createCollection("checkout");
db.createCollection("product");


db.getCollection("product").insertMany([
{
    "name" : "Batata Frita",
    "code" : "001",
    "price" : 5.0,
    "quantity" : NumberInt(100),
    "category" : "ACCOMPANIMENT",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},
{
    "name" : "Batata Rustica",
    "code" : "002",
    "price" : 5.0,
    "quantity" : NumberInt(100),
    "category" : "ACCOMPANIMENT",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},
{
    "name" : "Salada",
    "code" : "003",
    "price" : 3.0,
    "quantity" : NumberInt(100),
    "category" : "SNACK",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},

{
    "name" : "Coca-Cola Pequena",
    "code" : "004",
    "price" : 4.0,
    "quantity" : NumberInt(100),
    "category" : "DRINK",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},
{
    "name" : "Coca-Cola Media",
    "code" : "005",
    "price" : 4.0,
    "quantity" : NumberInt(100),
    "category" : "DRINK",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},
{
    "name" : "Coca-Cola Grande",
    "code" : "006",
    "price" : 4.0,
    "quantity" : NumberInt(100),
    "category" : "DRINK",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},
{
    "name" : "Agua - Garrafa 500ml",
    "code" : "07",
    "price" : 4.0,
    "quantity" : NumberInt(100),
    "category" : "DRINK",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},

{
    "name" : "X-Salada",
    "code" : "08",
    "price" : 15,
    "quantity" : NumberInt(100),
    "category" : "SNACK",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},
{
    "name" : "X-tudo",
    "code" : "09",
    "price" : 20,
    "quantity" : NumberInt(100),
    "category" : "SNACK",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},

{
    "name" : "X-Egg",
    "code" : "10",
    "price" : 20,
    "quantity" : NumberInt(100),
    "category" : "SNACK",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},

{
    "name" : "Combo 1 - X-Salada - Batata Frira e Refrigerante",
    "code" : "11",
    "price" : 30,
    "quantity" : NumberInt(100),
    "category" : "COMBO",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},

{
    "name" : "Combo 1 - X-Tudo - Batata Frira e Refrigerante",
    "code" : "12",
    "price" : 30,
    "quantity" : NumberInt(100),
    "category" : "COMBO",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},

{
    "name" : "Combo 1 - X-Egg - Batata Frira e Refrigerante",
    "code" : "13",
    "price" : 30,
    "quantity" : NumberInt(100),
    "category" : "COMBO",
    "dateValidate" : ISODate("2024-01-24T04:30:45.756+0000"),
    "_class" : "br.com.fastfood.adapter.persistence.model.ProductDocument"
},
]);

db.getCollection("client").insertMany([
{
    "name" : "Cliente Teste",
    "email" : "teste@teste.com.br",
    "cpf" : "99999999999",
    "_class" : "br.com.fastfood.adapter.persistence.model.ClientDocument"
}
])
