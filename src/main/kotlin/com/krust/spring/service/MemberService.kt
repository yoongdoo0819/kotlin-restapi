package com.krust.spring.service

import com.krust.spring.domain.Member
import com.krust.spring.repository.JPARepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MemberService {

    @Autowired
    private final var jpaRepository : JPARepository? = null

    fun join(member: Member) {
        //println("id : " + member.id)
        //println("password : " + member.password)
        println("jpaRepository >>> $jpaRepository")
        jpaRepository!!.save(member)
    }
}