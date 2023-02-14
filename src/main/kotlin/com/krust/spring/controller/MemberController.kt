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
    private final var memberService : MemberService ? = null
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
    fun loginMember(@RequestParam id: String, @RequestParam password: String, httpServletResponse: HttpServletResponse): Boolean {
        log.info("loginMember")

        val findMember = memberService!!.findMember(id)
        if (findMember != null &&
                id.equals(findMember?.id) &&
                password.equals(findMember?.password)) {

            return true
        }

        httpServletResponse.status = HttpServletResponse.SC_BAD_REQUEST
        return false
    }

    @PostMapping("/member/new")
    fun createMember(@RequestParam id: String, @RequestParam password: String, httpServletResponse: HttpServletResponse): Member? {
        log.info("createMember")
        log.info("id = {}", id)
        log.info("password = {}", password)

        val findMember = memberService!!.findMember(id)
        if (findMember != null) {
            httpServletResponse.status = HttpServletResponse.SC_BAD_REQUEST
            return null
        }

        log.info("create")
        val member = Member(id, password)
        memberService!!.join(member)
        return member
    }
}