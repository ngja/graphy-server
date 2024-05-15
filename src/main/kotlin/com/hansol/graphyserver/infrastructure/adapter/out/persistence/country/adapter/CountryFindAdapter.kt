package com.hansol.graphyserver.infrastructure.adapter.out.persistence.country.adapter

import com.hansol.graphyserver.application.country.domain.CountryDomain
import com.hansol.graphyserver.application.country.port.out.CountryFindOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.country.entity.QCountryEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class CountryFindAdapter(
    private val jpaQueryFactory: JPAQueryFactory,
) : CountryFindOutPort {
    override fun findAll(): List<CountryDomain> {
        val qCountryEntity = QCountryEntity.countryEntity
        val countryEntities = jpaQueryFactory.selectFrom(qCountryEntity)
            .orderBy(qCountryEntity.id.asc())
            .fetch()
        return countryEntities.map { it.toDomain() }
    }
}