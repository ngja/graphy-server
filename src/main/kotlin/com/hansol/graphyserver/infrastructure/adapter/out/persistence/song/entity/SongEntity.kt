package com.hansol.graphyserver.infrastructure.adapter.out.persistence.song.entity

import com.hansol.graphyserver.application.song.domain.SongDomain
import com.hansol.graphyserver.infrastructure.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "song")
class SongEntity(

    @Id
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val releaseDateTime: LocalDateTime,

    @Column(nullable = false)
    val duration: Int,
) : BaseEntity() {

    fun toDomain(): SongDomain {
        return SongDomain(
            id = this.id,
            name = this.name,
            releaseDateTime = this.releaseDateTime,
            duration = this.duration,
        )
    }

    companion object {
        fun fromDomain(songDomain: SongDomain): SongEntity {
            return SongEntity(
                id = songDomain.id,
                name = songDomain.name,
                releaseDateTime = songDomain.releaseDateTime,
                duration = songDomain.duration,
            )
        }
    }
}