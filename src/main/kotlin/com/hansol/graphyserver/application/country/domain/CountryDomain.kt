package com.hansol.graphyserver.application.country.domain

import com.hansol.graphyserver.common.util.IdUtils

class CountryDomain(
    val id: Long = IdUtils.generateId(),
    val name: String,
    val iso2: String,
    val iso3: String,
) {
}