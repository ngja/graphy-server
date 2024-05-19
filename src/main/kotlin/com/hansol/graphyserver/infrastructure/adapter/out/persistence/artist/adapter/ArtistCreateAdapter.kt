package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.adapter

import com.hansol.graphyserver.application.artist.domain.ArtistDomain
import com.hansol.graphyserver.application.artist.port.out.ArtistCreateOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.ArtistEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.ArtistNationalityEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity.MemberEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.repository.ArtistNationalityRepository
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.repository.ArtistRepository
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.repository.MemberRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ArtistCreateAdapter(
    private val artistRepository: ArtistRepository,
    private val memberRepository: MemberRepository,
    private val artistNationalityRepository: ArtistNationalityRepository,
) : ArtistCreateOutPort {
    @Transactional
    fun createArtist(artistDomain: ArtistDomain): ArtistDomain {
        val artistEntity = ArtistEntity.fromDomain(artistDomain)
        val memberEntities = MemberEntity.fromArtistDomain(artistDomain)
        val artistNationalityEntities = ArtistNationalityEntity.fromArtistDomain(artistDomain)
        artistRepository.save(artistEntity)
        memberRepository.saveAll(memberEntities)
        artistNationalityRepository.saveAll(artistNationalityEntities)
        return artistDomain
    }

    @Transactional
    override fun createArtists(artistDomains: Collection<ArtistDomain>): List<ArtistDomain> {
        return artistDomains.map { createArtist(it) }
    }
}