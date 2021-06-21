package ru.gorbunov.spring.kotlin.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinWebApplication

fun main(args: Array<String>) {
    runApplication<SpringKotlinWebApplication>(*args)
}
