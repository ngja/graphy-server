package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.repository

import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<MemberEntity, Long> {
}