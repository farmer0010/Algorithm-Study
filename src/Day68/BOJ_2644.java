package Day68;

// 촌수 계산

// 부모와 자식 1촌, 나와 할아버지 이촌, 나와 아버지 형제들과는 3촌
// 입력: 첫째줄에는 전체 사람의 수 n이 표기
// 둘째 줄에는 촌수를 계산해야하는 서로 다른 두사람의 번호가 주어짐
// 셋째줄에는 부모자식들 간의 관계의 개수 m이 주어짐
// 넷째줄 부터는 부모 자식 간의 관계를 나타내는 두번호 x,y가 주어짐
// 이떄 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타냄

// 그러면 y가 부모이고 x가 자식?
// 이렇게 되면 트리처럼 형성됨
// 그러면 우리는 bfs나 dfs를 활용하여 만들어야겠지싶음
// 입력에서 요구한 두 사람의 촌수를 나타내는 정수를 구해라

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int n;
    static int numP;
    static int numC;
    static int m;
    static int map[][];
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numP = Integer.parseInt(st.nextToken());
        numC = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        // 관계도 정도 만들어두기?
        for(int k = 0; k < m; k++){
            st = new StringTokenizer(br.readLine());
            int ParentN =  Integer.parseInt(st.nextToken());
            int ParentC = Integer.parseInt(st.nextToken());
            map[ParentN][ParentC] = 1;
            map[ParentC][ParentN] = 1;
        }
        int result = bfs_parent(numP, numC);
        System.out.println(result);
    }

    private static int bfs_parent(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()){
            int cur[] = queue.poll();
            int person = cur[0];
            int degree = cur[1];

            if(person == target){
                return degree;
            }
            for(int i = 1; i <= n; i++){
                if(map[person][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(new int[]{i, degree+1});
                }
            }
        }
        return -1;
    }
}
