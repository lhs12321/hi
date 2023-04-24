package kr.mjc.lhs.spring.jdbc.midterm2;

import kr.mjc.lhs.basics.jdbc.song.Song;
import kr.mjc.lhs.basics.jdbc.song.SongDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class DeleteSong {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SongDao songDao = applicationContext.getBean(SongDao.class);

        System.out.print("songId");
        Scanner scanner = new Scanner(System.in);
        int songId = scanner.nextInt();
        scanner.close();

        int delete = songDao.deleteSong(songId);

        if (delete >= 1)
            log.info("삭제 완료");
        else
            log.info("삭제 실패");

        }
    }
