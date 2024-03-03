package br.com.fastfood

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FastfoodApplication

fun main(args: Array<String>) {
	System.out.println("MONGO_URI: ${System.getenv("MONGO_URI")}")
	System.out.println("MONGO_DATABASE: ${System.getenv("MONGO_DATABASE")}")

	runApplication<FastfoodApplication>(*args)
}
