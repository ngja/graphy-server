package com.hansol.graphyserver.common.exception

class GraphyException(
    val userMessage: String,
    val systemMessage: String,
) : Exception(userMessage) {

    constructor(userMessage: String): this(userMessage = userMessage, systemMessage = userMessage)
}