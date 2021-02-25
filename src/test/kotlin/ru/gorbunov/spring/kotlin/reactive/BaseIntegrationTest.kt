package ru.gorbunov.spring.kotlin.reactive

import io.r2dbc.spi.ConnectionFactoryOptions
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.PostgreSQLR2DBCDatabaseContainer

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
            val options = PostgreSQLR2DBCDatabaseContainer.getOptions(container)
            val username = options.getValue(ConnectionFactoryOptions.USER)
            val password = options.getValue(ConnectionFactoryOptions.PASSWORD)
            val port = options.getValue(ConnectionFactoryOptions.PORT)
            val database = options.getValue(ConnectionFactoryOptions.DATABASE)
            return TestPropertyValues.of(
                "spring.r2dbc.url=r2dbc:postgresql://localhost:$port/$database",
                "spring.r2dbc.username=$username",
                "spring.r2dbc.password=$password",
                "spring.liquibase.url=${container.jdbcUrl}",
                "spring.liquibase.user=$username",
                "spring.liquibase.password=$password"
            )
        }
    }
}