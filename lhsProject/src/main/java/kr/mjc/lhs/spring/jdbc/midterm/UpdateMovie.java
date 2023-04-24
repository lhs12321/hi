package kr.mjc.lhs.spring.jdbc.midterm;

import kr.mjc.lhs.basics.jdbc.movie.Movie;
import kr.mjc.lhs.basics.jdbc.movie.MovieDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class UpdateMovie {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MovieDao movieDao = applicationContext.getBean(MovieDao.class);

        Movie movie = new Movie();
        System.out.print("title//director//");
        Scanner scanner = new Scanner(System.in).useDelimiter("//");
        int movieId = scanner.nextInt();
        String title = scanner.next();
        String director = scanner.next();
        scanner.close();

        movie.setMovieId(movieId);
        movie.setTitle(title);
        movie.setDirector(director);

        int updatedRows = movieDao.updateMovie(movie);
        if (updatedRows >= 1)
            log.info("수정 완료");
        else
            log.info("수정 실패");
        
    }
}