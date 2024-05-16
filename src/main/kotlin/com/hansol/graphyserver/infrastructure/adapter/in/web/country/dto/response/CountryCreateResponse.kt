package com.hansol.graphyserver.infrastructure.adapter.`in`.web.country.dto.response

import com.hansol.graphyserver.application.country.domain.CountryDomain

data class CountryCreateResponse(
    val id: Long,
) {
    companion object {
        fun fromDomain(countryDomain: CountryDomain): CountryCreateResponse {
            return CountryCreateResponse(
                id = countryDomain.id,
            )
        }
    }
}
