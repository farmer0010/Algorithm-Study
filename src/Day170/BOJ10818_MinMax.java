package Day170;

import java.util.*;
import java.io.*;

public class BOJ10818_MinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int k = Integer.parseInt(st.nextToken());
            max = Math.max(max, k);
            min = Math.min(min, k);
        }
        System.out.println(min + " " + max);
    }
}
