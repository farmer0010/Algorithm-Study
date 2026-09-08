package Day141;

// 대문자와 소문자가 섞여있는 문자열 s가 주어짐

// s에 p의 개수와 y의 개수가 같으면 true, 다르면 false를 리턴
// p,y 모두 하나도 없는 경우는 리턴
// 단 갯수를 비교할 때 대문자와 소문자를 구별하지않음

class PYCount {
    boolean solution(String s) {
        boolean answer = true;

        int p_cnt = 0;
        int y_cnt = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            char lower_ch = Character.toLowerCase(ch);

            sb.append(lower_ch);
        }

        String lower_s = sb.toString();

        for(int i = 0; i < lower_s.length(); i++){
            char ch = lower_s.charAt(i);

            if(ch == 'p'){
                p_cnt++;
            }
            else if(ch == 'y'){
                y_cnt++;
            }
        }

        if(p_cnt == y_cnt){
            answer = true;
        }
        else
            answer = false;

        return answer;
    }
}
