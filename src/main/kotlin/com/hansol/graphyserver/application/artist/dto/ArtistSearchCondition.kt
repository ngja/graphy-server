package com.hansol.graphyserver.application.artist.dto

import java.time.LocalDateTime

data class ArtistSearchCondition(
    val nameKeyword: String? = null,
    val startStartDatetime: LocalDateTime? = null,
    val startEndDatetime: LocalDateTime? = null,
    val countryIds: List<Long> = emptyList(),
    val cursor: Long? = null,
    val size: Long = 20L,
)
