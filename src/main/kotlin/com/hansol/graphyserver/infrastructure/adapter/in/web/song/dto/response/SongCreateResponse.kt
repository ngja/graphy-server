package com.hansol.graphyserver.infrastructure.adapter.`in`.web.song.dto.response

import com.hansol.graphyserver.application.song.domain.SongDomain

data class SongCreateResponse(
    val id: Long,
) {
    companion object {
        fun fromDomain(songDomain: SongDomain): SongCreateResponse {
            return SongCreateResponse(
                id = songDomain.id
            )
        }
    }
}
