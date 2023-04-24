package kr.mjc.lhs.basics.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * db.properties 파일에서 url을 읽어서 데이터소스를 만드는 팩토리
 */
@Slf4j
public class DataSourceFactory {

    public static DataSource getDataSource() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("C:/Users/lhs/IdeaProjects/lhsProject/lhsProject/src/main/resources/db.properties"));
            return new MariaDbDataSource(props.getProperty("url"));
        } catch (IOException | SQLException e) {
            log.error(e.toString());
            throw new RuntimeException(e);
        }
    }
}