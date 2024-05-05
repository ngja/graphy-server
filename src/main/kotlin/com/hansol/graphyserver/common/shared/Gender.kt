package com.hansol.graphyserver.common.shared

import com.hansol.graphyserver.common.exception.GraphyException

enum class Gender(
    val label: String,
) {
    MALE("남성"),
    FEMALE("여성"),
    ;

    companion object {
        fun from(value: String): Gender {
            return entries.firstOrNull { it.name == value }
                ?: throw GraphyException("잘못된 성별이 입력되었습니다.", "잘못된 성별이 입력되었습니다. value=$value")
        }
    }
}