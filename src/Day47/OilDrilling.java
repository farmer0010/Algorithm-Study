package Day47;

// 석유 시추
// 세로길이가 n 가로길이가 m인 격자 모양의 땅속에서
// 석유가 발견됨
// 석유 덩어리는 여러덩어리가 나누어 묻혀있고
// 시추관을 수직으로 단 하나만 뚫을 수 있을 때
// 가장 많은 석유를 뽑아낼수있는 시추관의 위치를 반환
// 0이면 빈땅 1이면 석유

// 리턴값: 시추관을 설치했을때 가장 많은 석유를 뽑아
// 낸 값

// 샌드박스: bfs를 사용을 해서 면적을 구해야할것같음
// 이건 효율성을 위해 한번 더 생각해야함
// 로직 스케치에서 말한것 처럼 덩어리마다 id 번호를 붙이고
// 거기에 크기 값을 넣어주려면 맵 구조를 써야되지않을까싶음


import java.util.*;

class OilDrilling {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        Map<Integer, Integer> oilMap = new HashMap<Integer, Integer>();
        int chunkId = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    int size = bfs(land, i, j, chunkId, n, m);
                    oilMap.put(chunkId, size);
                    chunkId++;
                }
            }
        }
        int maxOil = 0;
        for(int j = 0; j < m; j++){
            Set<Integer> hitChunks = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if(land[i][j] >= 2){
                    hitChunks.add(land[i][j]);
                }
            }
            int currentOil = 0;
            for (Integer id : hitChunks) {
                currentOil += oilMap.get(id);
            }
            maxOil = Math.max(maxOil, currentOil);
        }
        return maxOil;
    }

    private int bfs(int[][] land, int i, int j, int chunkId, int n, int m) {
        int size = 1;
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        land[i][j] = chunkId;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >=0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1){
                    land[nx][ny] = chunkId;
                    q.add(new int[]{nx, ny});
                    size++;
                }
            }

        }

        return size;
    }
}
