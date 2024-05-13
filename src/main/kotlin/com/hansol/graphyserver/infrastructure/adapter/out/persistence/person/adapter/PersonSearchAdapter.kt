package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.adapter

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.application.person.dto.PersonSearchCondition
import com.hansol.graphyserver.application.person.port.out.PersonSearchOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.entity.QPersonEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.predicate.PersonSearchPredicate
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.repository.PersonRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Service

@Service
class PersonSearchAdapter(
    private val personRepository: PersonRepository,
    private val jpaQueryFactory: JPAQueryFactory,
) : PersonSearchOutPort {

    override fun searchPerson(personSearchCondition: PersonSearchCondition): List<PersonDomain> {
        val qPersonEntity: QPersonEntity = QPersonEntity.personEntity
        val query = jpaQueryFactory
            .selectFrom(qPersonEntity)
            .where(PersonSearchPredicate().searchPredicate(personSearchCondition))
            .orderBy(qPersonEntity.id.desc())
            .limit(personSearchCondition.size)
        val searchResults = query.fetch()
        return searchResults.orEmpty().map { it.toDomain() }
    }

}