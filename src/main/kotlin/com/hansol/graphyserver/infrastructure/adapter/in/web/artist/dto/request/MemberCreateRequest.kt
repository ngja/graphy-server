package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request

import com.hansol.graphyserver.application.artist.domain.MemberCreateDomain
import java.time.LocalDate

data class MemberCreateRequest(
    val stageName: String,
    val personId: Long,
    val startDate: LocalDate?,
    val endDate: LocalDate?,
) {
    fun toCreateDomain(): MemberCreateDomain {
        return MemberCreateDomain(
            stageName = stageName,
            personId = personId,
            startDatetime = startDate?.atStartOfDay(),
            endDatetime = endDate?.atStartOfDay(),
        )
    }
}
