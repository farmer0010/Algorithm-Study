package Day85;

// 1 * 1 크기의 칸으로 이루어진 직사각형 격자 형태에서 미로에서
// 탈출 하려고함
// 각 칸의 통로 또는 벽으로 구성되어있으며 벽으로 된 칸은 지나
// 갈 수 없고, 통로로 된 칸으로만 이동할 있다.
// 통로들중 한칸에는 미로를 빠져 나가는 문이 있는데
// 이 문들은 레버를 당겨서만 열수있음
// bfs를 두개의 경우의 수로 생각해야되는데
// 출구에서 레버 까지, 레버에서 도착지 까지 두가지를 경우의 수를 합쳐야
// 할듯?
// 미로를 나타내는 매개변수가 주어질 때 미로를 탈출하는데 소요되는 최소시간을
// 구하시오 만약 탈출 할수 없는 경우엔 return -1
//S : 시작 지점
//E : 출구
//L : 레버
//O : 통로
//X : 벽

import java.util.LinkedList;
import java.util.Queue;

class MazeEscape {
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static boolean[][] visited;

    public int solution(String[] maps) {
        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                char ch = maps[i].charAt(j);
                if(ch == 'S'){startX = i;startY = j;}
                if(ch == 'L'){leverX = i;leverY = j;}
            }
        }
        visited = new boolean[maps.length][maps[0].length()];
        int toLever = bfs_miro2(startX,startY,maps,'L');

        visited = new boolean[maps.length][maps[0].length()];
        int toDest =  bfs_miro2(leverX,leverY,maps,'E');

        if(toLever == -1 || toDest == -1){
            return -1;
        }
        int answer = toLever + toDest;
        return answer;
    }

    private int bfs_miro2(int startX, int startY, String[] maps, char target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX,startY, 0});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int curr[] = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int dist = curr[2];

            if(maps[currX].charAt(currY) == target){
                return dist;
            }

            for(int i = 0; i < 4; i++){
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if(newX >=0 && newX < maps.length && newY >= 0 && newY < maps[0].length()  ){
                    if(!visited[newX][newY] && maps[newX].charAt(newY) != 'X'){
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX,newY, dist+1});
                    }
                }
            }
        }

        return -1;
    }


}