package com.krust.spring.controller

import com.krust.spring.domain.Member
import com.krust.spring.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class MemberController {

    @Autowired
    private final var memberService : MemberService? = null

    @GetMapping("/")
    fun sample(): String {
        return "hi"
    }

    @GetMapping("/members/new")
    fun test(): Member {
        println("SUCCESS")
        val member = Member("id", "test1234")
        member.id = "ID"
        member.password = "PASSWORD"
        println(">>> $memberService")
        memberService?.join(member)
        return member
    }

    @PostMapping("/members/new") //@ResponseBody
    fun createMember(@RequestParam id: String, @RequestParam password: String): Member {
        println("SUCCESS Member Creation")
        println("id = $id")
        println("password = $password")
        val member = Member("id", "test1234")
        member.id = "ID"
        member.password = "PASSWORD"
        return member
    }
}