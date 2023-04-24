package kr.mjc.lhs.basics.jdbc.user.dao;

import kr.mjc.lhs.basics.jdbc.User;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class ListUser {
    public static void main(String[] args) {
        UserDao userDao= new UserDaoImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.print("List - count page : ");
        int[] params = {scanner.nextInt(), scanner.nextInt()};
        scanner.close();

        List<User> userList = userDao.listUsers(params[0], params[1]);
        log.debug(userList.toString());
    }
}