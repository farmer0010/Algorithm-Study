package Day130;

// 하노이 탑

// 3개의 기둥과 이 기둥의 꽂을 수 있는 크기가 다양한 원판들이 있고
// 한 기둥에 원판들이 작은것이 위에 있도록 순서대로 쌓여있음
// 게임의 목적은 다음 두 조건을 만족 시켜야함

// 조건
// 한번에 하나의 원판만 옮길 수있고
// 큰 원판이 작은 원판 위에 있어서는 안된다
// n개의 원판을 3번 원판으로 옮기는 최소로 옮기는 방법을 리턴
// 하노이의 최적의 개수는 2^n -1개인데

// 샌드박스
// 하노이는 제일 전형 적인 스택을 활용한 문제인데
// 재귀를 어떻게 활용할지 고민해봐야할듯하다

import java.util.*;

class HanoiTower {
    int[][] answer;
    ArrayList<int []> list = new ArrayList<>();
    public int[][] solution(int n) {
        answer = new int[n][n];
        int from = 1;
        int via = 2;
        int to = 3;

        hanoi(n, from, to, via);

        answer = list.toArray(new int[0][]);

        return answer;
    }
    private void hanoi(int n, int from, int to, int via){
        if(n == 1){
            list.add(new int[]{from, to});
        }
        else{
            hanoi(n-1, from, via, to);
            list.add(new int[]{from, to});
            hanoi(n-1, via, to, from);
        }
    }
}
