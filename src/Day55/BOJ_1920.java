package Day55;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // set에 쪼개진 숫자들이 들어간 상황
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
