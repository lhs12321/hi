package kr.mjc.lhs.basics.collections;

import java.util.HashSet;
import java.util.Set;

public class SetEx {
    public static void main(String[] args) {
        Set<String> set1= new HashSet<>();
        set1.add("Melon");
        set1.add("Apple");
        set1.add("StrawBerry");
        set1.add("Apple");

        System.out.println(set1);

        for(String s: set1){
            System.out.println(s);
        }
    }
}