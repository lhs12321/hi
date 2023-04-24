package kr.mjc.lhs.basics.jdbc;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String email;
    private String password;
    private String name;

    @Override
    public String toString() {
        // 비밀번호를 빼고 앞에 \n을 넣는다.
        return "\nUser{" + "userId=" + userId + ", email='" + email + '\'' +
                ", name='" + name + '\'' + '}';
    }
}