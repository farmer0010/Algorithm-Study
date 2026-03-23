package Day49;

// 메뉴 리뉴얼
// 기존의 단품으로만 제공하던 메뉴를 조합하여
// 코스 요리 형태로 재구성
// 어떤 단품 메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을지?
// 이전에 각 손님들이 주문할때 가장 많이 주문한 메뉴들로 구성
// 단 코스요리는 최소 2가지 이상의 단품메뉴로 구성
// 그리고 최소 2명 이상의 손님으로 부터 주문된 단품 메뉴 조합
// 에 대해서만 코스요리 메뉴 후보에 포함

import java.util.*;

class MenuRenewal {
    Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        for (int courseLength : course) {
            map = new HashMap<>();
            for (String order : orders) {
                dfs(order, "", 0, courseLength);
            }
            int maxCount = 2;
            for (Integer count : map.values()) {
                maxCount = Math.max(maxCount, count);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() >= 2 && entry.getValue() == maxCount){
                    list.add(entry.getKey());
                }
            }
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
        }

    private void dfs(String order, String current, int i, int courseLength) {
        if(current.length() == courseLength){
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
    }
        for(int j = i; j < order.length(); j++){
            dfs(order, current + order.charAt(j), j+1, courseLength);
        }
}
}
