package kr.mjc.lhs.spring.jdbc.midterm;

import kr.mjc.lhs.basics.jdbc.SingleKeyHolder;
import kr.mjc.lhs.basics.jdbc.article.Article;
import kr.mjc.lhs.basics.jdbc.movie.Movie;
import kr.mjc.lhs.basics.jdbc.movie.MovieDao;
import org.springframework.context.annotation.Configuration;
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
public class MovieDaoImpl implements MovieDao {
    private static final String LIST_MOVIES = """
           select movieId, title, director from movie order by movieId desc limit ?, ?
            """;
    private static final String GET_MOVIE = """
            select * from movie where movieId=?
            """;
    private static final String ADD_MOVIE = """
            insert movie(title, director) values(:title,:director)
            """;
    private static final String UPDATE_MOVIE = """
            update movie set title=:title, director=:director where movieId=:movieId
            """;
    private static final String DELETE_MOVIE = """
            delete from movie where movieId=?
            """;

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MovieDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
    }

    private final RowMapper<Movie> movieRowMapper = new BeanPropertyRowMapper<>(Movie.class);

    @Override
    public List<Movie> listMovies(int count, int page) {
        int offset = (page - 1) * count;
        return jdbcTemplate.query(LIST_MOVIES, movieRowMapper, offset, count);
    }

    @Override
    public Movie getMovie(int movieId) {

        return jdbcTemplate.queryForObject(GET_MOVIE, movieRowMapper, movieId);
    }

    @Override
    public void addMovie(Movie movie) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource params = new BeanPropertySqlParameterSource(movie);
        namedParameterJdbcTemplate.update(ADD_MOVIE, params, keyHolder);
        movie.setMovieId(keyHolder.getKey().intValue());

    }
    @Override
    public int updateMovie(Movie movie) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(movie);
        return namedParameterJdbcTemplate.update(UPDATE_MOVIE, params);
    }

    @Override
    public int deleteMovie(int movieId) {
        return jdbcTemplate.update(DELETE_MOVIE, movieId);
    }

}
