package com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request

import com.hansol.graphyserver.application.person.domain.PersonSearchDomain

data class PersonSearchRequest(
    val ids: Collection<Long> = emptySet(),
    val page: Int = 0,
    val size: Int = 20,
) {
    fun toDomain(): PersonSearchDomain {
        return PersonSearchDomain(
            ids = ids,
            page = page,
            size = size,
        )
    }
}