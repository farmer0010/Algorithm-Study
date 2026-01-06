package Day16;

import java.util.Arrays;

class Lifeboat {
    public int solution(int[] people, int limit) {
        // 1. 몸무게 별로 정렬(50, 50, 70, 80)
        Arrays.sort(people);
        int answer = 0;
        int index = 0;
        int right = people.length - 1;

        while (index <= right) {
            if(people[index] + people[right] <= limit)
            {
                index++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}
