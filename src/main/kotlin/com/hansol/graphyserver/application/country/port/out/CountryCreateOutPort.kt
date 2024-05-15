package com.hansol.graphyserver.application.country.port.out

import com.hansol.graphyserver.application.country.domain.CountryDomain

interface CountryCreateOutPort {
    fun createCountries(countryDomains: Collection<CountryDomain>): List<CountryDomain>
}