package com.hansol.graphyserver.application.artist.domain

import com.hansol.graphyserver.common.util.IdUtils

class ArtistDomain(
    val id: Long = IdUtils.generateId(),
    val name: String,
    val members: List<MemberDomain>,
    val artistNationalities: List<ArtistNationalityDomain>,
) {
}