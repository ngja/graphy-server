package com.hansol.graphyserver.components.person.dto.internal.request

import com.hansol.graphyserver.common.enums.Gender
import java.time.LocalDateTime

data class PersonCreateDbRequest(
    val surname: String,
    val givenName: String,
    val gender: Gender,
    val birthday: LocalDateTime,
)
