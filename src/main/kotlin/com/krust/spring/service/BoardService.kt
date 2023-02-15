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
}