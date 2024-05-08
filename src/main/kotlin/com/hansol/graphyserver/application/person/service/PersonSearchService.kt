package com.hansol.graphyserver.application.person.service

import com.hansol.graphyserver.application.person.domain.PersonSearchDomain
import com.hansol.graphyserver.application.person.port.`in`.PersonSearchInPort
import com.hansol.graphyserver.application.person.port.out.PersonSearchOutPort
import com.hansol.graphyserver.common.dto.GraphySearchResult
import org.springframework.stereotype.Service

@Service
class PersonSearchService(
    private val personSearchOutPort: PersonSearchOutPort,
) : PersonSearchInPort {
    override fun search(personSearchDomain: PersonSearchDomain): GraphySearchResult<PersonSearchDomain> {
        TODO("Not yet implemented")
    }
}