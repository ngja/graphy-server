package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.predicate

import com.hansol.graphyserver.application.person.dto.PersonSearchCondition
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.entity.QPersonEntity
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Predicate

class PersonSearchPredicate {
    fun searchPredicate(personSearchCondition: PersonSearchCondition): Predicate {
        val qPersonEntity: QPersonEntity = QPersonEntity.personEntity
        val booleanBuilder = BooleanBuilder()
        personSearchCondition.ids?.let { booleanBuilder.and(qPersonEntity.id.`in`(personSearchCondition.ids)) }
        personSearchCondition.cursor?.let { booleanBuilder.and(qPersonEntity.id.gt(personSearchCondition.cursor)) }
        return booleanBuilder
    }
}