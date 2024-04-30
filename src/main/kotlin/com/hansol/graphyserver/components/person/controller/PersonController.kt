package com.hansol.graphyserver.components.person.controller

import com.hansol.graphyserver.components.person.dto.external.request.PersonCreateApiRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    @PostMapping("")
    fun create(personCreateApiRequest: PersonCreateApiRequest) {

    }
}