package Day43;

// 미로 찾기
// 1x1 크기들의 칸들로 이루어지 직사각형 격자형태의 미로에서 탈출
// 각 칸은 통로 아니면 벽 -> 통로로 된 칸으로만 통과가능
// 통로들 중 한칸에 나가는 문 존재, 이 문을 나가려면
// 레버를 떙겨야함
// 이동경로 : 시작점 -> 레버 -> 출구
// 리턴값: 한칸 이동하는데 1초 -> 탈출하는 걸린 최소시간
// 만약 탈출 할 수 없다면 리턴값 -1
// 시작점: S, 출구: E, 레버: L , 통로 O, 벽 X

// 샌드박스
// 얘도 동일하게 dx[] ={1,-1,0,0} dy[] = {0,0,1,-1};
// 이동 경로가 가능한지 계산하는 부분이 필요할듯
// 일단 bfs면 뭐가 필요하다? 큐랑 방문기록체크용이 필요하다~

// 추가 샌드박스
//1, 방문 기록장의 레버에 도착하면 그동안의 방문 기록장을 초기화 시키
// 거나 한번 이동해서 트루를 찍고 다시 false로 바꿔주거나인데
// 전자의 경우가 더 맞다고 생각듬
//2. 이 3개의 데이터를 담으려면 그거 저정하는 작은 클래스가 필요하고
// 그 큐에 이 클래스를 담을수있게 지정해줘야할것같음
//3. 분리한다면 뭐 똑같이 x,y랑 이동 시간을 받는 클래스를 매개변수로?

import java.util.LinkedList;
import java.util.Queue;

class MazeEscape {
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
    boolean[][] visited;
    public int solution(String[] maps) {
        Node start = null;
        Node lever = null;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'S') start = new Node(i,j,0);
                if(maps[i].charAt(j) == 'L') lever = new Node(i,j,0);
            }
        }
        int time1 = bfs(maps,start,'L');
        if(time1 == -1) return -1;
        int time2 = bfs(maps,lever,'E');
        if(time2 == -1) return -1;

        return time1+time2;
    }

    private int bfs(String[] maps, Node start, char target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited = new boolean[maps.length][maps[0].length()];
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                if(nextX >= 0 && nextY >=0 && nextX < maps.length && nextY < maps[nextX].length()) {
                    if(maps[nextX].charAt(nextY) != 'X' && !visited[nextX][nextY]) {
                        if(maps[nextX].charAt(nextY) == target) {
                            return node.count+1;
                        }
                        else {
                            visited[nextX][nextY] = true;
                            queue.offer(new Node(nextX, nextY, node.count+1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

