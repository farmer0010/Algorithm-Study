package Day56;

// N장의 카드가 있고 각각의 카드는 1~n까지 번호가 있음
// 1번 카드가 제일 위헤 n번 카드가 제일 아래인 상태
// 뭐 문제 자체는 양방향 큐를 이용하라는 문제인듯

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            stack.offer(i);
        }
        while(stack.size() > 1){
            stack.poll();
            int num = stack.poll();
            stack.offer(num);
        }
        System.out.println(stack.peek());
    }
}
