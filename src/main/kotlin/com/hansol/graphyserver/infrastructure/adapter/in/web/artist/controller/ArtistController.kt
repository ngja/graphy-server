package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.controller

import com.hansol.graphyserver.application.artist.port.`in`.ArtistCreateInPort
import com.hansol.graphyserver.application.artist.port.`in`.ArtistSearchInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request.ArtistCreateRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request.ArtistCreateResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request.ArtistSearchRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.response.ArtistSearchResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ArtistController(
    private val artistCreateInPort: ArtistCreateInPort,
    private val artistSearchInPort: ArtistSearchInPort,
) {
    @PostMapping("/artists")
    fun createArtists(@RequestBody artistCreateRequests: List<ArtistCreateRequest>): GraphyCommonResponse<List<ArtistCreateResponse>> {
        val results = artistCreateInPort.createArtists(artistCreateRequests.map { it.toCreateDomain() })
        return GraphyCommonResponse(
            data = results.map { ArtistCreateResponse.fromDomain(it) },
        )
    }

    @GetMapping("/artists")
    fun search(@RequestBody artistSearchRequest: ArtistSearchRequest): GraphyCommonResponse<List<ArtistSearchResponse>> {
        val results = artistSearchInPort.search(artistSearchRequest.toCondition())
        return GraphyCommonResponse(
            data = results.map { ArtistSearchResponse.fromDomain(it) },
            nextCursor = results.lastOrNull()?.id,
            size = results.size,
            more = results.isNotEmpty(),
        )
    }
}