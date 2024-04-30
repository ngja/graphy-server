package com.hansol.graphyserver.infrastructure.db.person.service

import com.hansol.graphyserver.common.enums.Gender
import com.hansol.graphyserver.components.person.dto.internal.request.PersonCreateDbRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.longs.shouldBeGreaterThan
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class PersonCreateServiceTest(
    private val personCreateService: PersonCreateService,
) : FunSpec({

    test("create") {
        val birthday = LocalDateTime.of(2024, 4, 30, 0, 0)
        val personCreateDbRequest = PersonCreateDbRequest(surname = "김", givenName = "이박", gender = Gender.MALE, birthday = birthday)
        val result = personCreateService.create(personCreateDbRequest)
        result.id shouldBeGreaterThan 0L
    }
})
