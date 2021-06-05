package ru.gorbunov.spring.kotlin.reactive.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class DefaultConfig {

    @Bean
    fun webClient(webClientBuilder: WebClient.Builder) = webClientBuilder.build()

}