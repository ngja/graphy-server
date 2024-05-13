package com.hansol.graphyserver.application.person.port.out

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.application.person.dto.PersonSearchCondition

interface PersonSearchOutPort {
    fun searchPerson(personSearchCondition: PersonSearchCondition): List<PersonDomain>
}