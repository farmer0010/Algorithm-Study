package Day53;

// 신고결과 받기
// 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송

// 각 유저는 한번에 한명 유저만 신고할 수 있음
// 1. 신고 회수는 제한 x, 서로 다른 유저를 계속해서 신고
// 2. 한 유저를 여러번 신고할수 도있지만, 동일한 유저에
// 대해서는 횟수는 1회로 처리 (아마 hashset?)을 써야될것같음
// k번 이상 신고된 유저는 게시판 이용 정지
// 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송

// 이용자 id가 담긴 문자열 배열 id_list
// 이용자가 신고한 이용자의 id정보가 담긴 문자열 배열
// report
// 신고횟수 k
// 리턴값은 각 사용자마다 신고 받은 횟수?

// 샌드박스
// gemini 힌트에 따르면 누가 몇번 신고 당했는지
// 이사람이 누구누구를 신고했는지? 생각이 필요할듯?

// 로직 생각
// 일단 리포트를 set으로 정리해서 중복정리?
// 중복 정리 이후에? 뭘 할지 일단 코드 짜고 생각
// 2. hashMap을 통해서 사용자 이름과 set에 들어있는
// 신고자 이름? 과 매칭 시키고 k가 넘는다면 배열의
// 값을 넣어야할듯한데

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 내가 누구누구를 신고했나
        Map<String, Set<String>> reportMap = new HashMap<>();
        // 이 사람이 총 몇번 신고 당했나?
        Map<String, Integer> reportCountMap = new HashMap<>();

        for (String s : id_list) {
            reportMap.put(s, new HashSet<>());
            reportCountMap.put(s, 0);
        }

        Set<String> reportSet = new HashSet<>();
        for (String s : report) {
            reportSet.add(s);
        }

        for (String s : reportSet) {
            String[] split = s.split(" ");
            String reporter = split[0];
            String reported = split[1];

            reportMap.get(reporter).add(reported);
            reportCountMap.put(reported, reportCountMap.get(reported) + 1);
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String me = id_list[i];
            int mainCount = 0;
            Set<String> reporters = reportMap.get(me);
            for (String s : reporters) {
                if(reportCountMap.get(s) >= k)
                    mainCount++;
            }

            answer[i] = mainCount;
        }
        return answer;
    }
}
