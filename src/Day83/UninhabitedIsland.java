package Day83;

// 무인도 여행

// 지도에는 무인도와 바다로 정보가 표시됨
// 지도는 1*1 크기의 사각형들로 이루어진 직사각형 형태

// 격자의 각칸은 x,또는 1~9 자연수로 이루어짐
// 지도의 x는 바다, 숫자는 무인도를 나타냄
// 이떄 상하좌우로 연결되는 땅들은 무인도, bfs일 확률 높음
// 지도에 각 적힌칸의 숫자는 식량을 나타내는데 모두 합한 값은
// 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냄

// 각 섬에서 최대 며칠씩 머물수 있는지 배열에 오름 차순으로 담아
// 리턴, 만약 지낼수 있는 무인도가 없다면 -1을 배열에 담아 리턴

import java.util.*;

class UninhabitedIsland {
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static boolean[][] visited;

    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];

        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j) != 'X' && visited[i][j] == false){
                    int task = bfs_island(i,j, maps);
                    answer.add(task);
                }
            }
        }
        if(answer.isEmpty()){
            return new int[]{-1};
        }

        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs_island(int startX, int startY, String[] maps) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int sum = maps[startX].charAt(startY) - '0';

        while (!q.isEmpty()){
            int cur[] = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0;i<4;i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >=0 && nx < maps.length && ny >= 0 && ny < maps[0].length() ){
                    if(!visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                        visited[nx][ny] = true;
                        sum += maps[nx].charAt(ny)-'0';
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return sum;
    }
}