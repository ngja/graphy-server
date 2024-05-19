package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.response

import com.hansol.graphyserver.application.artist.domain.ArtistDomain

data class ArtistSearchResponse(
    val id: Long,
    val name: String,
    val members: List<MemberSearchResponse>,
    val nationalities: List<ArtistNationalitySearchResponse>,
) {
    companion object {
        fun fromDomain(artistDomain: ArtistDomain): ArtistSearchResponse {
            return ArtistSearchResponse(
                id = artistDomain.id,
                name = artistDomain.name,
                members = artistDomain.members.map { MemberSearchResponse.fromDomain(it) },
                nationalities = artistDomain.artistNationalities.map { ArtistNationalitySearchResponse.fromDomain(it) },
            )
        }
    }
}