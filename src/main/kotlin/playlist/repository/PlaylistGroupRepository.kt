package com.wafflestudio.seminar.spring2023.playlist.repository

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface PlaylistGroupRepository : JpaRepository<PlaylistGroupEntity, Long> {
    @EntityGraph(attributePaths = ["playlists"])
    fun findByOpenTrue(): List<PlaylistGroupEntity>
}