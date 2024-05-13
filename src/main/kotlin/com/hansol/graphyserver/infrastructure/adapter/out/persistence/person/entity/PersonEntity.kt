package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.entity

import com.hansol.graphyserver.application.person.domain.PersonDomain
import com.hansol.graphyserver.common.shared.Gender
import com.hansol.graphyserver.infrastructure.common.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "person")
@Entity
class PersonEntity(

    @Id
    val id: Long,

    @Column(nullable = false)
    val surname: String,

    @Column(nullable = false)
    val givenName: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val gender: Gender,

    @Column(nullable = false)
    val birthday: LocalDateTime?,

    ) : BaseEntity() {

    fun toDomain(): PersonDomain {
        return PersonDomain(
            id = this.id,
            surname = this.surname,
            givenName = this.givenName,
            gender = this.gender,
            birthday = this.birthday,
        )
    }

    companion object {
        fun fromDomain(personDomain: PersonDomain): PersonEntity {
            return PersonEntity(
                id = personDomain.id,
                surname = personDomain.surname,
                givenName = personDomain.givenName,
                gender = personDomain.gender,
                birthday = personDomain.birthday,
            )
        }
    }
}