package com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response

import com.hansol.graphyserver.application.person.domain.PersonSearchDomain
import java.time.LocalDate

data class PersonSearchResponse(
    val surname: String,
    val givenName: String,
    val birthday: LocalDate,
) {
    companion object {
        fun fromDomain(personSearchDomain: PersonSearchDomain): PersonSearchResponse {
            return PersonSearchResponse(
                surname = "",
                givenName = "",
                birthday = LocalDate.now(),
            )
        }
    }
}
