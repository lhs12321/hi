package kr.mjc.lhs.basics.jdbc.song;

import kr.mjc.lhs.basics.jdbc.User;

import java.util.List;

public interface SongDao {
    List<Song> listSongs(int count, int page);

    Song getSong(int songId);

    int updateSong(Song song);

    int deleteSong(int songId);

    void addSong(Song song);
}