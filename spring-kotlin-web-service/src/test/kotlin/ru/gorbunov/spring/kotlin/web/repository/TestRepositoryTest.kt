package ru.gorbunov.spring.kotlin.web.repository

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.gorbunov.spring.kotlin.web.BaseIntegrationTest

class TestRepositoryTest : BaseIntegrationTest() {

    @Autowired
    private lateinit var reposittory: TestRepository

    @Test
    internal fun `insert row`() {
        val entity = ru.gorbunov.spring.kotlin.web.entity.Test(value = "test")

        reposittory.save(entity)

        Assertions.assertNotNull(entity.id)
    }
}