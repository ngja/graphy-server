package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request

import com.hansol.graphyserver.application.artist.domain.MemberCreateDomain
import java.time.LocalDateTime

data class MemberCreateRequest(
    val stageName: String,
    val personId: Long,
    val startDatetime: LocalDateTime?,
    val endDatetime: LocalDateTime?,
) {
    fun toCreateDomain(): MemberCreateDomain {
        return MemberCreateDomain(
            stageName = stageName,
            personId = personId,
            startDatetime = startDatetime,
            endDatetime = endDatetime,
        )
    }
}
