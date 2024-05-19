package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.response

import com.hansol.graphyserver.application.artist.domain.MemberDomain
import com.hansol.graphyserver.common.shared.Gender
import java.time.LocalDate
import java.time.LocalDateTime

data class MemberSearchResponse(
    val id: Long,
    val stageName: String,
    val gender: Gender,
    val birthday: LocalDate?,
    val startDatetime: LocalDateTime?,
    val endDatetime: LocalDateTime?,
) {
    companion object {
        fun fromDomain(memberDomain: MemberDomain): MemberSearchResponse {
            return MemberSearchResponse(
                id = memberDomain.id,
                stageName = memberDomain.stageName,
                gender = memberDomain.person.gender,
                birthday = memberDomain.person.birthday?.toLocalDate(),
                startDatetime = memberDomain.startDatetime,
                endDatetime = memberDomain.endDatetime,
            )
        }
    }
}
