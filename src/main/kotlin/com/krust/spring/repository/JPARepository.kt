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
        var member = Member(id, "")
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

    fun getMyBoardList(id: String): List<Board> {
        val jpql = "select b from Board b INNER JOIN memberBoard mb on b.idx=mb.idx WHERE mb.id = :id";
        return em!!.createQuery(jpql, Board().javaClass)
                .setParameter("id", id)
                .resultList
    }

    fun getAllBoardList(): List<Board> {
        val jpql = "select b from Board b";
        val query = em!!.createQuery(jpql, Board().javaClass)
        return query.resultList;
    }

    fun update(updateBoard: Board): Board {

        val findBoard = em!!.find(updateBoard.javaClass, updateBoard.idx)
        findBoard.title = updateBoard.title
        findBoard.content = updateBoard.content
        return findBoard
    }

    fun delete(memberBoardDTO: MemberBoardDTO): Boolean {

        val memberBoardJpql = "delete from memberBoard mb where mb.id = :id and mb.idx = :idx";
        em!!.createQuery(memberBoardJpql)
                .setParameter("id", memberBoardDTO.id)
                .setParameter("idx", memberBoardDTO.idx)
                .executeUpdate()

        val boardJpql = "DELETE from Board b WHERE b.idx = :idx";
        val boardQuery = em!!.createQuery(boardJpql)//, Board().javaClass)
        boardQuery.setParameter("idx", memberBoardDTO.idx)
        val rowsDelete = boardQuery.executeUpdate()

        return true
    }
}

