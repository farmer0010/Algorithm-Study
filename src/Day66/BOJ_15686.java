package Day66;

// 치킨 배달

// 크기가 N * N인 도시가 있고 도시는 1*1 크기의 칸으로 나누어짐
// 도시의 각 칸의 빈칸, 치킨집, 집 중 하나임

// 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리
// 즉 치킨거리는 집을 기준으로 정해지며 각각의 집은 치킨거리를 가지고있음
// 도시의 치킨 거리는 모든 집의 치킨 거리의 합

// 치킨 거리 계산법 1(r1,c1), 2(r2,c2) -> |r1-r2| + |c1-c2|
// 절대값이니깐 abs 써야되지않나? 그리고 계산법이 있으니 bfs는 안써도 될것같고

// 프렌차이즈 본사에서는 수익을 증가 시키기 위해 일부 치킨집을 폐업 시키려고함
// 가장 수익을 많이 낼수 있는 치킨집 갯수 M개 라는 사실을 알아냄
// 도시에 있는 치킨집에 M개 뺴고는 모두 페업 어떻게 고르면 도시의 치킨 거리가
// 가장 작게 될지 구하는 프로그램 작성

// 첫째 줄에는 N과 M이 주어짐
// 둘째줄에는 N개줄에 도시정보가 주어짐
// 도시의 정보는 0,1,2로 이루어짐

// 일단 dfs로 찾되
// 집의 좌표를 저장하는 배열과 , 치킨 집 위치를 저장하는 배열 필요
// dfs 종료조건은 M개를 고르는게 끝났을떄 겟지


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
    static int map[][];
    static int N;
    static int M;
    static int minDistance = Integer.MAX_VALUE;
    static boolean[] open;
    static ArrayList<int []> homelist = new ArrayList<>();
    static ArrayList<int []> chickenlist = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 맵 만들기 및 집 위치와 치킨집 위치 추가
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    homelist.add(new int []{i,j});
                }
                else if(map[i][j]==2){
                    chickenlist.add(new int []{i,j});
                }
            }
        }
        open = new boolean[chickenlist.size()];
        dfs_chicken(0,0);
        System.out.println(minDistance);
    }

    private static void dfs_chicken(int start, int count) {
        if(count == M)
        {
            int currentDist = 0;
            for(int i=0;i<homelist.size();i++)
            {
                int hx = homelist.get(i)[0];
                int hy = homelist.get(i)[1];
                int minDist = Integer.MAX_VALUE;
                    for (int j=0; j < chickenlist.size(); j++){
                        if(open[j]){
                            int cx = chickenlist.get(j)[0];
                            int cy = chickenlist.get(j)[1];

                            int dist = Math.abs(hx - cx) + Math.abs(hy - cy);
                            minDist = Math.min(minDist, dist);
                        }
                }
                currentDist += minDist;
            }
            minDistance = Math.min(minDistance,currentDist);
        }
        for (int i = start; i < chickenlist.size(); i++) {
            open[i] = true;
            dfs_chicken(i+1,count+1);
            open[i] = false;
        }
    }
}
