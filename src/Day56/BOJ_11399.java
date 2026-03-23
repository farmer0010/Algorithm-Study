package Day56;

// atm
// atm 앞에 N명의 사람이 서있음
// i번 사람이 돈을 인출하는데 걸리는 시간 p분
// 줄을 서있는 사람의 수 N과 각 사람이 인출하는 시간이
// 주어졌을 때 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값은?

// 이건 버퍼 리더와 토큰 나이저 둘다 써야하는 경우

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            total += sum;
        }
        System.out.println(total);
    }
}
