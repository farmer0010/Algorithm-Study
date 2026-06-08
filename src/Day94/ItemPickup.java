package Day94;

// 아이템 줍기
// 다각형 모형 지역에서 캐릭터가 아이템을 줍기 위해 이동하려함
// 지형은 각 변이 x축, y축과 평행한 직사각형이 겹쳐진 형태로 표현하며
// 캐릭터는 이 다각형의 둘레를 따라서 이동한다.

// 만약 직사각형을 겹친 후 빈공간안이 안생기는 경우 가장 바깥졲이
// 테두리의 이동 경로가 됨
// 단 서로 다른 두 직사각형의 x축 좌표 또는 y좌표 같은 경우는 없음

// 즉 서로 다른 두 직사각형이 꼭짓점에서 만나거나 변이 겹치는 경우는 없다
// 캐릭터가 아이템을 줍기 위해 이동해야하는 가장 짧은 거리를 리턴

// 지형이 2개 이상으로 분리된 경우도 없고
// 한 직사각형이 다른 직사각형안에 완전히 포함되는 경우도 없다

// 문제흐름 :
// 다각형들이 주어지고 끝에 테두리만 타고 이동해서
// 캐릭터의 좌표와 아이템의 좌표가 주어지고
// 그걸 주워야함
// 일단 1번 문제 어떻게 이 다각형의 좌표를 합쳐서 테두리의 좌표만 생각 나게할까?
// 그 다각형의 테두리만 1로 변경하는데 이게 한번에는 안 이루어지니깐 안에것도 다
// 만들고 어떻게 테두리만 1로만 남게 할까?? 정도의 생각이 듬
// 2배 뻥튀기를 해주는 이유 : 지도가 격자판 배열에 있고, 테두리선만 타거나
// 외곽선만 따라가라는 제약 조건이 있음, 선과 선사이의 간격이 딱 1칸으로
// 아주 좁게 붙어있는 구역이 존재할수 있음

import java.util.LinkedList;
import java.util.Queue;

class ItemPickup {
    int map[][] = new int[101][101];
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            // 테두리를 만든 과정
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    if(i > x1 && i < x2 && j > y1 && j < y2) {
                        map[i][j] = 2;
                    }
                    else if (map[i][j] != 2) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        int answer = bfs_item(characterX*2, characterY*2 , itemX * 2, itemY *2);
        return answer/2;
    }

    private int bfs_item(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int distance = cur[2];

            if(curX == targetX && curY == targetY) {
                return distance;
            }

            for(int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                if (newX >= 0 && newX < 101 && newY >= 0 && newY < 101) {
                    if (map[newX][newY] == 1 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY, distance + 1});
                    }
                }
            }
        }
        return 0;
    }
}
