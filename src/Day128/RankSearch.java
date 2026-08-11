package Day128;

// 순위 검색

// 지원자가 지원서에 입력한 4가지 정보와 획득한 코딩 테스트 점수를 하나의 문자열로
// 구성한 값의 배열 info
// 개발팀이 궁금해하는 문의 조건이 문자열 형태로 담긴 query가 매개변수로 주어질 때
// 각 문의 조건에 해당하는 사람들의 숫자를 순서대로 배열에 담아 리턴

// info 배열은 개발언어, 직군, 경력, 소울푸드, 점수 형식임
// query의 각 문자열은  개발언어 and 직군 and 경력 and 소울푸드 형식의 문자열이고
// - 표시는 해당 조건은 고려하지않는다이다

// 샌드박스
// 1. 일단 info를 정리한 표를 만들어야할 것같음
// 그래야 조건이 들어왔을때 따지기 쉬울 것같아서
// 2. 표를 만들고 나면 query도 표를 만들어야할 것같음
// 근데 - 표시를 어떻게 처리해야할지 고민 해보면 좋을듯함

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];
        HashMap<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < info.length; i++){
            String str[] = info[i].split(" ");
            makeKeys(map, str, 0, "", Integer.parseInt(str[4]));
        }

        for(List<Integer> arr : map.values()){
            Collections.sort(arr);
        }

        for(int i = 0; i < query.length; i++){
            String str = query[i].replace(" and", "");

            String[] str_info = str.split(" ");
            String query_str = str_info[0] + " " + str_info[1] + " " + str_info[2] + " " + str_info[3];

            int target = Integer.parseInt(str_info[4]);
            answer[i] = count(map.getOrDefault(query_str, new ArrayList<>()), target);
        }



        return answer;
    }

    private void makeKeys(Map<String, List<Integer>> map,String[] str, int index, String current, int score)
    {
        if(index == 4){
            map.computeIfAbsent(current, k -> new ArrayList<>()).add(score);
            return;
        }
        if(index == 0){
            makeKeys(map,str, index + 1, current + str[index], score);
            makeKeys(map, str, index + 1, current + "-", score);
        }
        else{
            makeKeys(map, str, index + 1, current + " " +str[index], score);
            makeKeys(map,str, index + 1, current +" "+ "-", score);
        }
    }

    private int count(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) >= target){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return list.size() - left;
    }
}
