package Day133;

// 운영 체제

// 이 운영체제는 프로그램의 우선 순위와 호출된 시각에 따라 실행 순서를 결정함
// 모든 프로그램은 1부터 10까지 점수가 매겨져있고 이 점수가 낮을수록
// 우선 순위가 높은 프로그램이다.

// 각 프로그램들은 실행시간이 정해져있으며 프로그램이 호출되면 대기 상태에 있다가
// 자신의 순서가 되면 실행 시간동안 실행된 뒤 종료됨
// 호출된 프로그램들 중 우선 순위가 가장 높은 프로그램을 먼저 실행하고
// 호출된 각 프로그램은 자신보다 우선 순위가 높은 호출된 프로그램이 모두
// 종료된 후에야 실행됨

// 단 실행중인 프로그램보다 우선 순위가 높은 프로그램이 호출 되어도 실행중이던 프로그램은
// 중단되지 않고 종료될 떄까지 계속 실행됨
// 우선 순위가 같은 경우 먼저 호출된 프로그램이 실행됨

// 모든 프로그램이 종료되는 시간과 프로그램의 점수마다 대기시간의 합을 정수 배열에 담아 리턴
// answer은 길이 11인 정수 배열

// program 정수 배열 프로그램 점수, 프로그램 호출된 시각, 실행시간

// 우선 순위 큐를 활용하여야하는데 program 정보를 가지고 node를 만드는데
// 호출된 시각이 제일 우선적이고 이 호출된 시각이 같다면 실행 점수를 가지고 비교하는
// 식으로 가져가야되지않을까라고 생각이 듬

import java.util.*;

class OperatingSystem {
    class Node implements Comparable<Node> {
        int score;
        int call_time;
        int exec_time;

        public Node(int score, int call_time, int exec_time){
            this.score = score;
            this.call_time = call_time;
            this.exec_time = exec_time;
        }

        @Override
        public int compareTo(Node o){
            if(this.score == o.score){
                return this.call_time - o.call_time;
            }
            return this.score - o.score;
        }
    }

    public long[] solution(int[][] program) {
        long[] answer = new long[11];

        int idx = 0;
        int cur_time = 0;

        Arrays.sort(program, (a,b) -> {
            return a[1] - b[1];
        });

        PriorityQueue<Node> pq = new PriorityQueue<>();

        while(!pq.isEmpty() || idx <  program.length){
            while(idx < program.length && program[idx][1] <= cur_time){
                pq.offer(new Node((program[idx][0]), program[idx][1], program[idx][2]));
                idx++;
            }

            if(pq.isEmpty()){
                cur_time = program[idx][1];
                continue;
            }

            Node cur = pq.poll();

            answer[cur.score] +=  cur_time - cur.call_time ;
            cur_time += cur.exec_time;

            answer[0] = cur_time;
        }

        return answer;
    }
}
