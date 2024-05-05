package com.hansol.graphyserver.application.person.port.`in`

import com.hansol.graphyserver.application.person.domain.PersonDomain

interface PersonCreateInPort {
    fun create(personDomain: PersonDomain): PersonDomain
}