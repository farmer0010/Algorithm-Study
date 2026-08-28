package Day137;

// 순위 검색

// 지원서 작성시 아래와 같이 4가지 항목을 선택해야함

// 참여 개발언어, 지원직군, 지원 경력 여부, 선호하는 소울 푸드 (추가적으로 코테 점수가 적혀있음)
// 지원자 들에게 지원 조건을 선택하면 해당 조건에 맞는 지원자가 몇명인지
// 쉽게 알수있는 프로그램을 제작

// 쿼리문에서 - 표시는 해당 조건을 고려하지않겠다는 의미

// 샌드박스
// 1. 일단 저 info 배열 먼저 파싱해서 형태로 쪼개주는게 제일 우선 작업
// 2. 마찬가지로 query 배열도 작업을 해주는데
// 3. 어떻게 매핑 시킬지 거기에서 고민 하는 단계가 필요할 듯함

// 효율성도 챙겨야하다보니 특정 자료구조가 나와야할수도 있을텐데
// 이거는 파싱 단계를 진행하면 고민을 해봐야할듯함

import java.util.*;

class RankSearch {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < info.length; i++){
            String[] info_list = info[i].split(" ");

            int score = Integer.parseInt(info_list[4]);

            make_key(info_list, 0, "", score, map);
        }

        for(List<Integer> lst : map.values()){
            Collections.sort(lst);
        }

        for(int i = 0; i < query.length; i++){
            String[] str = query[i].split(" and ");
            String[] str_sp = str[str.length -1].split(" ");

            String key = String.join(" ", str[0], str[1], str[2], str_sp[0]);
            int score = Integer.parseInt(str_sp[1]);

            List<Integer> scores = map.getOrDefault(key, new ArrayList<>());
            answer[i] = two_search(scores, score);
        }

        return answer;
    }

    private int two_search(List<Integer> list, int set_score){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) < set_score){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }

        return list.size() - left;
    }

    public void make_key(String[] info_list, int depth, String cur, int score, Map<String, List<Integer>> map){

        if(depth == 4){
            String cur_trim = cur.trim();
            map.computeIfAbsent(cur_trim, k -> new ArrayList<>()).add(score);
            return ;
        }
        else{
            make_key(info_list, depth + 1, cur + info_list[depth] + " ", score, map);
            make_key(info_list, depth + 1, cur + "- ", score, map);
        }


    }
}
