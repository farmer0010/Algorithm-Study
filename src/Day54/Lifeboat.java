package Day54;

// 구명보트
// 구명보트 작아서 한번에 두명만 탑승가능

// 모든 사람을 구출 하기 위한 구명 보트
// 최소값을 리턴

// 샌드박스
// 1. 일단 상향식으로 정렬해야하나?
// 2. 투포인터 개념을 생각해서
// 왼쪽, 오른쪽 지점을 찾아주고
// 만약에 그 지점을 넘는다면
// 전꺼를 리턴 시키는게 맞을듯한디

import java.util.Arrays;

class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 1. 정렬
        Arrays.sort(people);
        //2 . 투포인터 왼쪾 오른쪽 세우기
        int left = 0;
        int right = people.length - 1;
        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer ++;
        }
        return answer;
    }
}
