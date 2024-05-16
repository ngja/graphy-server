package com.hansol.graphyserver.infrastructure.adapter.`in`.web.person.controller

import com.hansol.graphyserver.application.person.port.`in`.PersonCreateInPort
import com.hansol.graphyserver.application.person.port.`in`.PersonSearchInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.person.dto.request.PersonCreateRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.person.dto.request.PersonSearchRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.person.dto.response.PersonCreateResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.person.dto.response.PersonSearchResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PersonController(
    private val personCreateInPort: PersonCreateInPort,
    private val personSearchInPort: PersonSearchInPort,
) {

    @PostMapping("/person")
    fun createPerson(@RequestBody personCreateRequest: PersonCreateRequest): GraphyCommonResponse<PersonCreateResponse> {
        val personDomains = personCreateInPort.createPersons(listOf(personCreateRequest.toDomain()))
        return GraphyCommonResponse(
            data = PersonCreateResponse.fromDomain(personDomains.first())
        )
    }

    @PostMapping("/persons")
    fun createPersons(@RequestBody personCreateRequests: List<PersonCreateRequest>): GraphyCommonResponse<List<PersonCreateResponse>> {
        val personDomains = personCreateInPort.createPersons(personCreateRequests.map { it.toDomain() })
        return GraphyCommonResponse(
            data = personDomains.map { PersonCreateResponse.fromDomain(it) }
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