package Day162;

// 기능 개발

// 각 기능은 진도가 100% 일때 서비스에 반영됨
// 각 기능의 개발 속도는 모두 다르기 떄문에
// 기능이 앞에 있는 기능 보다 먼저 개발 될수도 있고, 이 때 뒤에 있는 기능은 배포될때 함
// 꼐 배포됨

// 먼저 배포 되어야하는 순서대로 적힌 배열과, 각 작업 속도가 적힌 정수
// 배열이 주어질떄 각 배포마다 몇개의 기능이 배포되는지를 리턴

// 샌드박스
// 1. 일단 작업일수를 미리 계산하고
// 2. 스택을 쓰는데 while문이 관건이지않을까라는 생각?
// -> 교정: 스택으로 헀을떄 이점이 없음, 작성해보니 카운트 재는간에 어려움
// 큐를 통한 조정으로 변경
// 3. 이걸 리스트에 넣은 다음 answer로 옮기는 방식으로 처리해야할듯함

import java.util.*;

class FeatureDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {

        int[] work = new int[progresses.length];

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> lst = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++){
            int day = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            work[i] = day;
        }

        for(int i = 0; i < work.length; i++){
            if(!q.isEmpty() && q.peek() < work[i]){
                lst.add(q.size());
                q.clear();
            }
            q.offer(work[i]);
        }

        if(!q.isEmpty()){
            lst.add(q.size());
        }

        int[] answer = new int[lst.size()];

        for(int i = 0; i < lst.size(); i++){
            answer[i] = lst.get(i);
        }

        return answer;
    }
}
