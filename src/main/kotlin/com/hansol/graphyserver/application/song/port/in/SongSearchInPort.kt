package com.hansol.graphyserver.application.song.port.`in`

import com.hansol.graphyserver.application.song.domain.SongDomain
import com.hansol.graphyserver.application.song.dto.SongSearchCondition

interface SongSearchInPort {
    fun search(songSearchCondition: SongSearchCondition): List<SongDomain>
}