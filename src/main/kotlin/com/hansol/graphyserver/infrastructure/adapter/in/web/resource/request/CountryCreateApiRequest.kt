package com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.request

import com.hansol.graphyserver.application.country.domain.CountryDomain

data class CountryCreateApiRequest(
    val name: String,
    val iso2: String,
    val iso3: String,
) {
    fun toDomain(): CountryDomain {
        return CountryDomain(
            name = name,
            iso2 = iso2,
            iso3 = iso3,
        )
    }
}