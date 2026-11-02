package Day160;

// 베스트 엘범

// 스트리밍 사이트에서 장르별로 가장 많이 재생된 노래를 두개씩 모아 베스트 엘범을
// 출시하려고함

// 기준
// 1. 속한 노래가 많이 재생된 장르를 먼저 수록
// 2. 장르 내에서 많이 재생된 노래를 먼저 수록
// 3. 장르 내에서 재생횟수가 같은 노래중에서는 고유 번호가 낮은 노래를 수록

// 샌드박스
// 맵을 통해서 정리가 조금 필요할 것같은데 아직 문제가 이해가 잘 되지않아서 예시를 통해
// 이해 후 정리
// 장르 횟수가 우선적으로 진행되어야하고, 그다음에 스트리밍 재생수, 그리고 스트리밍 재생수도 같다면
// 고유번호가 낮은걸로 정렬이 필요하다 이말인거같은데

import java.util.*;

class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> total_map = new HashMap<>();
        HashMap<String, ArrayList<Integer>> s_map = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            total_map.put(genres[i], total_map.getOrDefault(genres[i], 0) + plays[i]);
            s_map.computeIfAbsent(genres[i], key -> new ArrayList<>()).add(i);
        }

        for(ArrayList<Integer> lst : s_map.values()){
            lst.sort((a,b) -> {
                if(plays[a] == plays[b]){
                    return a - b;
                }
                return plays[b] - plays[a];
            });
        }

        ArrayList<String> genereLst = new ArrayList<>();

        for(String s : total_map.keySet()){
            genereLst.add(s);
        }

        genereLst.sort((a,b) -> {
            return total_map.get(b).compareTo(total_map.get(a));
        });

        ArrayList<Integer> total_lst = new ArrayList<>();

        for(int i = 0; i < genereLst.size(); i++){
            List<Integer> t_lst = s_map.get(genereLst.get(i));

            for(int k = 0; k < 2; k++){
                if(t_lst.size() == 1){
                    total_lst.add(t_lst.get(k));
                    break;
                }
                else{
                    total_lst.add(t_lst.get(k));
                }
            }
        }

        int[] answer = new int[total_lst.size()];

        for(int i = 0; i < total_lst.size(); i++){
            answer[i] = total_lst.get(i);
        }

        return answer;
    }
}
