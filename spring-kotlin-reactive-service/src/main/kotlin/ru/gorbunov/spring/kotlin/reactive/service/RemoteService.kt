package ru.gorbunov.spring.kotlin.reactive.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import ru.gorbunov.spring.kotlin.reactive.entity.Test

@Service
class RemoteService(
    private val webClient: WebClient,
    @Value("\${remote.url}")
    val url: String
) {

    suspend fun getTest(delay: Int): Test =
        webClient.get().uri("$url?delay=$delay")
            .retrieve()
            .awaitBody<String>()
            .let {
                Test(id = null, value = it)
            }

}