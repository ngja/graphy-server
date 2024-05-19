package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.adapter

import com.hansol.graphyserver.application.artist.domain.ArtistDomain
import com.hansol.graphyserver.application.artist.dto.ArtistSearchCondition
import com.hansol.graphyserver.application.artist.port.out.ArtistSearchOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.QArtistEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.QArtistNationalityEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.predicate.ArtistNationalitySearchPredicate
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.predicate.ArtistSearchPredicate
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.repository.ArtistNationalityRepository
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.repository.MemberRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class ArtistSearchAdapter(
    private val jpaQueryFactory: JPAQueryFactory,
    private val memberRepository: MemberRepository,
    private val artistNationalityRepository: ArtistNationalityRepository,
) : ArtistSearchOutPort {
    override fun search(artistSearchCondition: ArtistSearchCondition): List<ArtistDomain> {

        val qArtistNationalityEntity = QArtistNationalityEntity.artistNationalityEntity
        val qArtistEntity = QArtistEntity.artistEntity

        val artistNationalityEntities = jpaQueryFactory.selectFrom(qArtistNationalityEntity)
            .where(ArtistNationalitySearchPredicate().searchPredicate(artistSearchCondition))
            .fetch()

        val artistIdSet = artistNationalityEntities.map { it.artist.id }.toSet()

        val artistEntities = jpaQueryFactory.selectFrom(qArtistEntity)
            .where(ArtistSearchPredicate().searchPredicate(artistIdSet, artistSearchCondition))
            .orderBy(qArtistEntity.id.desc())
            .limit(artistSearchCondition.size)
            .fetch()

        val resultArtistIds = artistEntities.map { it.id }

        val membersGroupByArtistId = memberRepository.findAllByArtistIdIn(resultArtistIds).groupBy { it.artist.id }
        val artistNationalitiesGroupByArtistId = artistNationalityRepository.findAllByArtistIdIn(resultArtistIds).groupBy { it.artist.id }

        return artistEntities.map {
            it.toDomain(
                membersGroupByArtistId[it.id].orEmpty(),
                artistNationalitiesGroupByArtistId[it.id].orEmpty(),
            )
        }
    }
}