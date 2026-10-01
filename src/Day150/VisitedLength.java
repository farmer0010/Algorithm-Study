package Day150;

// 방문 길이

// 움직일 수 있는 범위 -5 ~ 5
// 키워드 u, d, r, l

import java.util.*;

class VisitedLength {
    public int solution(String dirs) {
        int answer = 0;

        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;

        for(int i = 0; i < dirs.length(); i++){
            int next_x = x;
            int next_y = y;

            char ch = dirs.charAt(i);

            if(next_x > 5 || next_x < -5 || next_y > 5 || next_y < -5)
                continue;

            if(ch == 'U')
                next_y++;
            else if(ch == 'D')
                next_y--;
            else if(ch == 'L')
                next_x--;
            else if(ch == 'R')
                next_x++;

            if(next_x > 5 || next_x < -5 || next_y > 5 || next_y < -5)
                continue;

            set.add(x +""+ y + ',' +next_x+ ""+ next_y);
            set.add(next_x +""+ next_y + "," +x+ ""+ y);

            x = next_x;
            y = next_y;
        }
        answer = set.size() / 2;

        return answer;
    }
}