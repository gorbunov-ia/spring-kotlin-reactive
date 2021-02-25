package ru.gorbunov.spring.kotlin.reactive.entity

import org.springframework.data.annotation.Id

class Test(
    @Id
    var id: Long? = null,
    val value: String

)