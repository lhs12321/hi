package kr.mjc.lhs.basics.collections;

import java.util.HashSet;
import java.util.Set;

public class StudentSetEx {
    public static void main(String[] args){
        Student s1= new Student("key1", "Rachel");
        Student s2= new Student("key2", "David");
        Student s3= new Student("key1", "Rachel");

        System.out.format("%x\n", s1.hashCode());
        System.out.format("%x\n", s2.hashCode());
        System.out.format("%x\n", s3.hashCode());

        Set<Student> set1 = new HashSet<>();
        set1.add(s1);
        set1.add(s2);
        set1.add(s3);
        System.out.println(set1);
    }
}