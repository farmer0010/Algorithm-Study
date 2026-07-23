package Day118;

// 무인도 여행

// 지도에는 바다와 무인도에 대한 정보가 표시됨
// 지도는 1*1 크기의 사각형들로 이루어진 직사각형의 형태이며
// 격자의 각 칸에는 x 또는 1 ~ 9 까지 숫자로 이루어져있음
// x는 바다, 1~9는 무인도를 나타냄
// 상 하 좌 우 로 연결되는 땅들은 무인도 이룸
// 각 칸에 적힌 숫자를 모두 합한값은 해당 무인도에서 최대
// 며칠 머무를 수있는지를 나타냄
// 우선 각섬에서 최대 며칠씩 머무를 수 있는지를
// 배열에 오름 차순으로 담아 return 하는 함수를 완성해라
// 무인도가 없다면 -1을 배열에 담아 리턴

// 샌드박스
// 일단 정해진 수나 이러한 문제에서는 bfs를 통해 파악
// 일단 x가 아니면서 방문 하지않았던 곳으로 돌아야함
// 일단 시작 스타트 포인트를 잡아주는게 중요한데 얘를 0,0으로
// 하는게 안맞지않나 라는 생각

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class UninhabitedIsland {
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};

    boolean[][] isCheck;
    ArrayList<Integer> list = new ArrayList<>();

    public int[] solution(String[] maps) {
        isCheck = new boolean[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) != 'X' && !isCheck[i][j]){
                    bfs_land(i,j, maps);
                }
            }
        }
        if(list.isEmpty()){
            return new int[]{-1};
        }

        int[] answer = new int [list.size()];
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    private void bfs_land(int startX, int startY, String[] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        isCheck[startX][startY] = true;
        int count = maps[startX].charAt(startY) - '0';

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >=0 && nx < maps.length && ny >= 0 && ny < maps[0].length() ){
                    if(!isCheck[nx][ny] && maps[nx].charAt(ny) != 'X'){
                        isCheck[nx][ny] = true;
                        count += maps[nx].charAt(ny)-'0';
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        list.add(count);
    }
}
