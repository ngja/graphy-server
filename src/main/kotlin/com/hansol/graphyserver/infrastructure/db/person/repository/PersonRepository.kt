package com.hansol.graphyserver.infrastructure.db.person.repository

import com.hansol.graphyserver.infrastructure.db.person.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<PersonEntity, Long> {
}