package kr.mjc.lhs.basics.collections;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Student {
    private String id;
    private String name;
}
