package com.hansol.graphyserver.application.song.service

import com.hansol.graphyserver.application.song.domain.SongDomain
import com.hansol.graphyserver.application.song.dto.SongSearchCondition
import com.hansol.graphyserver.application.song.port.`in`.SongSearchInPort
import com.hansol.graphyserver.application.song.port.out.SongSearchOutPort
import org.springframework.stereotype.Service

@Service
class SongSearchService(
    private val songSearchOutPort: SongSearchOutPort,
) : SongSearchInPort {
    override fun search(songSearchCondition: SongSearchCondition): List<SongDomain> {
        return songSearchOutPort.searchSong(songSearchCondition)
    }
}