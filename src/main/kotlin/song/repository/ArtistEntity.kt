package com.wafflestudio.seminar.spring2023.song.repository

import jakarta.persistence.*

@Entity(name = "artists")
class ArtistEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @Column(nullable = false, unique = true)
    val name: String,
    @OneToMany(mappedBy = "artist")
    val albums: List<AlbumEntity> = mutableListOf(),
    @OneToMany(mappedBy = "artist")
    val songArtists: List<SongArtistEntity> = mutableListOf()
)
