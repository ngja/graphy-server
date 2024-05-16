package com.hansol.graphyserver.infrastructure.adapter.`in`.web.country.dto.response

import com.hansol.graphyserver.application.country.domain.CountryDomain

data class CountryFindResponse(
    val id: Long,
    val name: String,
    val iso3: String,
) {
    companion object {
        fun fromDomain(countryDomain: CountryDomain): CountryFindResponse {
            return CountryFindResponse(
                id = countryDomain.id,
                name = countryDomain.name,
                iso3 = countryDomain.iso3,
            )
        }
    }
}
