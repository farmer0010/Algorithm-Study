package Day171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15650_NAndM2 {
    static ArrayList<String> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dfs("", 0,1, N, M);

        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }

    }

    public static void dfs(String str, int count, int prev , int N, int M){
        if(count == M){
            lst.add(str);
            return;
        }

        for(int i = prev; i <= N; i++){
            dfs(str + i + " ", count + 1, i + 1, N, M);
        }
    }
}
