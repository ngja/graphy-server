package com.hansol.graphyserver.application.artist.domain

import com.hansol.graphyserver.application.country.domain.CountryDomain
import com.hansol.graphyserver.common.util.IdUtils
import java.time.LocalDateTime

class ArtistNationalityCreateDomain(
    val id: Long =  IdUtils.generateId(),
    val countryId: Long,
    val startDatetime: LocalDateTime?,
    val endDatetime: LocalDateTime?,
) {

    fun toArtistNationalityDomain(countryDomain: CountryDomain): ArtistNationalityDomain {
        return ArtistNationalityDomain(
            id = id,
            country = countryDomain,
            startDatetime = startDatetime,
            endDatetime = endDatetime,
        )
    }
}