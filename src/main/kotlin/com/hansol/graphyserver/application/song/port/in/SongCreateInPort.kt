package com.hansol.graphyserver.application.song.port.`in`

import com.hansol.graphyserver.application.song.domain.SongDomain

interface SongCreateInPort {
    fun createSongs(songRequests: Collection<SongDomain>): List<SongDomain>
}