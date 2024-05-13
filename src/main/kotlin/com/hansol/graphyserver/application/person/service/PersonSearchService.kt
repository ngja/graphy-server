package com.hansol.graphyserver.application.person.service

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.application.person.dto.PersonSearchCondition
import com.hansol.graphyserver.application.person.port.`in`.PersonSearchInPort
import com.hansol.graphyserver.application.person.port.out.PersonSearchOutPort
import org.springframework.stereotype.Service

@Service
class PersonSearchService(
    private val personSearchOutPort: PersonSearchOutPort,
) : PersonSearchInPort {
    override fun search(personSearchCondition: PersonSearchCondition): List<PersonDomain> {
        val personSearchResults = personSearchOutPort.searchPerson(personSearchCondition)
        return personSearchResults
    }
}