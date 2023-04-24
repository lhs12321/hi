package kr.mjc.lhs.spring.jdbc.midterm;

import kr.mjc.lhs.basics.jdbc.movie.Movie;
import kr.mjc.lhs.basics.jdbc.movie.MovieDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class AddMovie {
    public static void main(String[] args) {
        Movie movie = new Movie();
        System.out.print("title//director//");
        Scanner scanner = new Scanner(System.in).useDelimiter("//");
        String title = scanner.next();
        String director = scanner.next();
        scanner.close();

        movie.setTitle(title);
        movie.setDirector(director);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MovieDao movieDao = applicationContext.getBean(MovieDao.class);

        movieDao.addMovie(movie);
        log.debug("입력했습니다. {}", movie);
    }
}
