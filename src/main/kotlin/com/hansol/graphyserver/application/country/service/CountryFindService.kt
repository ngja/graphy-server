package com.hansol.graphyserver.application.country.service

import com.hansol.graphyserver.application.country.domain.CountryDomain
import com.hansol.graphyserver.application.country.port.`in`.CountryFindInPort
import com.hansol.graphyserver.application.country.port.out.CountryFindOutPort
import org.springframework.stereotype.Service

@Service
class CountryFindService(
    private val countryFindOutPort: CountryFindOutPort,
) : CountryFindInPort {
    override fun findAllCountries(): List<CountryDomain> {
        return countryFindOutPort.findAll()
    }
}