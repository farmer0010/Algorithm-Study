package Day2;

import java.util.ArrayDeque;
import java.util.Deque;

// 스택
public class ArrayDequePratice {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);

        int out = stack.pop(); // 꺼내기
        int peek = stack.peek(); // 맛보기
    }
}
