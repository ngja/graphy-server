package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request

import com.hansol.graphyserver.application.artist.domain.ArtistNationalityCreateDomain
import java.time.LocalDateTime

data class ArtistNationalityCreateRequest(
    val countryId: Long,
    val startDatetime: LocalDateTime?,
    val endDatetime: LocalDateTime?,
) {
    fun toCreateDomain(): ArtistNationalityCreateDomain {
        return ArtistNationalityCreateDomain(
            countryId = countryId,
            startDatetime = startDatetime,
            endDatetime = endDatetime,
        )
    }
}