package com.hansol.graphyserver.application.country.service

import com.hansol.graphyserver.application.country.domain.CountryDomain
import com.hansol.graphyserver.application.country.port.`in`.CountryCreateInPort
import com.hansol.graphyserver.application.country.port.out.CountryCreateOutPort
import org.springframework.stereotype.Service

@Service
class CountryCreateService(
    private val countryCreateOutPort: CountryCreateOutPort,
) : CountryCreateInPort {
    override fun createCountries(countryDomains: List<CountryDomain>): List<CountryDomain> {
        return countryCreateOutPort.createCountries(countryDomains)
    }
}