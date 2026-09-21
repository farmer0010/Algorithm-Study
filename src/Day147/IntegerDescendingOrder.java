package Day147;

// 정수 내림차순으로 배치하기

import java.util.*;

class IntegerDescendingOrder {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Long> list = new ArrayList<>();

        while(n > 0){
            long k = n % 10;
            n /= 10;
            list.add(k);
        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }

        answer = Long.parseLong(sb.toString());

        return answer;
    }
}
