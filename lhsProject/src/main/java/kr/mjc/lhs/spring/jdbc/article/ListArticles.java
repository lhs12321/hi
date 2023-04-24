package kr.mjc.lhs.spring.jdbc.article;

import kr.mjc.lhs.basics.jdbc.article.Article;
import kr.mjc.lhs.basics.jdbc.article.ArticleDao;
import kr.mjc.lhs.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class ListArticles {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ArticleDao articleDao = applicationContext.getBean(ArticleDao.class);

        List<Article> articleList = articleDao.listArticles(100, 1);
        log.info(articleList.toString());
    }
}
