package com.krust.spring.controller

import com.krust.spring.domain.Board
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class BoardController {

    private val log = LoggerFactory.getLogger(javaClass)

//    @PostMapping("/board/store")
//    fun storeBoard(@RequestParam title: String, @RequestParam content: String, httpServletResponse: HttpServletResponse): Boolean {
//        log.info("storeBoard")
//        log.info("title {}", title)
//        log.info("content {}", content)
//
//        return true
//    }

    @PostMapping("/board/store")
    fun storeBoard(@ModelAttribute board: Board, httpServletResponse: HttpServletResponse): Boolean {
        log.info("storeBoard")
        log.info("title {}", board.title)
        log.info("content {}", board.content)

        return true
    }
}