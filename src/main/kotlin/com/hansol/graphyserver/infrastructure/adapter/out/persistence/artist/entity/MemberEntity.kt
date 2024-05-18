package com.hansol.graphyserver.infrastructure.adapter.out.persistence.artist.entity

import com.hansol.graphyserver.application.artist.domain.ArtistDomain
import com.hansol.graphyserver.application.artist.domain.MemberDomain
import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.entity.PersonEntity
import com.hansol.graphyserver.infrastructure.common.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "member")
class MemberEntity(

    @Id
    val id: Long,

    @Column(name = "stage_name", nullable = false)
    val stageName: String,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
    val person: PersonEntity,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artist_id")
    val artist: ArtistEntity,

    @Column(name = "start_datetime")
    val startDatetime: LocalDateTime?,

    @Column(name = "end_datetime")
    val endDatetime: LocalDateTime?,
) : BaseEntity() {

    fun toDomain(): MemberDomain {
        return MemberDomain(
            id = this.id,
            stageName = this.stageName,
            person = this.person.toDomain(),
            startDatetime = startDatetime,
            endDatetime = endDatetime,
        )
    }

    companion object {
        fun fromDomain(memberDomain: MemberDomain, artistDomain: ArtistDomain): MemberEntity {
            return MemberEntity(
                id = memberDomain.id,
                stageName = memberDomain.stageName,
                person = PersonEntity.fromDomain(memberDomain.person),
                artist = ArtistEntity.fromDomain(artistDomain),
                startDatetime = memberDomain.startDatetime,
                endDatetime = memberDomain.endDatetime
            )
        }

        fun fromArtistDomain(artistDomain: ArtistDomain): List<MemberEntity> {
            return artistDomain.members.map { fromDomain(it, artistDomain) }
        }
    }
}