package com.wafflestudio.seminar.spring2023.song.repository

import jakarta.persistence.*

@Entity(name = "albums")
class AlbumEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @Column(nullable = false)
    val title: String,
    val image: String,
    @ManyToOne // default FetchType.EAGER
    @JoinColumn(name = "artist_id", nullable = false)
    val artist: ArtistEntity,
    @OneToMany(mappedBy = "album")
    val songs: List<SongEntity> = mutableListOf()

    // FetchType.LAZY로 설정하면 songs를 사용할 때 쿼리가 실행됨
    // @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
    // val songs: List<SongEntity> = mutableListOf()
)
