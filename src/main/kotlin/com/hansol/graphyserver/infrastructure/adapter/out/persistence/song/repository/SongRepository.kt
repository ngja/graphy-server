package com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.repository

import com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.entity.SongEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SongRepository : JpaRepository<SongEntity, Long> {
}