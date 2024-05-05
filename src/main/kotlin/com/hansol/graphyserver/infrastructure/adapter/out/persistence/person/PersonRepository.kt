package com.hansol.graphyserver.infrastructure.adapter.out.persistence.person

import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<PersonEntity, Long> {
}