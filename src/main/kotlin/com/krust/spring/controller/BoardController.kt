package com.krust.spring.controller

import com.krust.spring.domain.Board
import com.krust.spring.dto.MemberBoardDTO
import com.krust.spring.service.BoardService
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/board/myList/{id}")
    fun getMyBoardList(@PathVariable id: String): List<Board>? {
        log.info("getMyBoardList {}", id)

        val boards = boardService!!.findMyBoardList(id)

        if (boards != null) {
            for (i in boards) {
                log.info("{} boards {} {}", i.idx, i.title, i.content)
            }
        }

        return boards
    }

    @GetMapping("/board/allList")
    fun getAllBoardList(): List<Board>? {
        log.info("getAllBoardList")

        val boards = boardService!!.findAllBoardList()

        if (boards != null) {
            for (i in boards) {
                log.info("{} boards {} {}", i.idx, i.title, i.content)
            }
        }

        return boards
    }

    @PostMapping("/board/update")
    fun updateBoard(@RequestParam id: String, @ModelAttribute board: Board, httpServletResponse: HttpServletResponse): Boolean {
        log.info("storeBoard")
        log.info("id {}", id)
        log.info("idx {}", board.idx)
        log.info("title {}", board.title)
        log.info("content {}", board.content)

        val updatedBoard = boardService!!.update(board)
        return true
    }
}