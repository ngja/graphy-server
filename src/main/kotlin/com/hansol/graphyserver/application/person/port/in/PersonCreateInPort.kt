package com.hansol.graphyserver.application.person.port.`in`

import com.hansol.graphyserver.application.person.domain.PersonDomain

interface PersonCreateInPort {
    fun createPersons(personDomains: Collection<PersonDomain>): List<PersonDomain>
}