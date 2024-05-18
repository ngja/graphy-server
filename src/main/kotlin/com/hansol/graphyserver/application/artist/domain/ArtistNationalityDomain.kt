package com.hansol.graphyserver.application.artist.domain

import com.hansol.graphyserver.application.country.domain.CountryDomain
import com.hansol.graphyserver.common.util.IdUtils
import java.time.LocalDateTime

class ArtistNationalityDomain(
    val id: Long = IdUtils.generateId(),
    val country: CountryDomain,
    val startDatetime: LocalDateTime?,
    val endDatetime: LocalDateTime?,
) {
}