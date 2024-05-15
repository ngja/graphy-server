package com.hansol.graphyserver.infrastructure.adapter.`in`.web.controller

import com.hansol.graphyserver.application.country.port.`in`.CountryCreateInPort
import com.hansol.graphyserver.application.country.port.`in`.CountryFindInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request.CountryCreateApiRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response.CountryCreateApiResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response.CountryFindResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class CountryController(
    private val countryCreateInPort: CountryCreateInPort,
    private val countryFindInPort: CountryFindInPort,
) {

    @PostMapping("/countries")
    fun createCountries(@RequestBody countryCreateApiRequests: List<CountryCreateApiRequest>): GraphyCommonResponse<List<CountryCreateApiResponse>> {
        val countryDomains = countryCreateInPort.createCountries(countryCreateApiRequests.map { it.toDomain() })
        return GraphyCommonResponse(
            data = countryDomains.map { CountryCreateApiResponse.fromDomain(it) }
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