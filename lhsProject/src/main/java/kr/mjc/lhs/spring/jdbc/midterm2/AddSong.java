package kr.mjc.lhs.spring.jdbc.midterm2;

import kr.mjc.lhs.basics.jdbc.movie.MovieDao;
import kr.mjc.lhs.basics.jdbc.song.Song;
import kr.mjc.lhs.basics.jdbc.song.SongDao;
import kr.mjc.lhs.spring.jdbc.midterm2.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class AddSong {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SongDao movieDao = applicationContext.getBean(SongDao.class);

        Song song = new Song();
        Scanner scanner = new Scanner(System.in).useDelimiter("//");
        System.out.print("title// : ");
        song.setTitle(scanner.next());
        System.out.print("name// : ");
        song.setName(scanner.next());
        scanner.close();

        movieDao.addSong(song);
        log.debug("저장 완료. {}", song);
    }
}