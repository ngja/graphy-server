package com.hansol.graphyserver.application.country.port.`in`

import com.hansol.graphyserver.application.country.domain.CountryDomain

interface CountryCreateInPort {
    fun createCountries(countryDomains: List<CountryDomain>): List<CountryDomain>
}