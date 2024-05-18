package com.hansol.graphyserver.application.country.port.out

import com.hansol.graphyserver.application.country.domain.CountryDomain

interface CountryFindOutPort {
    fun findAll(): List<CountryDomain>
    fun findListByIds(ids: Collection<Long>): List<CountryDomain>
    fun findMapByIds(ids: Collection<Long>): Map<Long, CountryDomain>
}