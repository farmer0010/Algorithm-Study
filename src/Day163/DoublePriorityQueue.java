package Day163;

// 이중 우선 순위 큐

// 명령어
// 1.ㅣ 숫자 -> 큐에 주어진 숫자를 삽입
// 2. D 1 큐에서 최대값 삭제
// 3. D -1 큐에서 최솟 값 삭제

// 이 큐가 모든 연산을 처리한 후 큐가 비어있으면 최대값, 최솟 값을 리턴하도록
// 함수를 구현

// 빈큐에 데이터를 삭제하라는 연산이 있는 경우 해당 연산은 무시
// 일단 항상 최소와 최대를 가지고 놀아야하는데 그러기엔 하나의 큐에서 두개의 정렬이
// 어려움 그렇기 때문에 오름차순 큐와 내림차순 큐 2개를 만들고 거기에서 가지고 놀아야함

import java.util.*;

class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for(int i = 0; i < operations.length; i++){
            String cmds[] = operations[i].split(" ");

            String cmd = cmds[0];
            int num = Integer.valueOf(cmds[1]);

            if(cmd.equals("I")){
                maxPq.offer(num);
                minPq.offer(num);
            }
            else {
                if(num == 1){
                    if(maxPq.isEmpty() || minPq.isEmpty())
                        continue;
                    int n = maxPq.poll();
                    minPq.remove(n);
                }
                else if(num == -1){
                    if(maxPq.isEmpty() || minPq.isEmpty())
                        continue;
                    int n = minPq.poll();
                    maxPq.remove(n);
                }
            }
        }

        if(maxPq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;

            return answer;
        }

        ArrayList<Integer> lst = new ArrayList<>();
        int size = maxPq.size();

        for(int i = 0; i < size; i++){
            int n = maxPq.poll();

            lst.add(n);
        }

        answer[0] = lst.get(0);
        answer[1] = lst.get(lst.size()-1);


        return answer;
    }
}
