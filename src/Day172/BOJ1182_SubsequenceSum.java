package Day172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182_SubsequenceSum {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        if(S == 0){
            count = count -1;
        }

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(st.nextToken());

            arr[i] = K;
        }

        dfs(arr, 0, S , 0);

        System.out.println(count);
    }

    private static void dfs(int[] arr, int sum, int total, int index) {
        if (index == arr.length) {
            if (sum == total) {
                count++;
            }
            return;
        }
        dfs(arr, sum + arr[index], total, index + 1);
        dfs(arr, sum, total, index + 1);
    }
}
