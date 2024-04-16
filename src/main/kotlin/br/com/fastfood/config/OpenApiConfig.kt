package br.com.fastfood.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenApiConfig {

    @Value("\${fastfood.openapi.dev-url}")
    private val devUrl: String? = null

    @Value("\${fastfood.openapi.prod-url}")
    private val prodUrl: String? = null

    @Bean
    fun myOpenAPI(): OpenAPI {
        val devServer: Server = Server()

        devServer.url(devUrl)
        devServer.description("Server URL in Development environment")

        val prodServer: Server = Server()
        prodServer.url(prodUrl)
        prodServer.description("Server URL in Production environment")

        val contact: Contact = Contact()
        contact.email("eduardocacere@gmail.com")
        contact.name("Eduardo Sanches")

        val mitLicense: License = License().name("MIT License").url("https://choosealicense.com/licenses/mit/")

        val info: Info = Info()
                .title("FastFood API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage FastFood.")
                .license(mitLicense)

        return OpenAPI().info(info).servers(listOf(devServer, prodServer))
    }

}