package com.hansol.graphyserver.infrastructure.adapter.`in`.web.controller

import com.hansol.graphyserver.application.person.port.`in`.PersonCreateInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request.PersonCreateApiRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response.PersonCreateApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonCreateController(
    private val personCreateInPort: PersonCreateInPort,
) {

    @PostMapping("/person")
    fun create(personCreateApiRequest: PersonCreateApiRequest): GraphyCommonResponse<PersonCreateApiResponse> {
        val personDomain = personCreateInPort.create(personCreateApiRequest.toDomain())
        return GraphyCommonResponse(
            result = PersonCreateApiResponse.fromDomain(personDomain)
        )
    }
}