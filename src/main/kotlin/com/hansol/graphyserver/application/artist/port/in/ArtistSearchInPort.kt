package com.hansol.graphyserver.application.artist.port.`in`

import com.hansol.graphyserver.application.artist.domain.ArtistDomain
import com.hansol.graphyserver.application.artist.dto.ArtistSearchCondition

interface ArtistSearchInPort {
    fun search(artistSearchCondition: ArtistSearchCondition): List<ArtistDomain>
}