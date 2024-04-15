package com.hansol.graphyserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraphyServerApplication

fun main(args: Array<String>) {
    runApplication<GraphyServerApplication>(*args)
}
