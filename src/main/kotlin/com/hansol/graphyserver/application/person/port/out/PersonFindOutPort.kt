package com.hansol.graphyserver.application.person.port.out

import com.hansol.graphyserver.application.person.domain.PersonDomain

interface PersonFindOutPort {
    fun findListByIds(ids: Collection<Long>): List<PersonDomain>
    fun findMapByIds(ids: Collection<Long>): Map<Long, PersonDomain>
}