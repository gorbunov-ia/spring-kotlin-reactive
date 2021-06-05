package ru.gorbunov.spring.kotlin.reactive.controller

import org.springframework.web.bind.annotation.*
import ru.gorbunov.spring.kotlin.reactive.service.RemoteService
import ru.gorbunov.spring.kotlin.reactive.entity.Test
import ru.gorbunov.spring.kotlin.reactive.repository.TestRepository
import java.util.*

@RestController
@RequestMapping("test")
class TestController(
    private val remoteService: RemoteService,
    private val testRepository: TestRepository
) {

    @PostMapping
    suspend fun addTest(): Test {
        return testRepository.save(Test(value = UUID.randomUUID().toString()))
    }

    @GetMapping("/{id}")
    suspend fun getTest(@PathVariable id: Long): Test? {
        return testRepository.findById(id)
    }

    @GetMapping("/remote")
    suspend fun getRemote(@RequestParam(required = false) delay: Int?): Test {
        return remoteService.getTest(delay ?: 0)
    }
}