package kr.mjc.lhs.spring.jdbc.midterm;


import kr.mjc.lhs.basics.jdbc.movie.Movie;
import kr.mjc.lhs.basics.jdbc.movie.MovieDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class ListMovies {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MovieDao movieDao = applicationContext.getBean(MovieDao.class);

        List<Movie> movieList = movieDao.listMovies(100, 1);
        log.info(movieList.toString());
    }
}
