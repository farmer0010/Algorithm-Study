package Day168;

// 순위 검색

// 지원서에 맞게 그 조건에 맞는 인원이 몇명 존재하는지에 대하여
// 구해야함
// 개발언어, 지원직구, 지원경력, 선호하는 음식 (안에 있는 것중 각 하나를 선택 해야함)
// 그것에 대해서 구해야할 것은 쿼리문에 담겨있음

// - 표시는 해당 조건을 고려하지않겠다라는 의미
// info는 공백문자 하나로 구분 됨
// 정확성 과 효율성을 같이 보니 단순 반복문으로는 어렵다라는걸을 인지

import java.util.*;

class RankSearch {
    HashMap<String, ArrayList<Integer>> info_map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] info_p = info[i].split(" ");
            int score = Integer.parseInt(info_p[4]);

            dfs_info("", 0, info_p, score);
        }

        for (ArrayList<Integer> list : info_map.values()) {
            Collections.sort(list);
        }

        for (int i = 0; i < query.length; i++) {
            String str = query[i].replace(" and", "");

            int last = str.lastIndexOf(" ");
            String s = str.substring(0, last + 1);
            int score = Integer.parseInt(str.substring(last + 1));

            if (info_map.containsKey(s)) {
                ArrayList<Integer> lst = info_map.get(s);
                answer[i] = lst.size() - lowerBound(lst, score);
            }
        }

        return answer;
    }

    public void dfs_info(String s, int count, String[] info_f, int score) {
        if (count == info_f.length - 1) {
            info_map.computeIfAbsent(s, (k) -> new ArrayList<>()).add(score);
            return;
        }

        dfs_info(s + info_f[count] + " ", count + 1, info_f, score);
        dfs_info(s + "-" + " ", count + 1, info_f, score);
    }

    private int lowerBound(ArrayList<Integer> list, int score) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < score) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
