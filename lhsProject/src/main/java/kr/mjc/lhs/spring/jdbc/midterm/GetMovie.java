package kr.mjc.lhs.spring.jdbc.midterm;

import kr.mjc.lhs.basics.jdbc.movie.Movie;
import kr.mjc.lhs.basics.jdbc.movie.MovieDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Scanner;

@Slf4j
public class GetMovie {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("movieId : ");
    int movieId = scanner.nextInt();
    scanner.close();

    ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(AppConfig.class);
    MovieDao movieDao = applicationContext.getBean(MovieDao.class);

    try {
        Movie movie = movieDao.getMovie(movieId);
        log.info(movie.toString());
    } catch (DataAccessException e) {
        log.error("해당 게시글 없음");
        }
    }
}
