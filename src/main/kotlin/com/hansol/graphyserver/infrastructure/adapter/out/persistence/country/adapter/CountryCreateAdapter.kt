package com.hansol.graphyserver.infrastructure.adapter.out.persistence.country.adapter

import com.hansol.graphyserver.application.country.domain.CountryDomain
import com.hansol.graphyserver.application.country.port.out.CountryCreateOutPort
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.country.entity.CountryEntity
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.country.repository.CountryRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class CountryCreateAdapter(
    private val countryRepository: CountryRepository,
) : CountryCreateOutPort {

    @Transactional
    fun createCountry(countryDomain: CountryDomain): CountryDomain {
        val countryEntity = CountryEntity.fromDomain(countryDomain)
        val savedEntity = countryRepository.save(countryEntity)
        return savedEntity.toDomain()
    }

    @Transactional
    override fun createCountries(countryDomains: Collection<CountryDomain>): List<CountryDomain> {
        return countryDomains.map { createCountry(it) }
    }
}