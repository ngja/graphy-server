package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request

import com.hansol.graphyserver.application.artist.domain.ArtistCreateDomain

data class ArtistCreateRequest(
    val name: String,
    val members: List<MemberCreateRequest>,
    val artistNationalities: List<ArtistNationalityCreateRequest>,
) {
    fun toCreateDomain(): ArtistCreateDomain {
        return ArtistCreateDomain(
            name = name,
            memberCreateDomains = members.map { it.toCreateDomain() },
            artistNationalityCreateDomains = artistNationalities.map { it.toCreateDomain() },
        )
    }
}
