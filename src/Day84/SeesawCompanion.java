package Day84;

// 시소 짝꿍

// 시소가 하나 설치 되어있고 그 중심으로부터 2,3,4m 거리의 지점에
// 좌석이 하나씩 있습니다
// 이 시소를 두명이 마주 보고 탄다고 할 때, 시소가 평형인 상태에서
// 각각에 의해 시소에 걸리는 토크의 크기가 서로 상쇄 되어 균형을 이룰수 있
// 다면 그 두 사람을 시소 짝꿍이라고 한다
// 즉 탑승한 사람의 무게와 시소 축간의 좌석 거리 곱이 같다면 시소 짝궁이라고
// 함, 사람들의 몸무게 목록 weights가 주어졌을때 시소의 짝꿍이 몇 쌍
// 존재하는지 구하여 리턴

// 전에 풀어본 문제이긴 하지만 기억은 잘안나서 일단 느낌으로는
// 일단 이중 for문으로 돌려보자니 최대 나올수 있는 길이가
// 길어서 쓸수 없음, 일단 첫번째로 든 생각은 전에 해시맵을 가지고
// 일단 값 하나를 넣고 비교하는 식으로 쌍의 개수를 계산하는데 잡아야
// 할것 같고 시소식을 생각해보면 r1 * m1 = r2 * m2여야 상쇄됨
// 그래서 미터로 나올수있는 비율을 생각해보면 3/2, 4/3, 2/1, 1
// 이 비율을 곱해주면 값 계산에 신경 써야할 것같음

import java.util.Arrays;
import java.util.HashMap;

class SeesawCompanion {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        HashMap<Double,Integer> map = new HashMap<>();

        for (int weight : weights) {
            double a = weight * 1.0;
            double b = weight * (1.0 / 2.0);
            double c = weight * (2.0 / 3.0);
            double d = weight * (3.0 / 4.0);

            if (map.containsKey(a)) {
                answer += map.get(a);
            }
            if (map.containsKey(b)) {
                answer += map.get(b);
            }
            if (map.containsKey(c)) {
                answer += map.get(c);
            }
            if (map.containsKey(d)) {
                answer += map.get(d);
            }
            map.put(a,map.getOrDefault(a,0)+1);
        }
        return answer;
    }
}