package com.hansol.graphyserver.infrastructure.adapter.`in`.web.person.dto.response

import com.hansol.graphyserver.application.person.domain.PersonDomain
import java.time.LocalDate

data class PersonCreateResponse(
    val id: Long,
    val surname: String,
    val givenName: String,
    val gender: String,
    val genderLabel: String,
    val birthday: LocalDate?,
) {
    companion object {
        fun fromDomain(personDomain: PersonDomain): PersonCreateResponse {
            return PersonCreateResponse(
                id = personDomain.id,
                surname = personDomain.surname,
                givenName = personDomain.givenName,
                gender = personDomain.gender.name,
                genderLabel = personDomain.gender.label,
                birthday = personDomain.birthday?.toLocalDate()
            )
        }
    }
}
