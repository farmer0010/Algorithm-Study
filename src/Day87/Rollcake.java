package Day87;

// 롤케이크 자르기

// 철수는 롤케이크를 두조각으로 잘라서 동생이랑 먹으려고함
// 여러가지 토핑들이 일렬로 나열되어있고
// 철수와 동생은 케이크를 공평하게 나눠먹으려고 하는데
// 롤케이크의 올라간 토핑의 종류수가 동일한게 공평한 것

// 롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열 topping이
// 주어질 때 롤 케이크를 공평하게 자르는 방법의 수는?
// 일단 배열의 길이가 100만이 넘어가기떄문에 브루트 포스나
// dfs로는 어려움
// 그리고 토핑의 개수가 중요한게 아니라 종류의 개수가 중요한거니
// hashset을 형꺼와 동생꺼 두개로 만들어야되지않나 싶고 -> 오류
// 동생걸 만드는 순간 형이 하나를 빼았으면 동생꺼에선 소멸 되버림
// 동생이 전체적인 것을 다 가지고 있다고 생각 하고 토핑 번호와
// 개수를 가지고 해시맵으로 만들고 형은 hashset으로 가져오는 형식

import java.util.HashMap;
import java.util.HashSet;

class Rollcake {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        // 동생꺼 일단 개수 채워주기
        for (int count : topping) {
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        for (int count : topping) {
            map.put(count, map.getOrDefault(count, 0) - 1);
            if (map.get(count) == 0) {
                map.remove(count);
            }
            set.add(count);
            if (set.size() == map.size()) {
                answer++;
            }
        }
        return answer;
    }
}