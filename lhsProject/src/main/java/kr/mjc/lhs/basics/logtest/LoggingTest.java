package kr.mjc.lhs.basics.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingTest {
    public static void main(String[] args) {
        Logger log1 = LoggerFactory.getLogger(LoggingTest.class);
        log1.debug("디버깅 로그");
        log1.info("중요 이벤트 로그");
        log1.error("에러 코드");
    }
}