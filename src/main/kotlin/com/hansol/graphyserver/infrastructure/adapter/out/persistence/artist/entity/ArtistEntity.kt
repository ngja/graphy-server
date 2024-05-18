package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity

import com.hansol.graphyserver.application.artist.domain.ArtistDomain
import com.hansol.graphyserver.infrastructure.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "artist")
class ArtistEntity(

    @Id
    val id: Long,

    @Column(nullable = false)
    val name: String,

    ) : BaseEntity() {

    fun toDomain(memberEntities: List<MemberEntity>, artistNationalityEntities: List<ArtistNationalityEntity>): ArtistDomain {
        return ArtistDomain(
            id = this.id,
            name = this.name,
            members = memberEntities.map { it.toDomain() },
            artistNationalities = artistNationalityEntities.map { it.toDomain() },
        )
    }

    companion object {
        fun fromDomain(artistDomain: ArtistDomain): ArtistEntity {
            return ArtistEntity(
                id = artistDomain.id,
                name = artistDomain.name,
            )
        }
    }
}