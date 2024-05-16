package com.hansol.graphyserver.infrastructure.adapter.`in`.web.song.dto.request

import com.hansol.graphyserver.application.song.dto.SongSearchCondition
import java.time.LocalDate

data class SongSearchRequest(
    val nameKeyword: String? = null,
    val releaseStartDate: LocalDate? = null,
    val releaseEndDate: LocalDate? = null,
    val cursor: Long? = null,
    val size: Long = 20L,
) {
    fun toCondition(): SongSearchCondition {
        return SongSearchCondition(
            nameKeyword = this.nameKeyword,
            releaseStartDate = this.releaseStartDate,
            releaseEndDate = this.releaseEndDate,
            cursor = cursor,
            size = size,
        )
    }
}
