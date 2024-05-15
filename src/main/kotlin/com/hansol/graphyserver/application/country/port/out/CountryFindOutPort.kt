package com.hansol.graphyserver.application.country.port.out

import com.hansol.graphyserver.application.country.domain.CountryDomain

interface CountryFindOutPort {
    fun findAll(): List<CountryDomain>
}