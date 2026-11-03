package Day161;

// 캐시

// 지도에서 도시 이름을 검색하면 해당 도시와 관련된 게시물들을
// 데이터베이스에서 읽어오는 시스템 개발

// db 캐시를 적용할 때 캐시 크기에 따른 실행 시간 측정 프로그램 작성

// 조건이
// 캐시 교체 알고리즘은 lru로 사용하는데 가장 오래된게 먼저 나가려면 큐를 써야되지않나?
// 원래 큐는 먼저 들어온게 먼저 나가는건데 저 위에 문장을 아래의 의미로 해석이 가능하다고 생각함

import java.util.*;

class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> q = new LinkedList<>();

        for(int i = 0;  i < cities.length; i++){
            String s = cities[i].toUpperCase();

            if(!q.isEmpty() && q.contains(s)){
                answer += 1;
                q.remove(s);
                q.offer(s);
            }
            else{
                answer += 5;
                if(q.size() == cacheSize){
                    q.poll();
                }
                if(cacheSize != 0){
                    q.offer(s);
                }
            }
        }

        return answer;
    }
}
