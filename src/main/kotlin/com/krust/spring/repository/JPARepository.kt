package com.krust.spring.repository

import com.krust.spring.domain.Member
import jakarta.persistence.Entity
import jakarta.persistence.EntityManager
import jakarta.persistence.Id
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException
import java.util.Optional

@Repository
@Transactional
class JPARepository {

    @Autowired
    private final var em: EntityManager? = null

    constructor() {

    }

    constructor(em: EntityManager) {
        this.em = em
    }

    fun save(member: Member): Member {
        em!!.persist(member)
        return member
    }

    fun findById(id: String) : Optional<Member> {
        var member: Member = Member(id, "")
        val findMember = em!!.find(member.javaClass, member.id)
        return Optional.ofNullable(findMember)
    }


}

