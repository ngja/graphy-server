package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request

import com.hansol.graphyserver.application.artist.dto.ArtistSearchCondition
import java.time.LocalDate

data class ArtistSearchRequest(
    val nameKeyword: String? = null,
    val startStartDate: LocalDate? = null,
    val startEndDate: LocalDate? = null,
    val countryIds: List<Long> = emptyList(),
    val cursor: Long? = null,
    val size: Int = 20,
) {
    fun toCondition(): ArtistSearchCondition {
        return ArtistSearchCondition(
            nameKeyword = nameKeyword,
            startStartDatetime = startStartDate?.atStartOfDay(),
            startEndDatetime = startEndDate?.plusDays(1)?.atStartOfDay(),
            countryIds = countryIds,
            cursor = cursor,
            size = size.toLong(),
        )
    }
}
