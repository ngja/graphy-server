package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.predicate

import com.hansol.graphyserver.application.artist.dto.ArtistSearchCondition
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.QArtistNationalityEntity
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Predicate

class ArtistNationalitySearchPredicate {
    fun searchPredicate(condition: ArtistSearchCondition): Predicate {
        val qArtistNationalityEntity = QArtistNationalityEntity.artistNationalityEntity
        val booleanBuilder = BooleanBuilder()
        condition.startStartDatetime?.let {
            booleanBuilder.and(qArtistNationalityEntity.startDatetime.goe(condition.startStartDatetime))
        }
        condition.startEndDatetime?.let {
            booleanBuilder.and(qArtistNationalityEntity.startDatetime.lt(condition.startEndDatetime))
        }
        condition.countryIds.isNotEmpty().let {
            booleanBuilder.and(qArtistNationalityEntity.id.`in`(condition.countryIds))
        }
        return booleanBuilder
    }
}