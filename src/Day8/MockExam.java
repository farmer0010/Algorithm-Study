package Day8;

// 완전 탐색
// 배열 answer : 정답이 들은 답안지
// 가장 많은 문제를 맞춘 사람이 누구인지?
// 일단 배열에 패턴을 파악해서 먼저 넣어주기

import java.util.ArrayList;

class MockExam {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};

        int score1 = 0;
        int score2 = 0;
        int score3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern1[i % pattern1.length]) {
                score1++;
            }
        }
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern2[i % pattern2.length]) {
                score2++;
            }
        }
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern3[i % pattern3.length]) {
                score3++;
            }
        }
        int maxScore = Math.max(score1, Math.max(score2, score3));
        ArrayList<Integer> list1 = new ArrayList<>();
        if (maxScore == score1) {
            list1.add(1);
        }
        if (maxScore == score2) {
            list1.add(2);
        }
        if (maxScore == score3) {
            list1.add(3);
        }

        int[] answer = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            answer[i] = list1.get(i);
        }
        return answer;
    }
}
