package com.hansol.graphyserver.application.song.service

import com.hansol.graphyserver.application.song.domain.SongDomain
import com.hansol.graphyserver.application.song.port.`in`.SongCreateInPort
import com.hansol.graphyserver.application.song.port.out.SongCreateOutPort
import org.springframework.stereotype.Service

@Service
class SongCreateService(
    private val songCreateOutPort: SongCreateOutPort,
) : SongCreateInPort {
    override fun createSongs(songRequests: Collection<SongDomain>): List<SongDomain> {
        return songCreateOutPort.createSong(songRequests)
    }
}