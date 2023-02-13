package com.krust.spring

import com.krust.spring.config.JpaConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import


@SpringBootApplication
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
