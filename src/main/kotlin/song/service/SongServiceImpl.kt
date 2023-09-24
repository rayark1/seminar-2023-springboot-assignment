package com.wafflestudio.seminar.spring2023.song.service

import com.wafflestudio.seminar.spring2023.song.repository.AlbumRepository
import com.wafflestudio.seminar.spring2023.song.repository.SongArtistRepository
import com.wafflestudio.seminar.spring2023.song.repository.SongEntity
import com.wafflestudio.seminar.spring2023.song.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongServiceImpl(private val songRepository: SongRepository
) : SongService {

    override fun search(keyword: String): List<Song> {
        val songEntities = songRepository.findByTitleContainingWithJoinFetch(keyword)
        return songEntities.map { entity ->
            Song(
                id = entity.id,
                title = entity.title,
                artists = entity.songArtists.map { songArtist ->
                    Artist(
                        id = songArtist.artist.id,
                        name = songArtist.artist.name
                    )
                },
                album = entity.album.title,
                image = entity.album.image,
                duration = entity.duration.toString()
            )
        }
    }

    override fun searchAlbum(keyword: String): List<Album> {
        TODO()
    }
}