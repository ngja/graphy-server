package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.response

import com.hansol.graphyserver.application.artist.domain.ArtistNationalityDomain
import java.time.LocalDateTime

data class ArtistNationalitySearchResponse(
    val id: Long,
    val country: String,
    val startDatetime: LocalDateTime?,
    val endDatetime: LocalDateTime?,
) {
    companion object {
        fun fromDomain(domain: ArtistNationalityDomain): ArtistNationalitySearchResponse {
            return ArtistNationalitySearchResponse(
                id = domain.id,
                country = domain.country.name,
                startDatetime = domain.startDatetime,
                endDatetime = domain.endDatetime,
            )
        }
    }
}