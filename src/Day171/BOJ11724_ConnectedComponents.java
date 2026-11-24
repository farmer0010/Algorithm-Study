package Day171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724_ConnectedComponents {
    static boolean isVisit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] network = new int[N + 1][N + 1];
        isVisit = new boolean[N + 1];

        int count = 0;

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            network[start-1][end-1] = 1;
            network[end-1][start-1] = 1;
        }

        for(int i = 0; i < N; i++){
            if(!isVisit[i]){
                dfs(i, network);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int cur, int[][] network){
        for(int i = 0; i < network.length; i++){
            if(!isVisit[i] &&  network[i][cur] == 1){
                isVisit[i] = true;
                dfs(i, network);
            }

        }
    }
}
