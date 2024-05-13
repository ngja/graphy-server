package com.hansol.graphyserver.application.person.port.`in`

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.application.person.dto.PersonSearchCondition

interface PersonSearchInPort {
    fun search(personSearchCondition: PersonSearchCondition): List<PersonDomain>
}