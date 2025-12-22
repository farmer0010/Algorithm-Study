package Day7;

// 프로세스 인데 우선 순위도가 낫다면 다시 미뤄버림
// 힌트로 클래스를 만들어서 해보라고 하던데 연습 해볼겸 해보자! 전에 위치가 중요하기 떄문에
// 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고, 우선순위가 [2, 1, 3, 2]라면 [C, D, A, B]
// 일단 배열에서 max 값을 찾게해야되나? 아니면 que에서 max 값을 찾게 해야되나?

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Document> q = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Document(i, priorities[i]));
        }
        while (!q.isEmpty()) {
            Document current = q.poll();
            boolean hasHigherPriority = false;
            for (Document doc : q) {
                if (doc.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }
            if (hasHigherPriority) {
                q.offer(current);
            } else {
                answer++;
                if (current.idx == location) {
                    return answer;
                }
            }
        }
        return answer;
    }
}
class Document {
    int idx;
    int priority;

    public Document(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}
