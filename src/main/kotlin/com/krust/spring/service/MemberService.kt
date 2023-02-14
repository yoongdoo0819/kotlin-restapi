package com.krust.spring.service

import com.krust.spring.domain.Member
import com.krust.spring.repository.JPARepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MemberService {

    @Autowired
    private final var jpaRepository : JPARepository? = null
    private val log = LoggerFactory.getLogger(javaClass)

    fun join(member: Member) {

        log.info("join")
        jpaRepository!!.save(member)
    }

    fun findMember(id: String): Optional<Member> {

        log.info("findMember")
        return jpaRepository!!.findById(id)
    }
}