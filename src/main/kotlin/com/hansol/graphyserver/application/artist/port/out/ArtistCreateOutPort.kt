package com.hansol.graphyserver.application.artist.port.out

import com.hansol.graphyserver.application.artist.domain.ArtistDomain

interface ArtistCreateOutPort {
    fun createArtists(artistDomains: Collection<ArtistDomain>): List<ArtistDomain>
}