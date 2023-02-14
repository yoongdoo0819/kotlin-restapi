package com.krust.spring.service

import com.krust.spring.domain.Member
import com.krust.spring.repository.JPARepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MemberService {

    @Autowired
    private final var jpaRepository : JPARepository? = null

    fun join(member: Member) {
        //println("id : " + member.id)
        //println("password : " + member.password)
        println("join >>> $jpaRepository")
        jpaRepository!!.save(member)
    }

    fun findMember(id: String): Optional<Member> {

        println("findMember >>> $jpaRepository")
        return jpaRepository!!.findById(id)
    }
}