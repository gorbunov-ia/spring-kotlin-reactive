package ru.gorbunov.spring.kotlin.web

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.containers.PostgreSQLContainer

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(initializers = [BaseIntegrationTest.Initializer::class])
abstract class BaseIntegrationTest {

    companion object {
        private val POSTGRES_CONTAINER = PostgreSQLContainer<Nothing>("postgres:latest")
        init {
            POSTGRES_CONTAINER.start()
        }
    }

    internal class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
            of(POSTGRES_CONTAINER).applyTo(configurableApplicationContext)
        }

        private fun of(container: PostgreSQLContainer<Nothing>): TestPropertyValues {
            return TestPropertyValues.of(
                "spring.datasource.url=" + container.jdbcUrl,
                "spring.datasource.username=" + container.username,
                "spring.datasource.password=" + container.password
            )
        }
    }
}