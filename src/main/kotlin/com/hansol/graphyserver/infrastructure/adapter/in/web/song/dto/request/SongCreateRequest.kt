package com.hansol.graphyserver.infrastructure.adapter.`in`.web.song.dto.request

import com.hansol.graphyserver.application.song.domain.SongDomain
import java.time.LocalDate

data class SongCreateRequest(
    val name: String,
    val releaseDate: LocalDate,
    val duration: Int,
) {
    fun toDomain(): SongDomain {
        return SongDomain(
            name = this.name,
            releaseDatetime = this.releaseDate.atStartOfDay(),
            duration = this.duration,
        )
    }
}
