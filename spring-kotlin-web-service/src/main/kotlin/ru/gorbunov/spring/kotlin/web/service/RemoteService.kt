package ru.gorbunov.spring.kotlin.web.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.gorbunov.spring.kotlin.web.entity.Test

@Service
class RemoteService(
    private val restTemplate: RestTemplate,
    @Value("\${remote.url}")
    val url: String
) {

    fun getTest(delay: Int): Test {
        val uuid = restTemplate.getForObject("$url?delay=$delay", String::class.java)
        return Test(id = null, value = uuid!!)
    }

}