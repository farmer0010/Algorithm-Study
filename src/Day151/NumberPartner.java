package Day151;

import java.util.*;

class NumberPartner {
    public String solution(String X, String Y) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> x_map = new HashMap<>();
        HashMap<Character, Integer> y_map = new HashMap<>();

        for(int i = 0; i < X.length(); i++){
            char ch = X.charAt(i);
            x_map.put(ch, x_map.getOrDefault(ch, 0) +1);
        }

        for(int i = 0; i < Y.length(); i++){
            char ch = Y.charAt(i);
            y_map.put(ch, y_map.getOrDefault(ch, 0) +1);
        }

        for(char d = '9'; d >= '0'; d--){
            int x_cnt = x_map.getOrDefault(d, 0);
            int y_cnt = y_map.getOrDefault(d, 0);
            int cnt = Math.min(x_cnt, y_cnt);

            for(int i = 0; i < cnt; i++){
                sb.append(d);
            }
        }
        answer = sb.toString();

        if(answer.isEmpty())
            return answer = "-1";

        if(answer.charAt(0) == '0')
            return answer = "0";

        return answer;
    }
}