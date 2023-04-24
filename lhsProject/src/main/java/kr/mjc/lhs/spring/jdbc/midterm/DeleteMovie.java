package kr.mjc.lhs.spring.jdbc.midterm;

import kr.mjc.lhs.basics.jdbc.article.ArticleDao;
import kr.mjc.lhs.basics.jdbc.movie.MovieDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class DeleteMovie {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("movieId : ");
        int movieId = scanner.nextInt();
        scanner.close();

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MovieDao movieDao = applicationContext.getBean(MovieDao.class);

        int updatedRows = movieDao.deleteMovie(movieId);
        if (updatedRows >= 1)
            log.info("삭제 완료");
        else
            log.info("삭제 실패");
        }
    }
