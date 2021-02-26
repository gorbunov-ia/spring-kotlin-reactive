package ru.gorbunov.spring.kotlin.reactive.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.gorbunov.spring.kotlin.reactive.entity.Test
import ru.gorbunov.spring.kotlin.reactive.repository.TestRepository
import java.util.*

@RestController
@RequestMapping("test")
class TestController(private val testRepository: TestRepository) {

    @PostMapping
    suspend fun addTest(): Test {
        return testRepository.save(Test(value = UUID.randomUUID().toString()))
    }

}