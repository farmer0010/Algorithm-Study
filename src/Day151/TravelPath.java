package Day151;

// 여행경로

// 주어진 항공권 모두를 이용하여 항상 ICN 공항에서 출발한다
// 항공권 정보가 담긴 2차원 배열 ticket이 매개변수로 주어질 때
// 방문하는 경로를 담아 return

// 규칙
// 모든 공항은 3글자
// 주어진 공항의 수 최대 10000
// 주어진 항공권은 모두 사용
// 만약 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 리턴

// 얘는 조합보다는 순열에 가까운 느낌임

import java.util.*;

class TravelPath {
    boolean check[];
    ArrayList<String> lst = new ArrayList<>();
    boolean found;
    String[] answer;

    public String[] solution(String[][] tickets) {

        check = new boolean[tickets.length];

        Arrays.sort(tickets, (a,b) -> {
            return a[1].compareTo(b[1]);
        });

        lst.add("ICN");
        dfs("ICN", 0, tickets);

        return answer;
    }

    public void dfs(String city, int count, String[][] tickets){
        if(found)
            return;

        if(count == tickets.length){
            found = true;
            answer = new String[lst.size()];
            answer = lst.toArray(new String[0]);
            return ;
        }

        for(int i = 0; i < tickets.length; i++){
            if(!check[i] && city.equals(tickets[i][0])){
                check[i] = true;
                lst.add(tickets[i][1]);
                dfs(tickets[i][1], count + 1, tickets);
                check[i] = false;
                lst.remove(lst.size() -1);
            }
        }
    }
}
