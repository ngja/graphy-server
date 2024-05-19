package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.repository

import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<MemberEntity, Long> {
    @Query("select m from MemberEntity m join fetch m.person join fetch m.artist")
    fun findAllByArtistIdIn(artistIds: Collection<Long>): List<MemberEntity>
}