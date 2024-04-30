package com.hansol.graphyserver.common.dto

data class GraphyCommonResponse<T>(

    val result: T? = null,
    val message: String? = null
)