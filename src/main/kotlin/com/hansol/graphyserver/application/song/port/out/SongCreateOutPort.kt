package com.hansol.graphyserver.application.song.port.out

import com.hansol.graphyserver.application.song.domain.SongDomain

interface SongCreateOutPort {
    fun createSong(songDomains: Collection<SongDomain>): List<SongDomain>
}