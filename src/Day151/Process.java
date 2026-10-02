package Day151;

// 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우
// 특정 프로세스가 몇번쨰로 실행되는지 알아내는 것

// 1. 실행 대기 큐에 대기중인 프로세스 하나를 꺼냄
// 2. 큐에 대기중에 프로세스 중 우선 순위가 더 높은 프로세스가 있다면 다시 집어넣음
// 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행함

import java.util.*;

class Process {
    class Node{
        int p;
        int index;

        public Node(int p, int index){
            this.p = p;
            this.index = index;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++){
            q.offer(new Node(priorities[i], i));
        }

        int round = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int po = cur.p;
            int idx = cur.index;

            boolean flag = false;

            for(Node o : q){
                if(po < o.p){
                    flag = true;
                }
            }

            if(flag){
                q.offer(new Node(po, idx));
                flag = false;
            }
            else{
                round++;
                if(idx == location)
                    answer = round;
            }
        }

        return answer;
    }
}