package com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.common.shared.Gender
import java.time.LocalDate

data class PersonCreateApiRequest(
    val surname: String,
    val givenName: String,
    val gender: String,
    val birthday: LocalDate,
) {
    fun toDomain(): PersonDomain {
        return PersonDomain(
            surname = this.surname,
            givenName = this.givenName,
            gender = Gender.from(gender),
            birthday = this.birthday.atStartOfDay(),
        )
    }
}