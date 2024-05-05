package com.hansol.graphyserver.application.person.service

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.application.person.port.`in`.PersonCreateInPort
import com.hansol.graphyserver.application.person.port.out.PersonCreateOutPort
import org.springframework.stereotype.Service

@Service
class PersonCreateService(
    private val personCreateOutPort: PersonCreateOutPort,
) : PersonCreateInPort {

    override fun create(personDomain: PersonDomain): PersonDomain {
        return personCreateOutPort.create(personDomain)
    }
}