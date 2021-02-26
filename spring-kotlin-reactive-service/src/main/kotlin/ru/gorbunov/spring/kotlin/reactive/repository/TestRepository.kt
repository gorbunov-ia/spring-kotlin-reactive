package ru.gorbunov.spring.kotlin.reactive.repository

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import ru.gorbunov.spring.kotlin.reactive.entity.Test

@Repository
interface TestRepository : CoroutineCrudRepository<Test, Long> {
}