package com.hansol.graphyserver.application.artist.domain

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.common.util.IdUtils
import java.time.LocalDateTime

class MemberCreateDomain(
    val id: Long = IdUtils.generateId(),
    val stageName: String,
    val personId: Long,
    val startDatetime: LocalDateTime?,
    val endDatetime: LocalDateTime?,
) {

    fun toMemberDomain(personDomain: PersonDomain): MemberDomain {
        return MemberDomain(
            id = id,
            stageName = stageName,
            person = personDomain,
            startDatetime = startDatetime,
            endDatetime = endDatetime,
        )
    }
}