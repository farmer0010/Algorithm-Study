package Day170;

// 메뉴 리뉴얼

// 이전에 각 손님들이 주문할 떄 가장 많이 함께 주문한 단품 메뉴들을 코스
// 요리 메뉴로 구성
// 단 코스 요리메뉴는 최소 2가지 이상의 단품 메뉴로 구성하려고함
// 또한 최소 2명이상의 손님으로 부터 주문 된 단품 메뉴 조합에 대해서만
// 후보로 포함하려고 함

// 배열의 크기가 작아서 모든 조합의 경우의 수를 뽑아낸다음에 걸러야하나라는 생각?
// 문제의 예시를 보면 문자열 길이에 해당하는 문자열이 그 안에 포함되는지를 확인하면 되는
// 문제인것같은데 그러기엔 경우의 수를 너무 따져야되지않나?

// 1. 저 문자열과, 문자열의 길이를 일단 맵에 넣고
// 2. 그거 마다 돌면서 각 해당하는 애들을 찾음?

import java.util.*;

class MenuRenewal {
    HashMap<String, Integer> map;
    ArrayList<String> lst = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {

        int index = 0;

        for(String o : orders){
            char[] arr = o.toCharArray();
            Arrays.sort(arr);
            orders[index++] = String.valueOf(arr);
        }

        for(int i = 0; i < course.length; i++){
            map = new HashMap<>();
            for(int j = 0; j < orders.length; j++){
                dfs("", orders[j], 0, course[i]);
            }

            int max = 0;
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                String s = entry.getKey();
                int n = entry.getValue();

                max = Math.max(max, n);
            }
            if(max < 2)
                continue;

            for(Map.Entry<String, Integer> entry : map.entrySet()){
                String s = entry.getKey();
                int n = entry.getValue();

                if(n == max)
                    lst.add(s);
            }
        }

        String[] answer = new String[lst.size()];
        Collections.sort(lst);

        for(int i = 0; i < lst.size(); i++){
            answer[i] = lst.get(i);
        }

        return answer;
    }

    public void dfs(String str, String order, int index, int count){
        if(str.length() == count){
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        for(int j = index; j < order.length(); j++){
            dfs(str + order.charAt(j), order, j+1, count);
        }
    }
}
