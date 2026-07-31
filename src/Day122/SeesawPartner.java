package Day122;
// 시소 짝꿍

// 시소가 설치되어있고 중심으로 부터 2m,3m,4m 거리 지점에 좌석이
// 하나씩 있음 시소가 평형인 상태에서 각각에 의해 시소에 걸리는 토크
// 크기가 서로 상쇄되어 균형을 이룰수있다면 그 두 사람을 시소 짝꿍이라고 함
// 사람들의 몸무게 목록이 주어질 때 시소의 짝꿍이 몇쌍 존재하는지 구하여 리턴

// 샌드박스
// 이전에 문제를 풀었을때 비율을 활용하여 처리하는 방법이 제일 편함
// 나올 수 있는 비율이 1:1, 1:2, 2:3, 3:4
// 4가지의 경우의 수가 있다
// 일단 생각이 저거 정렬 시켜두고 hashmap으로 운영하고 그 비율에 속한게 있다면 탈출시키고
// answer을 늘리는 방안?

import java.util.HashMap;
import java.util.Arrays;

class SeesawPartner {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Double, Integer> weightMap = new HashMap<>();

        Arrays.sort(weights);

        for(int w : weights){
            double d = (double)w;

            double d1 = d;
            double d2 = (d * 2.0) / 3.0;
            double d3 = (d * 3.0) / 4.0;
            double d4 = (d) / 2.0;

            if(weightMap.containsKey(d1)) answer += weightMap.get(d1);
            if(weightMap.containsKey(d2)) answer += weightMap.get(d2);
            if(weightMap.containsKey(d3)) answer += weightMap.get(d3);
            if(weightMap.containsKey(d4)) answer += weightMap.get(d4);

            weightMap.put(d, weightMap.getOrDefault(d, 0) + 1);
        }

        return answer;
    }
}