package com.krust.spring.service

import com.krust.spring.domain.Board
import com.krust.spring.dto.MemberBoardDTO
import com.krust.spring.repository.JPARepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BoardService {

    @Autowired
    private final var jpaRepository : JPARepository? = null
    private val log = LoggerFactory.getLogger(javaClass)

    fun create(board: Board): Board {

        log.info("create")
        return jpaRepository!!.store(board)
    }

    fun findBoard(idx: Long): Board? {

        log.info("findBoard")
        return jpaRepository!!.findBoardByIdx(idx)
    }

    fun createMemberBoard(memberBoardDTO: MemberBoardDTO) {

        log.info("createMemberBoard")
        jpaRepository!!.storeMemberBoard(memberBoardDTO)
    }

    fun findMyBoardList(id: String): List<Board>? {

        log.info("findMyBoardList")
        return jpaRepository!!.getMyBoardList(id)
    }

    fun findAllBoardList(): List<Board>? {

        log.info("findAllBoardList")
        return jpaRepository!!.getAllBoardList()
    }

    fun update(updateBoard: Board): Board {

        log.info("update")
        return jpaRepository!!.update(updateBoard)
    }

    fun delete(memberBoardDTO: MemberBoardDTO): Boolean {

        log.info("delete")
        return jpaRepository!!.delete(memberBoardDTO)
    }
}