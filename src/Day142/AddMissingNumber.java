package Day142;

// 없는 숫자 더하기

// 0부터 9까지의 숫자중 일부가 들어있는 정수 배열 numbers가 매개변수로
// 주어지고 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 리턴해라

// 샌드박스
// 0 ~ 9 까지 반복문으로 더하고 얘를 일단 set에다가 넣고
// 그거에 포함되지않는다면 answer에 더하는 식으로 진행

import java.util.HashSet;

class AddMissingNumber {
    public int solution(int[] numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < numbers.length; i++){
            set.add(numbers[i]);
        }

        for(int i = 0;  i <= 9; i++){
            if(!set.contains(i)){
                answer += i;
            }
        }

        return answer;
    }
}
