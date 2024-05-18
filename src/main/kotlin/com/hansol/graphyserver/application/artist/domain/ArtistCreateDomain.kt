package com.hansol.graphyserver.application.artist.domain

import com.hansol.graphyserver.application.country.domain.CountryDomain
import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.common.exception.GraphyException
import com.hansol.graphyserver.common.util.IdUtils

class ArtistCreateDomain(
    val id: Long = IdUtils.generateId(),
    val name: String,
    val memberCreateDomains: List<MemberCreateDomain>,
    val artistNationalityCreateDomains: List<ArtistNationalityCreateDomain>,
) {

    fun toArtistDomain(
        personIdMap: Map<Long, PersonDomain>,
        countryDomain: Map<Long, CountryDomain>,
    ): ArtistDomain {
        return ArtistDomain(
            id = id,
            name = name,
            members = memberCreateDomains.map { it.toMemberDomain(personIdMap[it.personId] ?: throw GraphyException("not found person when create member personId=${it.personId}")) },
            artistNationalities = artistNationalityCreateDomains.map { it.toArtistNationalityDomain(countryDomain[it.countryId] ?: throw GraphyException("not found country when create artistNationality countryId=${it.countryId}")) }
        )
    }
}