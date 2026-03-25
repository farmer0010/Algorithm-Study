package Day57;

// 구간 합 구하기 4
// 첫째 줄에 수의 개수 N개와 구해야하는 횟수 M개가 주어짐
// 둘째줄에는 숫자 N개의 수가 주어짐
// 셋째 줄 부터는 이제 구간이 주어짐

// 누적합을 극한으로 끌어올려야함
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sumArr[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int current = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1] + current;
        }
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(sumArr[end] - sumArr[start-1]);
        }

    }
}
