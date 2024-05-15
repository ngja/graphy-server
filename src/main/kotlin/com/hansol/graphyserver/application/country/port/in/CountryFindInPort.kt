package com.hansol.graphyserver.application.country.port.`in`

import com.hansol.graphyserver.application.country.domain.CountryDomain

interface CountryFindInPort {
    fun findAllCountries(): List<CountryDomain>
}