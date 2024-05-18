package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.adapter

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.application.person.port.out.PersonFindOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.repository.PersonRepository
import org.springframework.stereotype.Component

@Component
class PersonFindAdapter(
    private val personRepository: PersonRepository
) : PersonFindOutPort {
    override fun findListByIds(ids: Collection<Long>): List<PersonDomain> {
        return personRepository.findByIdIn(ids).map { it.toDomain() }
    }

    override fun findMapByIds(ids: Collection<Long>): Map<Long, PersonDomain> {
        return findListByIds(ids).associateBy { it.id }
    }
}