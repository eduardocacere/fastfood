package br.com.fastfood

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
class FastfoodApplication

fun main(args: Array<String>) {
	System.out.println("*** Fast Food ***")
	System.out.println("---- MONGO_URI: ${System.getenv("MONGO_URI")} ----" )
	System.out.println("---- MONGO_DATABASE: ${System.getenv("MONGO_DATABASE")} ----" )
	runApplication<FastfoodApplication>(*args)
}
