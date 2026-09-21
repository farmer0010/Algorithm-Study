package Day147;

// 길이가 같은 배열 a,b 두개가 있고, 각 배열은 자연수로 이루어짐
// 1. 배열 A,B에서 각각 한개의 숫자를 뽑아 곱함
// 2. 이러한 과정을 배열 길이 만큼 반복
// 3. 두수를 곱한 곳을 누적

// 샌드박스
// 1. 그리디로 풀어야함
// 2. 우선 순위 큐를 통해 하나는 가장 낮은거부터 뽑아오는
// 3. 하나는 가장 높은 거부터 뽑아오는 2개의 큐를 뽑아옴

import java.util.Collections;
import java.util.PriorityQueue;

class MinProductSum
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        PriorityQueue<Integer> letterPq = new PriorityQueue<>();
        PriorityQueue<Integer> upperPq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < A.length; i++){
            upperPq.offer(A[i]);
            letterPq.offer(B[i]);
        }

        while(!upperPq.isEmpty() && !letterPq.isEmpty()){
            int curMax = upperPq.poll();
            int curMin = letterPq.poll();

            answer += (curMax * curMin);
        }

        return answer;
    }
}
