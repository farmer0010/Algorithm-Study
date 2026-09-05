package Day140;

// 키 패드 누르기

// 전화의 키패드에서 왼손과 오른손 엄지 손가락만을 이용해서
// 숫자만을 누르려고함

// 맨 처음 왼손 엄지는 * 키패드에, 오른쪽 엄지는 # 키패드에서 위치함
// 왼쪽 문자열 1,4,7은 왼손 엄지로 사용함
// 오른쪽 문자열 3,6,9는 오른쪽 엄지로 사용함
// 가운데 열의 4개 숫자 2,5,8,0을 입력할 떄는 두 엄지 손가락의
// 현재 키패드의 위치에서 더 가까운 엄지 손가락을 사용함
// 만약 두 엄지 손가락의 거리가 같다면 오른손 잡이는 오른손 엄지 손가락으로
// 왼손 잡이는 왼손 엄지 손가락을 사용한다

// 순서대로 누를 번호가 담긴 배열 numbers , 왼손잡이인지 오른손 잡인이지를 나타내는 문자열
// hand가 매개변수로 주어질 때 각 번호를 누른 엄지 손가락이 왼손인지 오른손이지를
// 나타내는 연속된 문자열 형태로 return (왼손 엄지는 L, 오른손 엄지는 R)


// 샌드박스
// 1. 일단 전화번호부에 맞게 배열판을 만들기
// 2. 일단 1,4,7 일떄는 무조건 왼손, 3,6,9 일떄는 무조건 오른손
// 2,5,8,0 일떄는 계산을 해야하는데 이동하는 방식을 생각하면 무조건 bfs
// 거기까지 이동 최단 거리를 왼손 기준 오른손 기준으로 해서 거리 측정
// 그거에 맞게 하고 거리가 같다면 hand를 통해서 판별

import java.util.*;

class KeypadPress {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int left_row = 3;
        int left_col = 0;
        int right_row = 3;
        int right_col = 2;

        int left[] = new int[]{left_row, left_col};
        int right[] = new int[]{right_row, right_col};

        Map<Integer, int[]> phone_map = new HashMap<>();

        for(int i = 1; i <= 9; i++){
            int row = (i-1) / 3;
            int col = (i-1) % 3;

            phone_map.put(i, new int[]{row, col});
        }
        phone_map.put(0, new int[]{3, 1});

        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                sb.append("L");
                left = phone_map.get(number);
            }
            else if(number == 3 || number == 6 || number == 9){
                sb.append("R");
                right = phone_map.get(number);
            }
            else{
                int cur[] = phone_map.get(number);
                int row = cur[0];
                int col = cur[1];

                int diff_left_row = Math.abs(left[0] - row);
                int diff_left_col = Math.abs(left[1] - col);
                int diffL = diff_left_row + diff_left_col;
                int diff_right_row = Math.abs(right[0] - row);
                int diff_right_col = Math.abs(right[1] - col);
                int diffR = diff_right_row + diff_right_col;

                if(diffL < diffR){
                    sb.append("L");
                    left = phone_map.get(number);
                }
                else if(diffR < diffL){
                    sb.append("R");
                    right = phone_map.get(number);
                }
                else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right = phone_map.get(number);
                    }
                    else{
                        sb.append("L");
                        left = phone_map.get(number);
                    }
                }
            }
        }
        answer = sb.toString();

        return answer;
    }
}
