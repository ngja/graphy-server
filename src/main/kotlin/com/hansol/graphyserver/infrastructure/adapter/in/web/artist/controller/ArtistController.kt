package com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.controller

import com.hansol.graphyserver.application.artist.port.`in`.ArtistCreateInPort
import com.hansol.graphyserver.common.dto.GraphyCommonResponse
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request.ArtistCreateRequest
import com.hansol.graphyserver.infrastructure.adapter.`in`.web.artist.dto.request.ArtistCreateResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ArtistController(
    private val artistCreateInPort: ArtistCreateInPort,
) {
    @PostMapping("/artists")
    fun createArtists(@RequestBody artistCreateRequests: List<ArtistCreateRequest>): GraphyCommonResponse<List<ArtistCreateResponse>> {
        val results = artistCreateInPort.createArtists(artistCreateRequests.map { it.toCreateDomain() })
        return GraphyCommonResponse(
            data = results.map { ArtistCreateResponse.fromDomain(it) },
        )
    }
}