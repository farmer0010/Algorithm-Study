package Day91;

// 기능 개발
// 프로그래머스 팀에서 기능 개선 작업을 수행중
// 각 기능은 진도가 100퍼일때 반영

// 각 기능 개발 속도는 모두 다르기 떄문에
// 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발 될 수 있지만
// 뒤에 있는 기능은 앞에 있는 기능이 배포 될 때 함꼐 배포되어야함

// 먼저 배포되어야하는 순서대로 작업의 진도가 적힌 숫자 progresses와
// 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 떄 각 배포마다
// 몇개의 기능이 배포되는지를 리턴하는 함수를 만들어라

// 샌드박스
// 일단 큐를 쓰기는 해야할 것같은데 어떻게 할지 아직 감은 안옴
// 근데 일단은 저렇게 배열들로만 보면 직관적이지않단 말이지?
// 그렇기 떄문에 일단 저 배열 2개를 활용하여 작업이 얼마나 걸릴지 계산 시킨
// 배열을 만들어야되나 아니면 바로 큐에 집어넣어두면 되나 고민임
// 굳이 배열 없이 큐에서 작업해도 될 것같긴한데
// 그러면 대충 얘를 들어서 7,3,9가 만들어질꺼란 말이지 그러면 두번쨰꺼가
// 잠시 작업이 먼저 끝나도 대기를 해야하잖아?

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FeatureDev {
    public int[] solution(int[] progresses, int[] speeds) {
       Queue<Integer> q = new LinkedList<>();
       List<Integer> list = new ArrayList<>();

       for(int i = 0; i < progresses.length; i++){
           int days = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
           q.offer(days);
       }

       while(!q.isEmpty()){
           int maxDays = q.poll();
           int count = 1;
           while(!q.isEmpty() && q.peek() <= maxDays){
               q.poll();
               count++;
           }
           list.add(count);
       }

        return list.stream().mapToInt(x->x).toArray();
    }
}
