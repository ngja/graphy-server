package com.hansol.graphyserver.application.person.port.`in`

import com.hansol.graphyserver.application.person.domain.PersonSearchDomain
import com.hansol.graphyserver.common.dto.GraphySearchResult

interface PersonSearchInPort {
    fun search(personSearchDomain: PersonSearchDomain): GraphySearchResult<PersonSearchDomain>
}