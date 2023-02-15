package com.krust.spring.service

import com.krust.spring.domain.Board
import com.krust.spring.domain.Member
import com.krust.spring.repository.JPARepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@Service
class BoardService {

    @Autowired
    private final var jpaRepository : JPARepository? = null
    private val log = LoggerFactory.getLogger(javaClass)

    fun store(board: Board) {

        log.info("store")
        jpaRepository!!.store(board)
    }

    fun findBoard(idx: Long): Board? {

        log.info("findBoard")
        return jpaRepository!!.findBoardByIdx(idx)
    }
}