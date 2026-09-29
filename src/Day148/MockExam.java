package Day148;

import java.util.*;

class MockExam {
    public int[] solution(int[] answers) {

        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for(int i = 0; i < answers.length; i++){
            if(person1[i % person1.length] == answers[i])
                p1++;
        }

        for(int i = 0; i < answers.length; i++){
            if(person2[i % person2.length] == answers[i])
                p2++;
        }

        for(int i = 0; i < answers.length; i++){
            if(person3[i % person3.length] == answers[i])
                p3++;
        }
        ArrayList<Integer> lst = new ArrayList<>();

        int max = Math.max(p1, Math.max(p2, p3));

        if(max == p1)
            lst.add(1);
        if(max == p2)
            lst.add(2);
        if(max == p3)
            lst.add(3);

        int[] answer = new int[lst.size()];

        for(int i = 0; i < lst.size(); i++){
            answer[i] = lst.get(i);
        }

        return answer;
    }
}
