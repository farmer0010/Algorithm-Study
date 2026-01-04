package Day14;

import java.util.LinkedList;
import java.util.List;

class MockExam {
    public int[] solution(int[] answers) {
        // 1. 패턴 정의
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};

        int score1 = 0;
        int score2 = 0;
        int score3 = 0;

        // 2. 패턴에 따른 점수 누적
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern1[i % pattern1.length]) {
                score1++;
            }
            if(answers[i] == pattern2[i % pattern2.length]) {
                score2++;
            }
            if(answers[i] == pattern3[i % pattern3.length]) {
                score3++;
            }
        }

        // 최고점수를 통한 판별
        int maxScore = Math.max(score1, Math.max(score2, score3));
        List<Integer> list1 = new LinkedList<>();
        if(maxScore == score1) {
            list1.add(1);
        }
        if(maxScore == score2) {
            list1.add(2);
        }
        if(maxScore == score3) {
            list1.add(3);
        }


        int[] answer = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            answer[i] = list1.get(i);
        }
        return answer;
    }
}