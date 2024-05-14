package com.hansol.graphyserver.infrastructure.adapter.`in`.web.controller

import com.hansol.graphyserver.application.person.port.`in`.PersonCreateInPort
import com.hansol.graphyserver.application.person.port.`in`.PersonSearchInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request.PersonCreateApiRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request.PersonSearchRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response.PersonCreateApiResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response.PersonSearchResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PersonController(
    private val personCreateInPort: PersonCreateInPort,
    private val personSearchInPort: PersonSearchInPort,
) {

    @PostMapping("/person")
    fun createPerson(@RequestBody personCreateApiRequest: PersonCreateApiRequest): GraphyCommonResponse<PersonCreateApiResponse> {
        val personDomains = personCreateInPort.createPersons(listOf(personCreateApiRequest.toDomain()))
        return GraphyCommonResponse(
            data = PersonCreateApiResponse.fromDomain(personDomains.first())
        )
    }

    @PostMapping("/persons")
    fun createPersons(@RequestBody personCreateApiRequests: List<PersonCreateApiRequest>): GraphyCommonResponse<List<PersonCreateApiResponse>> {
        val personDomains = personCreateInPort.createPersons(personCreateApiRequests.map { it.toDomain() })
        return GraphyCommonResponse(
            data = personDomains.map { PersonCreateApiResponse.fromDomain(it) }
        )
    }

    @GetMapping("/persons")
    fun search(@RequestBody personSearchRequest: PersonSearchRequest): GraphyCommonResponse<List<PersonSearchResponse>> {
        val results = personSearchInPort.search(personSearchRequest.toCondition())
        return GraphyCommonResponse(
            data = results.map { PersonSearchResponse.fromDomain(it) },
            nextCursor = results.lastOrNull()?.id,
            size = results.size,
            more = results.isNotEmpty(),
        )
    }
}