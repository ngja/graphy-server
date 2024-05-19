package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.predicate

import com.hansol.graphyserver.application.artist.dto.ArtistSearchCondition
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.QArtistEntity
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Predicate

class ArtistSearchPredicate {
    fun searchPredicate(ids: Collection<Long>, condition: ArtistSearchCondition): Predicate {
        val qArtistEntity = QArtistEntity.artistEntity
        val booleanBuilder = BooleanBuilder()
        condition.cursor?.let {
            booleanBuilder.and(qArtistEntity.id.lt(condition.cursor))
        }
        return booleanBuilder
    }
}