package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.adapter

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.application.person.port.out.PersonCreateOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.entity.PersonEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.repository.PersonRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PersonCreateAdapter(
    private val personRepository: PersonRepository,
) : PersonCreateOutPort {
    @Transactional
    override fun create(personDomain: PersonDomain): PersonDomain {
        val personEntity = PersonEntity.fromDomain(personDomain)
        val savedEntity = personRepository.save(personEntity)
        return savedEntity.toDomain()
    }
}