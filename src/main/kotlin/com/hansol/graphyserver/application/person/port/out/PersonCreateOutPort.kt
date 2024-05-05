package com.hansol.graphyserver.application.person.port.out

import com.hansol.graphyserver.application.person.domain.PersonDomain

interface PersonCreateOutPort {
    fun create(personDomain: PersonDomain): PersonDomain
}