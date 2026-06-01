package Day91;

// 이중 우선 순위 큐

// | 숫자 -> 큐에 주어진 숫자를 삽입한다.
// D 1 -> 큐에서 최대값을 삭제한다.
// D -1 -> 큐에서 최솟값을 삭제한다.

// 이중에 우선순위 큐가 할 연산 operations
// 매개변수로 주어질 때 모든 연산을 처리한후 비어있으면
// [0,0] 아니면 최대값 최소값을 리턴하는 함수를 구현해라

// 우선 순위 큐가 필요할 것같은데
// 일단 첫번째로 필요한게 저 배열이 어떤 명령어인지 처리할수 있는
// 파싱 부분이 필요할 것같고
// | 숫자 이면 큐에 넣어주는 작업이 필요할 것같고
// D 1이면 최대값을 삭제해주고 D -1이면 최솟값을 삭제하는 분기
// 작업이 필요할 것같음
// 그리고 이 작업이 끝난 이후 최대값과 최솟값을 뺴주는 작업 하면 될것같고

// gemini가 알려준 최소 큐와 최대 큐가 필요한듯?

import java.util.Collections;
import java.util.PriorityQueue;

class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for (String op : operations) {
            String[] split = op.split(" ");
            String cmd = split[0];
            int value =  Integer.parseInt(split[1]);

            if (cmd.equals("I")) {
                maxPq.offer(value);
                minPq.offer(value);
            }
            else if (cmd.equals("D")) {
                if(minPq.isEmpty() || maxPq.isEmpty())
                    continue;
                if(value == 1){
                    minPq.remove(maxPq.poll());
                }
                else if(value == -1){
                    maxPq.remove(minPq.poll());
                }
            }
        }
        if(minPq.isEmpty())
            return new int[]{0,0};
        else{
            return new int[]{maxPq.poll(),minPq.poll()};
        }
    }
}
