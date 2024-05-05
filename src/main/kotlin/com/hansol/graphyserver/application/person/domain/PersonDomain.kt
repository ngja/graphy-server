package com.hansol.graphyserver.application.person.domain

import com.hansol.graphyserver.common.shared.Gender
import com.hansol.graphyserver.common.util.IdUtils
import java.time.LocalDateTime

class PersonDomain(
    val id: Long = IdUtils.generateId(),
    val surname: String,
    val givenName: String,
    val gender: Gender,
    val birthday: LocalDateTime?
) {





}