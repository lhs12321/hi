package kr.mjc.lhs.basics.jdbc.song;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class Song {
    private int songId;
    private String title;
    private String name;

    @Override
    public String toString() {
        return String.format("\nSong{songId=%d, title=%s, name=%s}", songId,
                title, name);
    }
}
