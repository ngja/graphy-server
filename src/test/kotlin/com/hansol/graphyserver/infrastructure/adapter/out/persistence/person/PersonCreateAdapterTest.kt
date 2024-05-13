package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.common.shared.Gender
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.adapter.PersonCreateAdapter
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.longs.shouldBeGreaterThan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@SpringBootTest
@Transactional
class PersonCreateAdapterTest(
    private val personCreateAdapter: PersonCreateAdapter,
) : FunSpec({

    extension(SpringExtension)

    test("create") {
        val birthday = LocalDateTime.of(2024, 4, 30, 0, 0)
        val personDomain = PersonDomain(surname = "", givenName = "", gender = Gender.MALE, birthday = birthday)
        val result = personCreateAdapter.create(personDomain)
        result.id shouldBeGreaterThan 0L
    }
})
