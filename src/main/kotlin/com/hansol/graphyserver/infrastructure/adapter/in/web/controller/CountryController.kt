package com.hansol.graphyserver.infrastructure.adapter.`in`.web.controller

import com.hansol.graphyserver.application.country.port.`in`.CountryCreateInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request.CountryCreateApiRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response.CountryCreateApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CountryController(
    private val countryCreateInPort: CountryCreateInPort,
) {

    @PostMapping("/countries")
    fun createCountries(@RequestBody countryCreateApiRequests: List<CountryCreateApiRequest>): GraphyCommonResponse<List<CountryCreateApiResponse>> {
        val countryDomains = countryCreateInPort.createCountries(countryCreateApiRequests.map { it.toDomain() })
        return GraphyCommonResponse(
            data = countryDomains.map { CountryCreateApiResponse.fromDomain(it) }
        )
    }
}