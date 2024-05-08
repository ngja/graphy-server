package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person

import com.hansol.graphyserver.application.person.port.out.PersonSearchOutPort
import org.springframework.stereotype.Service

@Service
class PersonSearchAdapter(
    private val personRepository: PersonRepository,
) : PersonSearchOutPort {

}