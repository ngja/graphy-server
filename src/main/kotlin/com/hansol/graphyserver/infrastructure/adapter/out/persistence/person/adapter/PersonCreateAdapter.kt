package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.adapter

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.application.person.port.out.PersonCreateOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.entity.PersonEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.repository.PersonRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PersonCreateAdapter(
    private val personRepository: PersonRepository,
) : PersonCreateOutPort {
    @Transactional
    fun createPerson(personDomain: PersonDomain): PersonDomain {
        val personEntity = PersonEntity.fromDomain(personDomain)
        val savedEntity = personRepository.save(personEntity)
        return savedEntity.toDomain()
    }

    @Transactional
    override fun createPersons(personDomains: Collection<PersonDomain>): List<PersonDomain> {
        return personDomains.map { createPerson(it) }
    }
}