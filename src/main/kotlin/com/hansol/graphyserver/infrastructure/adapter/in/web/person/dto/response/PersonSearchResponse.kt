package com.hansol.graphyserver.infrastructure.adapter.`in`.web.person.dto.response

import com.hansol.graphyserver.application.person.domain.PersonDomain
import java.time.LocalDate

data class PersonSearchResponse(
    val surname: String,
    val givenName: String,
    val birthday: LocalDate?,
) {
    companion object {
        fun fromDomain(personDomain: PersonDomain): PersonSearchResponse {
            return PersonSearchResponse(
                surname = personDomain.surname,
                givenName = personDomain.givenName,
                birthday = personDomain.birthday?.toLocalDate(),
            )
        }
    }
}
