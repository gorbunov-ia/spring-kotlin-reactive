package ru.gorbunov.spring.kotlin.web.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.gorbunov.spring.kotlin.web.entity.Test

@Repository
interface TestRepository : CrudRepository<Test, Long> {
}