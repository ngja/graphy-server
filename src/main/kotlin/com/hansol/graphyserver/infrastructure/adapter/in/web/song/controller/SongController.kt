package com.hansol.graphyserver.infrastructure.adapter.`in`.web.song.controller

import com.hansol.graphyserver.application.song.port.`in`.SongCreateInPort
import com.hansol.graphyserver.application.song.port.`in`.SongSearchInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.song.dto.request.SongCreateRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.song.dto.request.SongSearchRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.song.dto.response.SongCreateResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.song.dto.response.SongSearchResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class SongController(
    private val songCreateInPort: SongCreateInPort,
    private val songSearchInPort: SongSearchInPort,
) {

    @PostMapping("/songs")
    fun createSongs(@RequestBody songs: List<SongCreateRequest>): GraphyCommonResponse<List<SongCreateResponse>> {
        val songDomains = songCreateInPort.createSongs(songs.map { it.toDomain()})
        return GraphyCommonResponse(
            data = songDomains.map { SongCreateResponse.fromDomain(it) },
        )
    }

    @GetMapping("/songs")
    fun search(@RequestBody songSearchRequest: SongSearchRequest): GraphyCommonResponse<List<SongSearchResponse>> {
        val results = songSearchInPort.search(songSearchRequest.toCondition())
        return GraphyCommonResponse(
            data = results.map { SongSearchResponse.fromDomain(it) },
            nextCursor = results.lastOrNull()?.id,
            size = results.size,
            more = results.isNotEmpty(),
        )
    }
}