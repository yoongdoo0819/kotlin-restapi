package com.krust.spring.repository

import com.krust.spring.domain.Board
import com.krust.spring.domain.Member
import com.krust.spring.dto.MemberBoardDTO
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class JPARepository {

    @Autowired
    private final var em: EntityManager? = null

    constructor() {

    }

    constructor(em: EntityManager) {
        this.em = em
    }

    fun save(member: Member): Member {
        em!!.persist(member)
        return member
    }

    fun findById(id: String): Member? {
        var member: Member = Member(id, "")
        return em!!.find(member.javaClass, member.id)
    }

    fun store(board: Board): Board {
        em!!.persist(board)
        return board
    }

    fun findBoardByIdx(idx: Long): Board? {
        var board = Board()
        board.idx = idx
        return em!!.find(board.javaClass, board.idx)
    }

    fun storeMemberBoard(memberBoardDTO: MemberBoardDTO): MemberBoardDTO {
        em!!.persist(memberBoardDTO)
        return memberBoardDTO
    }
}

