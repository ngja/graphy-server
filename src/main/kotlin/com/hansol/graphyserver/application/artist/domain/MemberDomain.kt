package com.hansol.graphyserver.application.artist.domain

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.common.util.IdUtils
import java.time.LocalDateTime

class MemberDomain(
    val id: Long = IdUtils.generateId(),
    val stageName: String,
    val person: PersonDomain,
    val startDatetime: LocalDateTime?,
    val endDatetime: LocalDateTime?,
) {
}