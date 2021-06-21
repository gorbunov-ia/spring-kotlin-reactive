package ru.gorbunov.spring.kotlin.web.controller

import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import ru.gorbunov.spring.kotlin.web.service.RemoteService
import ru.gorbunov.spring.kotlin.web.entity.Test
import ru.gorbunov.spring.kotlin.web.repository.TestRepository
import java.util.*

@RestController
@RequestMapping("test")
class TestController(
    private val remoteService: RemoteService,
    private val testRepository: TestRepository
) {

    @PostMapping
    fun addTest(): Test {
        return testRepository.save(Test(value = UUID.randomUUID().toString()))
    }

    @GetMapping("/{id}")
    fun getTest(@PathVariable id: Long): Test? {
        return testRepository.findByIdOrNull(id)
    }

    @GetMapping("/remote")
    fun getRemote(@RequestParam(required = false) delay: Int?): Test {
        return remoteService.getTest(delay ?: 0)
    }
}