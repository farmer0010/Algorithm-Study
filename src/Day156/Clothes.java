package Day156;

// 각 종류별로 최대 1가지 의상만 착용할 수 있음
// 하루에 최소한 한개의 의상은 입음
// 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 리턴

// 맵을 통해 옷의 종류와 그 종류에 맞는 갯수를 세는게 중요하지않나? 라고 생각하는데
// 옷의 조합의 수를 그걸로 어떻게 뽑아 낼수있을까 생각중
// 그래서 생각한게 차라리의 조합의 경우의 수를 맵으로 자체로 넣는게 어떠한가 생각중

import java.util.HashMap;

class Clothes {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> cMap = new HashMap<>();

        int answer = 1;

        for(int i = 0; i < clothes.length; i++){
            cMap.put(clothes[i][1], cMap.getOrDefault(clothes[i][1], 0) +1);
        }

        for(int k : cMap.values()){
            answer *= (k + 1);
        }

        answer -= 1;

        return answer;
    }
}
