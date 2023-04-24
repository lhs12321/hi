package kr.mjc.lhs.basics.collections;

import java.util.List;
import java.util.ArrayList;
public class ListEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(-1);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            int item = list.get(i);
            System.out.println(item);
        }

        // enhanced for
        for (int item : list) {
            System.out.println(item);
        }
    }
}