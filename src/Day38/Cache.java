package Day38;

// 캐시
// 도시이름 검색 -> 맛집 게시물을 보여줌
// db에서 게시물을 가져오는 과정에서 실행시간이 오래걸림
// 해결 : db 캐시를 적용하여 성능 개선
// 하지만 캐시 크기를 얼마로 해야 효율적일까?가 해결과제
// LRU 알고리즘이 뭘까? 처음 들어봄
// 임시 저장소가 꽉 찼는데 새로운 도시를 넣어야한다면
// 가장 오랫동안 검색안한 도시를 쫒아내고 새 도시를 주입
// -> 내가 이해한걸로는 가장 안쓰는 오래된 데이터는 지우고
// 새로운 데이터를 주입하는 방식?
// cash hit 일 경우 실행시간 1초 , cash miss 일경우 5초

// 샌드박스
// 1. 넣었다 뺐다 순서를 관리하기 위해서는 리스트나 큐를
// 써야하는데 큐가 속도가 여기에서 더 빠르지 않을까?
// 어레이 데큐? 생각하면 좋을듯
// -> 교정: 큐는 맨앞 뒤에서는 빠르지만 중간을 처리하기가 힘듬
// 그래서 링크는 리스트나 어레이 리스트를 활용해볼것
// 2. 대문자로 문자열을 다 바꿔야될듯?
// 3. 저장소에 있다면 리스트에 그 도시를 지우고 다시 리스트에 넣음
// 없는데 꽉차 있다면 위에 논리에 맞게 제일 앞을 지우고 새 도시를 리스트에 넣음?
// 4. 캐시 사이즈가 0이라면 모든 시티즌 길이 *5 로 종료?

import java.util.ArrayList;
import java.util.List;

class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        List<String> cache = new ArrayList<String>();
        for (String city : cities) {
            city = city.toUpperCase();
            if (cache.contains(city)) {
                cache.remove(city);
                answer += 1;
                cache.add(city);
            }
            else{
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}
