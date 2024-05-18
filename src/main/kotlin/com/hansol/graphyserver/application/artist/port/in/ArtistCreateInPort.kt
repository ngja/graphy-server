package com.hansol.graphyserver.application.artist.port.`in`

import com.hansol.graphyserver.application.artist.domain.ArtistCreateDomain
import com.hansol.graphyserver.application.artist.domain.ArtistDomain

interface ArtistCreateInPort {
    fun createArtists(artistCreateDomains: List<ArtistCreateDomain>): List<ArtistDomain>
}