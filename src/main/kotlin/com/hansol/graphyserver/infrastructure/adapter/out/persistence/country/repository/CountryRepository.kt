package com.hansol.graphyserver.infrastructure.adapter.out.persistence.country.repository

import com.hansol.graphyserver.infrastructure.adapter.out.persistence.country.entity.CountryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository : JpaRepository<CountryEntity, Long> {
}