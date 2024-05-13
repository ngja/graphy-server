package com.hansol.graphyserver.application.person.dto

data class PersonSearchCondition(
    val ids: Collection<Long>?,
    val cursor: Long? = null,
    val size: Long = 20L,
)
