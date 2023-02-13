package com.krust.spring.config

import com.krust.spring.domain.Member
import com.krust.spring.repository.JPARepository
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JpaConfig {

    @Autowired
    private final var em : EntityManager? = null

    constructor(em : EntityManager) {
        this.em = em
    }

    @Bean
    fun jpaRepository(em : EntityManager) : JPARepository {
        val jpaRepository = JPARepository(em)
        return jpaRepository
    }

}