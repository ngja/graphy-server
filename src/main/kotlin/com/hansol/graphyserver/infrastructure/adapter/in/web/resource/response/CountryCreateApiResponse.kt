package com.hansol.graphyserver.infrastructure.adapter.`in`.web.resource.response

import com.hansol.graphyserver.application.country.domain.CountryDomain

data class CountryCreateApiResponse(
    val id: Long,
) {
    companion object {
        fun fromDomain(countryDomain: CountryDomain): CountryCreateApiResponse {
            return CountryCreateApiResponse(
                id = countryDomain.id,
            )
        }
    }
}
