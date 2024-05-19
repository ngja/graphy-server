package com.hansol.graphyserver.application.artist.port.out

import com.hansol.graphyserver.application.artist.domain.ArtistDomain
import com.hansol.graphyserver.application.artist.dto.ArtistSearchCondition

interface ArtistSearchOutPort {
    fun search(artistSearchCondition: ArtistSearchCondition): List<ArtistDomain>
}