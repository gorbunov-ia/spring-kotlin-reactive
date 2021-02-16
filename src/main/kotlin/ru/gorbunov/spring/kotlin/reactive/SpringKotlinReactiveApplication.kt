package ru.gorbunov.spring.kotlin.reactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinReactiveApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinReactiveApplication>(*args)
}
