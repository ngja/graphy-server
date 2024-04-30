package com.hansol.graphyserver.components.person.dto.external.request

import com.hansol.graphyserver.common.enums.Gender
import java.time.LocalDate

data class PersonCreateApiRequest(
    val surname: String,
    val givenName: String,
    val gender: Gender,
    val birthday: LocalDate,
)