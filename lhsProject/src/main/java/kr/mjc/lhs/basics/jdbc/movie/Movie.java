package kr.mjc.lhs.basics.jdbc.movie;

import lombok.Data;

@Data
public class Movie {
    private int movieId;
    private String title;
    private String director;

    @Override
    public String toString() {
        return String.format("\nMovie{movieId=%d, title=%s, director=%s}", movieId,
                title, director);
    }
}