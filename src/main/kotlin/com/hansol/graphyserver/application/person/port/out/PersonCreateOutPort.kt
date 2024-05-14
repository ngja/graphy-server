package com.hansol.graphyserver.application.person.port.out

import com.hansol.graphyserver.application.person.domain.PersonDomain

interface PersonCreateOutPort {
    fun createPersons(personDomains: Collection<PersonDomain>): List<PersonDomain>
}