package Day156;

// 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
// 가장 짧은 구간의 시작 진열대 번호와 끝 진열대 번호를 차례대로 닮아서 리턴
// 가장 짧은 구간이 여러개라면 시작 진열대 번호가 가장 작은 구간을 리턴
// 일단 보석의 종류의 개수를 생각해야될 것같음 그렇기에 여기에서는 set을 쓸거임
// 어차피 set.size()를 통해서 종류의 수 찾는게 우선이기떄문에

// 그 다음에 양방향 포인터를 통해서 범위를 줄일건데 어떻게 범위를 잡을건지 생각해보는게 우선
// 10만이면 모든걸 돌기엔 좀 빡셀수도 있지않을까 시간 떄문에

import java.util.*;

class JewelShopping {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();

        for(String s : gems){
            set.add(s);
        }

        int cnt = set.size();

        HashMap<String, Integer> map = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        for(int right = 0; right < gems.length; right++){
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            while(map.size() == cnt){
                int len = right - left + 1;

                if(len < minLen){
                    minLen = len;
                    start = left + 1;
                    end = right + 1;
                }

                String out = gems[left];
                map.put(out, map.get(out) - 1);
                if(map.get(out) == 0){
                    map.remove(out);
                }
                left++;
            }
        }

        return new int[]{start, end};
    }
}
