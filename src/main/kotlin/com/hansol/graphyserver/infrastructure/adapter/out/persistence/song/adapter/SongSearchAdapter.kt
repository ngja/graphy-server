package com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.adapter

import com.hansol.graphyserver.application.song.domain.SongDomain
import com.hansol.graphyserver.application.song.dto.SongSearchCondition
import com.hansol.graphyserver.application.song.port.out.SongSearchOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.entity.QSongEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.predicate.SongSearchPredicate
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class SongSearchAdapter(
    private val jpaQueryFactory: JPAQueryFactory,
) : SongSearchOutPort {

    override fun searchSong(songSearchCondition: SongSearchCondition): List<SongDomain> {
        val qSongEntity = QSongEntity.songEntity
        val query = jpaQueryFactory
            .selectFrom(qSongEntity)
            .where(SongSearchPredicate().searchPredicate(songSearchCondition))
            .orderBy(qSongEntity.id.desc())
            .limit(songSearchCondition.size)
        val searchResults = query.fetch()
        return searchResults.orEmpty().map { it.toDomain() }
    }
}