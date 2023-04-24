package kr.mjc.lhs.spring.jdbc.midterm2;

import kr.mjc.lhs.basics.jdbc.movie.Movie;
import kr.mjc.lhs.basics.jdbc.song.Song;
import kr.mjc.lhs.basics.jdbc.song.SongDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SongDaoImpl implements SongDao {
    private static final String LIST_SONGS = """
           select * from song order by songId desc limit ?, ?
            """;
    private static final String GET_SONG = """
            select * from song where songId=?
            """;
    private static final String ADD_SONG = """
            insert song(title, name) values(:title,:name)
            """;
    private static final String UPDATE_SONG = """
            update song set title=:title, name=:name where songId=:songId
            """;
    private static final String DELETE_SONG = """
            delete from song where songId=:?
            """;
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SongDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
    }
    private final RowMapper<Song> songRowMapper = new BeanPropertyRowMapper<>(Song.class);
    @Override
    public List<Song> listSongs(int count, int page) {
        int offset = (page - 1) * count;
        return jdbcTemplate.query(LIST_SONGS, songRowMapper, offset, count);
    }

    @Override
    public void addSong(Song song) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource params = new BeanPropertySqlParameterSource(song);
        namedParameterJdbcTemplate.update(ADD_SONG, params, keyHolder);
        song.setSongId(keyHolder.getKey().intValue());
    }

    @Override
    public Song getSong(int songId) {
        return jdbcTemplate.queryForObject(GET_SONG, songRowMapper, songId);
    }

    @Override
    public int updateSong(Song song) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(song);
        return namedParameterJdbcTemplate.update(UPDATE_SONG, params);
    }

    @Override
    public int deleteSong(int songId) {
        return jdbcTemplate.update(DELETE_SONG, songId);
    }
}
