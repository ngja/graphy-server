package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.repository

import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.ArtistEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtistRepository : JpaRepository<ArtistEntity, Long> {
}