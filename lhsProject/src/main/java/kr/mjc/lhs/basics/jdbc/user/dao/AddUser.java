package kr.mjc.lhs.basics.jdbc.user.dao;

import kr.mjc.lhs.basics.jdbc.DbException;
import kr.mjc.lhs.basics.jdbc.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class AddUser{

    public static void main(String[] args){
        UserDao userDao= new UserDaoImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert - email password name: ");
        User user = new User();
        user.setEmail(scanner.next());
        user.setPassword(scanner.next());
        user.setName(scanner.next());

        try {
            userDao.addUser(user);
            log.debug(user.toString());
        } catch (DbException e) {
            log.error(e.toString());
        }//이메일 중복인 경우
    }
}