package com.hansol.graphyserver.application.artist.service

import com.hansol.graphyserver.application.artist.domain.ArtistCreateDomain
import com.hansol.graphyserver.application.artist.domain.ArtistDomain
import com.hansol.graphyserver.application.artist.port.`in`.ArtistCreateInPort
import com.hansol.graphyserver.application.artist.port.out.ArtistCreateOutPort
import com.hansol.graphyserver.application.country.port.out.CountryFindOutPort
import com.hansol.graphyserver.application.person.port.out.PersonFindOutPort
import org.springframework.stereotype.Service

@Service
class ArtistCreateService(
    private val countryFindOutPort: CountryFindOutPort,
    private val personFindOutPort: PersonFindOutPort,
    private val artistCreateOutPort: ArtistCreateOutPort,
) : ArtistCreateInPort {
    override fun createArtists(artistCreateDomains: List<ArtistCreateDomain>): List<ArtistDomain> {
        // 연관 데이터 조회
        val personIdSet = artistCreateDomains.flatMap { it.memberCreateDomains }.map { it.personId }.toSet()
        val personDomainMap = personFindOutPort.findMapByIds(personIdSet)
        val countryIdSet = artistCreateDomains.flatMap { it.artistNationalityCreateDomains }.map { it.countryId }.toSet()
        val countryDomainMap = countryFindOutPort.findMapByIds(countryIdSet)

        val artistDomains = artistCreateDomains.map { it.toArtistDomain(personDomainMap, countryDomainMap) }
        return artistCreateOutPort.createArtists(artistDomains)
    }
}