package com.krust.spring.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Member {

    @Id @Column(name = "id")
    var id: String? = null
    @Column(name = "password")
    var password: String? = null

    init {
    }

    constructor(id: String, password: String) {
        this.id = id;
        this.password = password;
    }
}