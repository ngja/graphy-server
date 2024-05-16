package com.hansol.graphyserver.application.song.port.out

import com.hansol.graphyserver.application.song.domain.SongDomain
import com.hansol.graphyserver.application.song.dto.SongSearchCondition

interface SongSearchOutPort {
    fun searchSong(songSearchCondition: SongSearchCondition): List<SongDomain>
}