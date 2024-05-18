package com.hansol.graphyserver.infrastructure.adapter.`in`.web.song.dto.response

import com.hansol.graphyserver.application.song.domain.SongDomain
import java.time.LocalDate

data class SongSearchResponse(
    val id: Long,
    val name: String,
    val releaseDate: LocalDate,
    val duration: Int,
) {

    companion object {
        fun fromDomain(songDomain: SongDomain): SongSearchResponse {
            return SongSearchResponse(
                id = songDomain.id,
                name = songDomain.name,
                releaseDate = songDomain.releaseDatetime.toLocalDate(),
                duration = songDomain.duration,
            )
        }
    }
}
