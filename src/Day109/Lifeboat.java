package Day109;

// 구명보트

// 무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고함
// 구명 보트는 작아서 최대 2명씩 밖에 탈수없고
// 무게 제한도 존재함

// 그리고 구명 보트를 최대한 적게 사용하여 모든 사람을 구출하려고함
// 사람들의 몸무게를 담은 배열 pepole과, 구명 보트의 무게제한
// limit가 매개변수로 주어질 때 필요한 구명 보트 개수의 최솟값을
// 리턴하도록 함수를 작성하시오

// 샌드박스
// 일단 첫번 째로 든 생각은 사람의 몸무게를 담은 배열을 정렬해야한다
// 2. 그 정렬한 데이터를 가지고 큐를 활용하여 작업을 해보면
// 개수를 파악할 수있겠다라는 생각이 듬
// 잘못 생각한게 가장 무거운애랑 가벼운애랑 태웠을 때로 잡아야하는데
// 가벼운애랑 가벼운애를 잡아버림 -> 투포인터 전략으로 가는데 맞지
// 않을까 일단 배열을 정렬 시키고

import java.util.Arrays;

class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                answer++;
                left++;
                right--;
            }
            else {
                answer++;
                right--;
            }
        }

        return answer;
    }
}
