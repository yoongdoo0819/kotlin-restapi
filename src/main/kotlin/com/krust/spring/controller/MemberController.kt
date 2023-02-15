package com.krust.spring.controller

import com.krust.spring.domain.Member
import com.krust.spring.service.MemberService
import io.netty.handler.codec.http.HttpResponse
import io.netty.handler.codec.http.HttpResponseStatus
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import kotlin.jvm.optionals.getOrNull

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
    fun test(@PathVariable id: String): Member? {
        log.info("test")

        val member = memberService!!.findMember(id)
        val id = member!!.id
        val pw = member!!.password
        log.info("id = {}", id)
        log.info("pw = {}", pw)

        return member
    }

    @PostMapping("/member/login")
    fun loginMember(@ModelAttribute member: Member, httpServletResponse: HttpServletResponse): Boolean {
        log.info("loginMember")

        val findMember = memberService!!.findMember(member.id)
        if (findMember != null &&
                member.id.equals(findMember?.id) &&
                member.password.equals(findMember?.password)) {

            return true
        }

        httpServletResponse.status = HttpServletResponse.SC_BAD_REQUEST
        return false
    }

    @PostMapping("/member/new")
    fun createMember(@ModelAttribute member: Member, httpServletResponse: HttpServletResponse): Member? {
        log.info("createMember")
        log.info("id = {}", member.id)
        log.info("password = {}", member.password)

        val foundMember = memberService!!.findMember(member.id)
        if (foundMember != null) {
            httpServletResponse.status = HttpServletResponse.SC_BAD_REQUEST
            return null
        }

        log.info("create")
        memberService!!.join(member)
        return member
    }
}