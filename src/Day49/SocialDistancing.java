package Day49;

// 거리두기 확인하기
// 대기실은 5개이며 각 대기실을 5x5 크기
// 거리두기를 위하여 응시자들끼리는 멘헤튼의 거리가 2이하로
// 앉지말아야함
// 단 응시자가 앉아있는 자리 사이가 파디션으로 막혀있을 경우에 허용

// 앉아있는자리 p
// 반테이블 o
// 파티션 x

// 리턴값: 거리두기를 지키고 있으면 1
// 지키지 않으면 0
// 5개의 방을 보고 배열값을 리턴

// 코테의 정확성 테스트가 있으면 뭔가 한번 더
// 생각해야하는거 아닌가?

import java.util.LinkedList;
import java.util.Queue;

class SocialDistancing {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            if(checkRoom(places[i])){
                answer[i] = 1;
            }
            else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean checkRoom(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(place[i].charAt(j) == 'P'){
                    if(!bfs(place,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean bfs(String[] place, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        q.add(new int[]{i,j,0});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curI = cur[0];
            int curJ = cur[1];
            int dist = cur[2];

            if(dist >= 2)
                continue;

            for (int k = 0; k < 4; k++) {
                int newI = curI + dx[k];
                int newJ = curJ + dy[k];
                if(newI >=0 && newI < 5 && newJ >= 0 && newJ < 5 && !visited[newI][newJ]){
                    if(place[newI].charAt(newJ) == 'O'){
                        visited[newI][newJ] = true;
                        q.add(new int[]{newI,newJ,dist+1});
                    }
                    else if(place[newI].charAt(newJ) == 'P'){
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
