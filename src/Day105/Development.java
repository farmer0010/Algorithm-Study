package Day105;

// 기능 개발

// 각 기능은 진도가 100% 일 때 서비스에 반영할 수있음
// 각 기능의 개발 속도는 모두 다르기떄문에 뒤에 있는 기능이
// 앞에 있는 기능보다 먼저 개발 될 수도 있고 이 때 뒤에 있는
// 기능은 앞에 있는 기능이 배포 될때 함께 배포됨

// 먼저 배포되어야하는 순서대로 작업의 진도가 적힌 정수 배열
// progress 배열과 각 작업 개발 속도가 적힌 정수 배열 speed가
// 주어 질떄 각 배포마다 몇개의 기능이 배포되는지를 return 하도록
// 함수를 작성하세요

// 샌드박스
// 1. 큐 사용하여 얘네를 관리해야할듯하고
// 2. 주어진 배열 2개를 가지고 걸리는 일수를 통해 계산해 관리해야됨
// 3. 그리고 이 일수를 스택에 다 넣어두고 peek()를 통해서
// 다음에서 스택에서 나와야하는 숫자가 작다면 같이 꺼내서 카운팅 올리고
// 크다면 냅두는식으로 반복문을 돌려야할듯?

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Development {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int days =  (int)Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.offer(days);
        }

        while (!queue.isEmpty()) {
            int days = queue.poll();
            int count = 1;

            while (!queue.isEmpty() && queue.peek() <= days) {
                queue.poll();
                count++;
            }
            list.add(count);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
