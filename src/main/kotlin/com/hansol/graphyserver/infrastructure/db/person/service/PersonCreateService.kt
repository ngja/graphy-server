package com.hansol.graphyserver.infrastructure.db.person.service

import com.hansol.graphyserver.common.exception.GraphyException
import com.hansol.graphyserver.components.person.dto.internal.request.PersonCreateDbRequest
import com.hansol.graphyserver.components.person.dto.internal.response.PersonCreateDbResponse
import com.hansol.graphyserver.infrastructure.db.person.entity.PersonEntity
import com.hansol.graphyserver.infrastructure.db.person.repository.PersonRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PersonCreateService(
    private val personRepository: PersonRepository,
) {

    @Transactional
    fun create(personCreateDbRequest: PersonCreateDbRequest): PersonCreateDbResponse {
        val personEntity = PersonEntity(personCreateDbRequest)
        val savedPersonEntity = personRepository.save(personEntity)
        return PersonCreateDbResponse(id = savedPersonEntity.id ?: throw GraphyException("person 저장 실패"))
    }
}