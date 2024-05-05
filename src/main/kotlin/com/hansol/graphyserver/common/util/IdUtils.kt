package com.hansol.graphyserver.common.util

import com.github.f4b6a3.tsid.Tsid
import com.github.f4b6a3.tsid.TsidCreator

object IdUtils {
    fun generateId(): Long = TsidCreator.getTsid().toLong()
    fun convertToString(id: Long): String = Tsid.from(id).toString()
}