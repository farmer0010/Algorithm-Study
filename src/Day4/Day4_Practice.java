package Day4;

import java.util.HashMap;

public class Day4_Practice {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 100);
        map.put("B", 200);
        
        // "C"라는 얘가 있어? 없으면 0을 줘
        int count = map.getOrDefault("C", 0);
        System.out.println("count = " + count);
        
        // 응용 개수세기
        map.put("A", map.getOrDefault("A", 0)+1);
        System.out.println("map.get(\"A\") = " + map.get("A"));
    }
}
