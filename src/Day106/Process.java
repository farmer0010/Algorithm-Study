package Day106;

// 운영체제의 역할중 하나는 컴퓨터 시스템의 자원을
// 효율적으로 관리하는것
// 운영체제는 이러한 규칙에 따라 프로세스를 관리해야하고
// 특정 프로세스를 관리할 경우 특정 프로세스가
// 몇번 쨰로 실행되는지 알아야한다

//1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
//2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
//3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
//        3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.

// 프로세스의 중요도가 순서대로 담기 배열 properties
// 몇번째로 실행되는지 알고싶은 프로세스 위치를 알려주는 location
// 이 주어질때 해당 프로새스가 몇번째로 실행되는지 리턴

// 샌드 박스
// 여기서는 실행순서들이 어차피 저 흐름 대로 가는걸 알려주기에
// 큐를 사용하면 된다 q.peek()로 했을 때 자기보다 그게 더 크다면
// 다시 큐에 넣으면 되고 자기가 크다면 나가면 되고

import java.util.LinkedList;
import java.util.Queue;

class Process {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++){
            queue.offer(new int[]{i, priorities[i]});
        }
        int turn = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            boolean isHigher = false;
            for(int[]p : queue){
                if(p[1] > cur[1]){
                    isHigher = true;
                    break;
                }
            }
            if(isHigher){
                queue.offer(cur);
            }
            else{
                turn++;
                if(location == cur[0]){
                    return turn;
                }
            }
        }
        return turn;
    }
}
