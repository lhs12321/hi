package kr.mjc.lhs.spring.jdbc.midterm2;

import kr.mjc.lhs.basics.jdbc.song.Song;
import kr.mjc.lhs.basics.jdbc.song.SongDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class ListSong {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SongDao songDao = applicationContext.getBean(SongDao.class);

        System.out.print("count page : ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int page = scanner.nextInt();
        scanner.close();

        List<Song> song = songDao.listSongs(count, page);
        log.info(song.toString());
    }
}
