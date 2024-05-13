package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.repository

import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<PersonEntity, Long> {
}