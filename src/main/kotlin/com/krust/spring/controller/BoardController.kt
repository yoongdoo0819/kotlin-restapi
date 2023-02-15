package com.krust.spring.controller

import com.krust.spring.domain.Board
import com.krust.spring.dto.MemberBoardDTO
import com.krust.spring.service.BoardService
import com.krust.spring.service.MemberService
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class BoardController {

    @Autowired
    private final var boardService : BoardService? = null
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
    fun storeBoard(@RequestParam id: String, @ModelAttribute board: Board, httpServletResponse: HttpServletResponse): Boolean {
        log.info("storeBoard")
        log.info("id {}", id)
        log.info("title {}", board.title)
        log.info("content {}", board.content)

        val savedBoard = boardService!!.create(board)
        val memberBoardDTO = MemberBoardDTO(id, savedBoard.idx!!)

        log.info("idx {}", savedBoard.idx)
        boardService!!.createMemberBoard(memberBoardDTO)
        return true
    }
}