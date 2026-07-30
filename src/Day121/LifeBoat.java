package Day121;

// 구명보트

// 구명보트 작아서 최대 2명밖에 탈수 없고 무게제한도 있다
// 구명 보트를 최대한 적게 사용하여 모든 사람을 구출 하려고한다.
// 사람들의 몸무게를 담은 배열 people과 구명보트의 무게제한 limit이 매개변수로
// 주어지면 모든 사람들 구출하기 위해 필요한 구명 보트의 개수를 리턴하는 함수를 만들어라

// 샌드박스
// 1. 일단 배열을 오름차순으로 정렬 시켜야되고
// 2. 투포인터를 이용하여 몸무게가 가장 작은 사람과 높은 사람을 뽑아와야지
// 제일 효율적으로 태울수 있다
// 3. 만약 무거운놈 + 가벼운놈을 했을 때 이미 초과했다면 그놈은 혼자 타야하니 보내버린다.

import java.util.Arrays;

class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 1. 배열을 정렬 50,50,70,80
        Arrays.sort(people);

        // 2. 투포인터 활용
        int smallP = 0;
        int largeP = people.length - 1;

        while(smallP <= largeP){
            int total_weight = people[smallP] + people[largeP];

            if(total_weight > limit){
                largeP--;
                answer++;
            }
            else{
                smallP++;
                largeP--;
                answer++;
            }
        }


        return answer;
    }
}
