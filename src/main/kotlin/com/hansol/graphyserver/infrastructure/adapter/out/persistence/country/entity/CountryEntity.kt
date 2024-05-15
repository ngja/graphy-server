package com.hansol.graphyserver.infrastructure.adapter.out.persistence.country.entity

import com.hansol.graphyserver.application.country.domain.CountryDomain
import com.hansol.graphyserver.infrastructure.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "country")
class CountryEntity(
    @Id
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(name = "iso_alpha_2", nullable = false)
    val iso2: String,

    @Column(name = "iso_alpha_3", nullable = false)
    val iso3: String,
) : BaseEntity() {


    fun toDomain(): CountryDomain {
        return CountryDomain(
            id = this.id,
            name = this.name,
            iso2 = this.iso2,
            iso3 = this.iso3,
        )
    }

    companion object {
        fun fromDomain(domain: CountryDomain): CountryEntity {
            return CountryEntity(
                id = domain.id,
                name = domain.name,
                iso2 = domain.iso2,
                iso3 = domain.iso3,
            )
        }
    }
}