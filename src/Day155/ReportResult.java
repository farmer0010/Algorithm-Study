package Day155;

// 게시판 불량 이용자를 신고하고 처리결과를 메일로 발송하는 시스템 개발
// 규칙
// 각 유저는 한번에 한명의 유저만 신고가능
// - 신고 횟수 제한 x, 서로 다른 유저를 계속해서 신고가능
// - 한 유저를 여러번 신고 할 수있지만 동일한 유저에 대한 신고 횟수는
// 1회로 처리 (set 이나 map 필요할수도)
// 각 유저별로 신고 당한 횟수는 map으로 생각하면 될것같음

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, List<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();

        for(int i = 0; i < report.length; i++){
            set.add(report[i]);
        }

        for(String s : set){
            String arr[] = s.split(" ");

            reportMap.computeIfAbsent(arr[0], a -> new ArrayList<>()).add(arr[1]);

            countMap.put(arr[1], countMap.getOrDefault(arr[1], 0) +1 );
        }

        int[] answer = new int[id_list.length];

        for(int i = 0; i < id_list.length; i++){
            if(reportMap.containsKey(id_list[i])){
                List<String> lst = reportMap.get(id_list[i]);

                for(String s : lst){
                    if(countMap.get(s) >= k){
                        answer[i] += 1;
                    }
                }
            }
        }

        return answer;
    }
}
