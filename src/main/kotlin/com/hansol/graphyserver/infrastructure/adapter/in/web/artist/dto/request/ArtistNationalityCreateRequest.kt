package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request

import com.hansol.graphyserver.application.artist.domain.ArtistNationalityCreateDomain
import java.time.LocalDate

data class ArtistNationalityCreateRequest(
    val countryId: Long,
    val startDate: LocalDate?,
    val endDate: LocalDate?,
) {
    fun toCreateDomain(): ArtistNationalityCreateDomain {
        return ArtistNationalityCreateDomain(
            countryId = countryId,
            startDatetime = startDate?.atStartOfDay(),
            endDatetime = endDate?.atStartOfDay(),
        )
    }
}