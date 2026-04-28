package Day79;

// 과제 진행하기

// 과제를 받은 루는 다음과 같은 순서대로 과제를 진행하려고함

// 1. 과제를 시작하기로한 시간이 되면 시작
// 2. 새로운 과제를 시작할 시간이 되었을 때에는
// 기존에 진행중이던 과제가 있다면 과제를 멈추고 새로운 과제 시작
// 3. 진행중이던 과제를 끝냈을 때 잠시 멈춘 과제가 있다면
// 멈춰둔 과제를 이어서 진행
// -> 과제를 끝낸 시간에 새로 시작해야하는 과제와 잠시 멈춰둔 과제가 있다면
// 새로 시작해야하는 과제가 우선
// 4. 멈춰둔 과제가 여러개 일경우 가장 최근에 멈춘 과제 부터 시작

// 입력: plans는 name, start(과제 시작시간), playtime(과제 걸리는 시간)

// 문제 풀이
// 느낌 상 항상 새로운 우선 순위를 찾아야함 과제 끝나는 시점에
// 그래서 우선 순위큐를 만들어주는데 기준을 뭐로 잡아야할까 애매함
// 그리고 진행 중이다가 멈춘 과제에서도 우선 순위 큐가 필요하지않을까라는 생각
// ㄴ 오해 포인트 : 가장 최근에 멈춘 과제가 아니라 가장 오래된 거 부터 시작
// 하는 줄알고 생각했는데 그러면 스택으로 처리해야지않을까?

// 일단 배열은 시간 순으로 정렬되어있지않기떄문에 일단 첫번째로 시간 순으로
// 정렬하는 과정이 필요할듯함 오름 차순으로 배치하고 작업 시키면 될듯하긴한데

import java.util.*;

class Solution_176962 {
    class Task implements Comparable<Task>{
        String name;
        int startTime;
        int remainTime;

        public Task(String name, String start, String playtime) {
            this.name = name;
            String[] split = start.split(":");
            this.startTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]) ;
            this.remainTime = Integer.parseInt(playtime);
        }

        @Override
        public int compareTo(Task o) {
            return this.startTime - o.startTime;
        }
    }
    public String[] solution(String[][] plans) {
        List<String> answerList = new ArrayList<>();
        Deque<Task> stack = new ArrayDeque<>();

        Task[] tasks = new Task[plans.length];
        for (int i = 0; i < plans.length; i++) {
            tasks[i] = new Task(plans[i][0], plans[i][1], plans[i][2]);
        }
        Arrays.sort(tasks);

        for (int i = 0; i < tasks.length-1; i++) {
            Task curr = tasks[i];
            Task next = tasks[i+1];

            int availableTime  = next.startTime - curr.startTime;
            if(curr.remainTime > availableTime){
                curr.remainTime -= availableTime;
                stack.push(curr);
            }
            else{
                answerList.add(curr.name);
                int leftTime = availableTime - curr.remainTime;
                while(!stack.isEmpty() && leftTime > 0){
                    Task p = stack.peek();
                    if(p.remainTime <= leftTime){
                        leftTime -= p.remainTime;
                        answerList.add(p.name);
                        stack.pop();
                    }
                    else{
                        p.remainTime -= leftTime;
                        leftTime = 0;
                    }
                }
            }
        }
        answerList.add(tasks[tasks.length-1].name);
        while(!stack.isEmpty()){
            answerList.add(stack.pop().name);
        }
        return answerList.toArray(new String[0]);
    }
}