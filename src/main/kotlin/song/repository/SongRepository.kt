package com.wafflestudio.seminar.spring2023.song.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SongRepository : JpaRepository<SongEntity, Long> {
    @Query("SELECT s FROM songs s LEFT JOIN FETCH s.songArtists  WHERE s.title LIKE %:keyword% ORDER BY LENGTH(s.title) ")
    fun findByTitleContainingWithJoinFetch(keyword: String): List<SongEntity>
}