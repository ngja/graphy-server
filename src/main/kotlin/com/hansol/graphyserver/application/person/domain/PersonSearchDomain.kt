package com.hansol.graphyserver.application.person.domain

class PersonSearchDomain(
    val ids: Collection<Long>,
    val page: Int,
    val size: Int,
) {


}