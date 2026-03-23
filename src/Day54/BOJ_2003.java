package Day54;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while(true)
        {
            if(sum >= M)
            {
                sum -= arr[left];
                left++;
            }
            else if(right == N)
                break;
            else{
                sum += arr[right];
                right++;
            }
            if(sum == M)
                count++;
        }
        System.out.println(count);
    }
}
