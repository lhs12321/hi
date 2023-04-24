package kr.mjc.lhs.basics.collections;

import java.util.HashMap;
import java.util.Map;

public class MapEx {
    public static void main(String[] args){
        Student s1 = new Student("Key1", "Jacob");
        Student s2 = new Student("Key2", "Rachel");
        Student s3 = new Student("Key3", "Jacob");

        Map<String, Student> map1 = new HashMap<>();
        map1.put("key1", s1);
        map1.put("key2", s2);
        map1.put("key3", s3);

        System.out.println(map1);
        System.out.println(map1.get("key2"));
        System.out.println(map1.get("key3"));

        // 맵은 엔트리 셋
        for (Map.Entry<String, Student> entry : map1.entrySet()) {
            System.out.format("key:%s, value:%s\n", entry.getKey(), entry.getValue());
        }

        // 키셋에서 키로 값 가져오기
        for (String key : map1.keySet()) {
            Student value = map1.get(key);
            System.out.println(value);
        }
    }
}