package Day144;

// 두개 뽑아서 더하기

// numbers에서 서로 다른 인덱스 2개의 수를 뽑아서 만들수 있는 모든 수를
// 배열에 담아야함

import java.util.TreeSet;

class PickTwoAndAdd {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j <= numbers.length -1; j++){
                int num = numbers[i] + numbers[j];
                set.add(num);
            }
        }

        int[] answer = new int[set.size()];

        int index = 0;
        for(Integer value : set){
            answer[index++] = value;
        }

        return answer;
    }
}
