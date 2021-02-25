package ru.gorbunov.spring.kotlin.reactive.repository

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.gorbunov.spring.kotlin.reactive.BaseIntegrationTest

class TestRepositoryTest : BaseIntegrationTest() {

    @Autowired
    private lateinit var reposittory: TestRepository

    @Test
    internal fun `insert row`() = runBlocking {
        val entity = ru.gorbunov.spring.kotlin.reactive.entity.Test(value = "test")

        reposittory.save(entity)

        Assertions.assertNotNull(entity.id)
    }
}