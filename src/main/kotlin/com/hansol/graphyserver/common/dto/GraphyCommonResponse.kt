package com.hansol.graphyserver.common.dto

data class GraphyCommonResponse<T>(

    val data: T? = null,
    val message: String? = null,
    val page: Int? = null,
    val size: Int? = null,
    val more: Boolean? = null,
)