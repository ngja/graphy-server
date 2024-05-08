package com.hansol.graphyserver.common.dto

data class GraphySearchResult<T>(
    val results: List<T>,
    val page: Int,
    val size: Int,
    val more: Boolean = false,
)
