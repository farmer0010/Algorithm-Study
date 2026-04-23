package Day76;

// 보석 쇼핑

// 어피치는 쇼핑을 할 때면 매장 진열대의 특정 범위의
// 물건들을 모두 싹쓸이 구매하는 습관이 있음

// 조건: 진열된 모든 종류의 보석을 적어도 1개이상
// 포함하는 가장 짧은 구간을 찾아서 구매
// 매개변수: 진열대의 번호 순서대로 보석들의 이름이
// 저장된 gems가 매개 변수

// 이 떄 모든 보석을 하나 이상 포함하는 가장 짧은 구간
// 을 리턴하도록 함수 완성

// 일단 생각이 든게 gems를 해시맵에 넣고
// key에는 인덱스 위치, value에는 보석이름?
// ㄴ 이건 gems에서 어차피 소화하기떄문에
// 지금 내 장바구니에 보석 종류가 다 들어있는지
// 체크용도
// 그리고 gems랑 배열에서 투포인터로 범위를 줄이면서
// 해시맵과 인덱스 비교해서 리턴하는 느낌인가?

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution_67258 {
    public int[] solution(String[] gems) {
        // 일단 중복 정리 및, 보석의 개수 파악
        HashSet<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
       int targetSize = set.size();
        int[] answer = new int[2];

        Map<String,Integer> map = new HashMap<>();
        int left = 0;

        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < gems.length; right++) {
            String gem = gems[right];
            map.put(gem,map.getOrDefault(gem,0)+1);

            while (map.size() == targetSize){
                int curLen = right-left;
                if(curLen<minLen){
                    minLen = curLen;
                    answer[0] = left +1;
                    answer[1] = right +1;
                }
                String leftgem = gems[left];
                map.put(leftgem,map.get(leftgem)-1);

                if(map.get(leftgem)==0){
                    map.remove(leftgem);
                }
                left++;
            }
        }
        return answer;
    }
}
