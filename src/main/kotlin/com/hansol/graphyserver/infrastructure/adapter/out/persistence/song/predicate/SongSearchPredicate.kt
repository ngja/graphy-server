package com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.predicate

import com.hansol.graphyserver.application.song.dto.SongSearchCondition
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.entity.QSongEntity
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Predicate

class SongSearchPredicate {
    fun searchPredicate(songSearchCondition: SongSearchCondition): Predicate {
        val qSongEntity = QSongEntity.songEntity
        val booleanBuilder = BooleanBuilder()
        songSearchCondition.cursor?.let {
            booleanBuilder.and(qSongEntity.id.lt(songSearchCondition.cursor))
        }
        songSearchCondition.nameKeyword?.let {
            booleanBuilder.and(qSongEntity.name.containsIgnoreCase(songSearchCondition.nameKeyword))
        }
        songSearchCondition.releaseStartDate?.let {
            booleanBuilder.and(qSongEntity.releaseDateTime.goe(songSearchCondition.releaseStartDate.atStartOfDay()))
        }
        songSearchCondition.releaseEndDate?.let {
            booleanBuilder.and(qSongEntity.releaseDateTime.lt(songSearchCondition.releaseEndDate.plusDays(1L).atStartOfDay()))
        }
        return booleanBuilder
    }
}