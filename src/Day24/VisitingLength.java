package Day24;

import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for(char c : dirs.toCharArray()) {
            int nextX = x;
            int nextY = y;

            if(c == 'U')
                nextY++;
            if (c == 'D')
                nextY--;
            if (c == 'L')
                nextX--;
            if (c == 'R')
                nextX++;
            if(nextX > 5 || nextX < -5  || nextY > 5 || nextY < -5)
                continue;
            set.add(""+ x + y + nextX + nextY);
            set.add(""+ nextX + nextY +x + y);
            x=nextX;
            y=nextY;
        }
        return set.size()/2;
    }
}
