package com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request

import com.hansol.graphyserver.application.person.dto.PersonSearchCondition

data class PersonSearchRequest(
    val ids: Collection<Long>? = null,
    val cursor: Long? = null,
    val size: Int = 20,
) {
    fun toCondition(): PersonSearchCondition {
        return PersonSearchCondition(
            ids = ids,
            cursor = cursor,
            size = size.toLong(),
        )
    }
}