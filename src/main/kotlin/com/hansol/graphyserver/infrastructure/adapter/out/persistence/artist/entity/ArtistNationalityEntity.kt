package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity

import com.hansol.graphyserver.application.artist.domain.ArtistDomain
import com.hansol.graphyserver.application.artist.domain.ArtistNationalityDomain
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.country.entity.CountryEntity
import com.hansol.graphyserver.infrastructure.common.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "artist_nationality")
class ArtistNationalityEntity(

    @Id
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artist_id")
    val artist: ArtistEntity,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id")
    val country: CountryEntity,

    /**
     * 데뷔 날짜
     */
    @Column(name = "start_datetime")
    val startDatetime: LocalDateTime?,

    /**
     * 해체 날짜
     */
    @Column(name = "end_datetime")
    val endDatetime: LocalDateTime?,
) : BaseEntity() {

    fun toDomain(): ArtistNationalityDomain {
        return ArtistNationalityDomain(
            id = this.id,
            country = this.country.toDomain(),
            startDatetime = this.startDatetime,
            endDatetime = this.endDatetime,
        )
    }

    companion object {
        fun fromDomain(artistNationalityDomain: ArtistNationalityDomain, artistDomain: ArtistDomain): ArtistNationalityEntity {
            return ArtistNationalityEntity(
                id = artistNationalityDomain.id,
                artist = ArtistEntity.fromDomain(artistDomain),
                country = CountryEntity.fromDomain(artistNationalityDomain.country),
                startDatetime = artistNationalityDomain.startDatetime,
                endDatetime = artistNationalityDomain.endDatetime,
            )
        }

        fun fromArtistDomain(artistDomain: ArtistDomain): List<ArtistNationalityEntity> {
            return artistDomain.artistNationalities.map { fromDomain(it, artistDomain) }
        }
    }
}