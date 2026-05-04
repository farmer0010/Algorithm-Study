package Day80;

// 시소 짝꿍

// 어느 공원 놀이터에 시소가 설치 되어있고
// 이 시소는 중심으로 부터 2m,3m,4m 지점에 하나씩 있음
// 두명이 서로 마주보고 탄다고 할때 시소가 평형인 상태에서
// 토크의 크기가 상쇄되어 균형을 이룰수 있다면
// 그 두 사람을 시소의 짝궁이라고함
// 즉 탑승한 사람의 무게와 시소 축과 좌석간의 거리의 곱이 같다면 시소 짝꿍
// 사람들의 몸무게 목록이 주어질때, 시소 짝궁이 몇쌍 존재하는지?

// 일단 이중 for문은 저 몸무게 배열의 길이 만큼 하면 무조건 시간 초과고
// 이럴 떄 쓰는게 양방향 포인터로 좀 줄이는 거같긴한데
// 일단 양방향 포인터를 사용하면 그것에 맞게 위치를 옮기면 줄일수있으니깐
// 양방향 포인터로 하다 보면 두수의 합이나 , 연속된 배열의 부분으 찾을 때
// 사용해야한다함, 근데 우리는 시소의 균형 즉 비율을 맞쳐야되는게 맞기에
// 이 방식은 패스
// 그리고 일단 몸무게 배열을 먼저 정렬해두자
// 일단 맵에 weight를 다 넣어주고
// w1/w2 비율이 d1/d2 비율과 같아야지 수학적 비율을 가지는데
// 정확히 어떤 비율인지는 감이 안오네

import java.util.Arrays;
import java.util.HashMap;

class SeesawCompanion {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();
        long answer = 0;

        for(int i = 0; i < weights.length; i++){
            double w = weights[i];

            if(map.containsKey(w)){
                answer += map.get(w);
            }
            if(map.containsKey(w * (2.0/3.0))){
                answer += map.get(w * (2.0/3.0));
            }
            if(map.containsKey(w * (1.0/2.0))){
                answer += map.get(w  * (1.0/2.0));
            }
            if(map.containsKey(w * (3.0/4.0))){
                answer += map.get(w * (3.0/4.0));
            }
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        return answer;
    }
}