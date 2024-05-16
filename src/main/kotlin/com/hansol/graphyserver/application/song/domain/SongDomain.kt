package com.hansol.graphyserver.application.song.domain

import com.hansol.graphyserver.common.util.IdUtils
import java.time.LocalDateTime

class SongDomain(
    val id: Long = IdUtils.generateId(),
    val name: String,
    val releaseDateTime: LocalDateTime,
    val duration: Int,
) {

}
