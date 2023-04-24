package kr.mjc.lhs.spring.jdbc.midterm2;

import kr.mjc.lhs.basics.jdbc.movie.Movie;
import kr.mjc.lhs.basics.jdbc.movie.MovieDao;
import kr.mjc.lhs.basics.jdbc.song.Song;
import kr.mjc.lhs.basics.jdbc.song.SongDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class UpdateSong {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SongDao songDao = applicationContext.getBean(SongDao.class);

        Song song = new Song();
        System.out.print("songId//title//name//");
        Scanner scanner = new Scanner(System.in).useDelimiter("//");
        int songId = scanner.nextInt();
        String title = scanner.next();
        String name = scanner.next();
        scanner.close();

        song.setSongId(songId);
        song.setTitle(title);
        song.setName(name);

        int updatedRows = songDao.updateSong(song);
        if (updatedRows >= 1)
            log.info("수정 완료");
        else
            log.info("수정 실패");

        }
    }
