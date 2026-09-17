package Day145;

// 정수를 저장한 배열 arr에서 가장 작은 수를 제거한 배열을 리턴하는 함수를
// 완성 단 배열이 빈 배열이 경우엔 배열에 -1을 채워 리턴

import java.util.ArrayList;

class RemoveMinNumber {
    public int[] solution(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();

        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            mini = Math.min(arr[i], mini);
        }

        for(int i = 0; i < arr.length; i++){
            if(arr.length == 1 || arr.length == 0){
                list.add(-1);
                break;
            }
            else{
                if(arr[i] != mini){
                    list.add(arr[i]);
                }
            }
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for(int value : list){
            answer[index++] = value;
        }

        return answer;
    }
}

