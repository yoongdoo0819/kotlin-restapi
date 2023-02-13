package com.krust.spring

import org.junit.jupiter.api.Test
import java.sql.DriverManager

class MariaDBConnectionTest {
    @Test
    @Throws(Exception::class)
    fun testConnection() {
        Class.forName(DRIVER)
        try {
            DriverManager.getConnection(URL, USER, PASSWORD).use { connection -> println("connection = $connection") }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val DRIVER = "org.mariadb.jdbc.Driver"
        private const val URL = "jdbc:mariadb://localhost:3306/kbant"
        private const val USER = "root"
        private const val PASSWORD = "test1234"
    }
}