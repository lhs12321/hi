package kr.mjc.lhs.basics.jdbc;

import kr.mjc.lhs.basics.jdbc.article.ArticleDao;
import kr.mjc.lhs.basics.jdbc.article.ArticleDaoUsingJdbcHelper;
import kr.mjc.lhs.basics.jdbc.user.dao.UserDao;
import kr.mjc.lhs.basics.jdbc.user.dao.UserDaoUsingJdbcHelper;

public class DaoFactory {

    public static UserDao getUserDao() {
        return new UserDaoUsingJdbcHelper();
    }

    public static ArticleDao getArticleDao() {
        return new ArticleDaoUsingJdbcHelper();
    }
}
