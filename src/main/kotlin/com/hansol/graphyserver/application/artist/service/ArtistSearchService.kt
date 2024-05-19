package com.hansol.graphyserver.application.artist.service

import com.hansol.graphyserver.application.artist.domain.ArtistDomain
import com.hansol.graphyserver.application.artist.dto.ArtistSearchCondition
import com.hansol.graphyserver.application.artist.port.`in`.ArtistSearchInPort
import com.hansol.graphyserver.application.artist.port.out.ArtistSearchOutPort
import org.springframework.stereotype.Service

@Service
class ArtistSearchService(
    private val artistSearchOutPort: ArtistSearchOutPort,
) : ArtistSearchInPort {
    override fun search(artistSearchCondition: ArtistSearchCondition): List<ArtistDomain> {
        return artistSearchOutPort.search(artistSearchCondition)
    }
}