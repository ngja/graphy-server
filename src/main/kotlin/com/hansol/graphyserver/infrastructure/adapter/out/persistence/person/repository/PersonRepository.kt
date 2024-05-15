package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.repository

import com.hansol.graphyserver.infrastructure.adapter.out.persistence.person.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<PersonEntity, Long> {
}