package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.repository

import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.ArtistNationalityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ArtistNationalityRepository : JpaRepository<ArtistNationalityEntity, Long> {
    @Query("select an from ArtistNationalityEntity an join fetch an.country join fetch an.artist")
    fun findAllByArtistIdIn(artistIds: Collection<Long>): List<ArtistNationalityEntity>
}