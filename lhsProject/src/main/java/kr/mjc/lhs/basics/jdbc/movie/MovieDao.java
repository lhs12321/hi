package kr.mjc.lhs.basics.jdbc.movie;

import java.util.List;

public interface MovieDao {
    List<Movie> listMovies(int count, int page);

    Movie getMovie(int movieId);

    int updateMovie(Movie movie);

    int deleteMovie(int movieId);

    void addMovie(Movie movie);
}
