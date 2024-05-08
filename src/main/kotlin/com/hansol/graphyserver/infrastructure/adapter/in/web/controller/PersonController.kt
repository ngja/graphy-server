package com.hansol.graphyserver.infrastructure.adapter.`in`.web.controller

import com.hansol.graphyserver.application.person.port.`in`.PersonCreateInPort
import com.hansol.graphyserver.application.person.port.`in`.PersonSearchInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request.PersonCreateApiRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request.PersonSearchRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response.PersonCreateApiResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response.PersonSearchResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(
    private val personCreateInPort: PersonCreateInPort,
    private val personSearchInPort: PersonSearchInPort,
) {

    @PostMapping("/person")
    fun create(personCreateApiRequest: PersonCreateApiRequest): GraphyCommonResponse<PersonCreateApiResponse> {
        val personDomain = personCreateInPort.create(personCreateApiRequest.toDomain())
        return GraphyCommonResponse(
            data = PersonCreateApiResponse.fromDomain(personDomain)
        )
    }

    @GetMapping("/person")
    fun search(personSearchRequest: PersonSearchRequest): GraphyCommonResponse<List<PersonSearchResponse>> {
        val results = personSearchInPort.search(personSearchRequest.toDomain())
        return GraphyCommonResponse(
            data = results.results.map { PersonSearchResponse.fromDomain(it) },
            page = results.page,
            size = results.size,
            more = results.more
        )
    }
}