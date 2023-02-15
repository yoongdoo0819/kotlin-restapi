package com.krust.spring.dto

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "memberBoard")
class MemberBoardDTO {

    @Id
    var id: String? = ""
    @Id
    var idx: Long? = 0

    constructor(id: String, idx: Long) {
        this.id = id
        this.idx = idx
    }
}