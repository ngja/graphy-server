package com.hansol.graphyserver.infrastructure.db.person.entity

import com.hansol.graphyserver.common.enums.Gender
import com.hansol.graphyserver.components.person.dto.internal.request.PersonCreateDbRequest
import com.hansol.graphyserver.infrastructure.db.common.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "person")
@Entity
class PersonEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

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

    constructor(personCreateDbRequest: PersonCreateDbRequest) : this(
        id = null,
        surname = personCreateDbRequest.surname,
        givenName = personCreateDbRequest.givenName,
        gender = personCreateDbRequest.gender,
        birthday = personCreateDbRequest.birthday
    )
}