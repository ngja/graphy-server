package com.hansol.graphyserver.application.song.dto

import java.time.LocalDate

data class SongSearchCondition(
    val nameKeyword: String? = null,
    val releaseStartDate: LocalDate? = null,
    val releaseEndDate: LocalDate? = null,
    val cursor: Long? = null,
    val size: Long = 20L,
)
