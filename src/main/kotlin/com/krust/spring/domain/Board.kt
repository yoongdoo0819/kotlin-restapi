package com.krust.spring.domain

import jakarta.persistence.*

@Entity
class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = 0

    @Column
    var title: String? = null
    var content: String? = null

    init {
    }

    constructor(){

    }

    constructor(title: String, content: String) {
        this.title = title
        this.content = content
    }
}