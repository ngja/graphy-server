package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request

import com.hansol.graphyserver.application.artist.domain.ArtistDomain

data class ArtistCreateResponse(
    val id: Long,
) {
    companion object {
        fun fromDomain(artistDomain: ArtistDomain): ArtistCreateResponse {
            return ArtistCreateResponse(
                id = artistDomain.id,
            )
        }
    }
}
