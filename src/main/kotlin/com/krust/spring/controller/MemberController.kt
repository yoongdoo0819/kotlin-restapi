package com.krust.spring.controller

import com.krust.spring.domain.Member
import com.krust.spring.service.MemberService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class MemberController {

    @Autowired
    private final var memberService : MemberService? = null
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/")
    fun sample(): String {
        return "hi"
    }

    @GetMapping("/members/new/{id}")
    fun test(@PathVariable id: String): Member {
        log.info("test : $id")

        val member = memberService!!.findMember(id)!!.get()
        val id = member.id
        val pw = member.password
        log.info("id = {}", id)
        log.info("pw = {}", pw)

        return member
    }

    @PostMapping("/member/login/")
    fun loginMember(@RequestParam id: String, @RequestParam password: String): Member {
        log.info("loginMember : $id")

        val member = memberService!!.findMember(id)!!.get()
        val id = member.id
        val pw = member.password
        log.info("id = {}", id)
        log.info("pw = {}", pw)

        return member
    }

    @PostMapping("/members/new")
    fun createMember(@RequestParam id: String, @RequestParam password: String): Member {
        log.info("createMember")
        log.info("id = {}", id)
        log.info("password = {}", password)
        val member = Member(id, password)
        memberService?.join(member)
        return member
    }
}