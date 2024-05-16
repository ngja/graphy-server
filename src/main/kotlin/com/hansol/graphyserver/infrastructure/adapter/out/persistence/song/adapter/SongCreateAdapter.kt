package com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.adapter

import com.hansol.graphyserver.application.song.domain.SongDomain
import com.hansol.graphyserver.application.song.port.out.SongCreateOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.entity.SongEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.repository.SongRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class SongCreateAdapter(
    private val songRepository: SongRepository,
) : SongCreateOutPort {

    @Transactional
    fun createSong(songDomain: SongDomain): SongDomain {
        val songEntity = SongEntity.fromDomain(songDomain)
        val savedEntity = songRepository.save(songEntity)
        return savedEntity.toDomain()
    }

    @Transactional
    override fun createSong(songDomains: Collection<SongDomain>): List<SongDomain> {
        return songDomains.map { createSong(it) }
    }
}