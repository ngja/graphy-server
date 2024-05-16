package com.hansol.graphyserver.infrastructure.adapter.`in`.web.country.controller

import com.hansol.graphyserver.application.country.port.`in`.CountryCreateInPort
import com.hansol.graphyserver.application.country.port.`in`.CountryFindInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.country.dto.request.CountryCreateRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.country.dto.response.CountryCreateResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.country.dto.response.CountryFindResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class CountryController(
    private val countryCreateInPort: CountryCreateInPort,
    private val countryFindInPort: CountryFindInPort,
) {

    @PostMapping("/countries")
    fun createCountries(@RequestBody countryCreateRequests: List<CountryCreateRequest>): GraphyCommonResponse<List<CountryCreateResponse>> {
        val countryDomains = countryCreateInPort.createCountries(countryCreateRequests.map { it.toDomain() })
        return GraphyCommonResponse(
            data = countryDomains.map { CountryCreateResponse.fromDomain(it) }
        )
    }

    @GetMapping("/countries")
    fun findAll(): GraphyCommonResponse<List<CountryFindResponse>> {
        val countryDomains = countryFindInPort.findAllCountries()
        return GraphyCommonResponse(
            data =  countryDomains.map { CountryFindResponse.fromDomain(it) }
        )
    }
}