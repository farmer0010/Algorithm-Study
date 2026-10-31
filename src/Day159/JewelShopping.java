package Day159;

// 보석 쇼핑

// 매장 진열대의 특정 범위 물건들을 모두 구매하려고함
// 진열된 모든 보석의 종류를 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서
// 구매하려고함

// 진열대 번호 순서대로 보석들의 이름이 저장된 배열 gems가 주어지고
// 이때 모든 보석을 하나이상 포함하는 가장 짧은 구간을 리턴
// 만약 가장 짧은 구간이 여러개라면 시작 진역대 번호가 가장 작은 구간을 리턴

// 일단 배열의 크기가 10만이라 구간을 좁히려면 양방향 포인터를 생각해야함
// 근데 우리는 보석의 개수가 아직 몇개인지 모름 그래서 나는 얘를 set에다가 넣을꺼임
// 그리고 맵을 만들어서 처음에 시작점부터 개수가 맞지않으면 오른쪽으로 키우고 널널하면 왼쪽을 줄이는
// 식으로 구상

import java.util.*;

class JewelShopping {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(String gem : gems){
            set.add(gem);
        }

        int size = set.size();

        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < gems.length; right++){

            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            while(map.size()  == size){
                int len = right - left + 1;

                if(len < minLen){
                    minLen = len;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                map.put(gems[left], map.getOrDefault(gems[left], 0) -1);
                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }
                left++;
            }
        }

        return answer;
    }
}
