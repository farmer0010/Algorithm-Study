package Day99;

// 여행경로

// 주어진 항공권을 모두 이용하여 여행경로를 짜려고함
// 항상 "ICN" 공항에서 출발해야함

// 항공권 정보가 담기 2차원 배열 티켓이 매개 변수로 주어질 떄
// 방문하는 공항 경로를 배열에 담아 리턴하도록 하세요

// 예외처리 상황 만일 가능한 경로가 2개 이상 일경우에는 알파벳 순서가
// 앞서는 경로를 리턴해야함

// (주어진 공항의 수가 10000개 까지 가능하기떄문에 무작정 반복문은 어렵다)
// 순서를 되새겨보자면
// 1. 일단 클래스로 노드를 하나 만들어서 시작점과 생성점을 기록해주고?
// 2. 원래는 set이나 map을 통해 contains로 확인하면 검색에서 빠르지
// 않을까 생각했는데 이건 중복이 걸려져서 안됨 인자에 중복이 걸려져서
// 3. start와 end를 비교하고 end와 일치하는 start가 없을 때
// 이게 종료되어야하지않나?? 라는 생각이듬
// 4. 근데 만약에 같은 게 2개일 경우엔 조건문을 통해서 비교하여 알파벳
// 순서가 앞서는 경로를 우선적으로 하고 그 다음걸 배치하도록 넣어야됨

// 샌드박스 힌트
// 주어진 항공권을 소모하는게 우선이라는것을 생각해야해 길이 끊겼다면
// 백트래킹 하는쪽으로
// 그리고 알파벳 순서를 매번 비교하기에는 부담이 큼 그렇기에
// 배열 자체를 알파벳 순으로 정렬해서 그때부터 탐색을 하는걸로 하면
// 이 문제가 해결됨

import java.util.*;

class TravelPath {
    // map에서 인덱스의 키의 역할을 할 수있는 그걸 스트링 (시작지로 삼을 수있게 해줌)
    Map<String, List<Ticket>> map = new HashMap<>();
    // 이동 경로를 저장하기 위해서
    List<String> list = new ArrayList<>();
    String[] answer;
    boolean isFound = false;

    class Ticket{
        String start;
        String end;
        boolean isUsed;

        public Ticket(String start, String end){
            this.start = start;
            this.end = end;
        }
    }
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];

            if(!map.containsKey(start)){
                map.put(start, new ArrayList<>());
            }
            map.get(start).add(new Ticket(start, end));
        }

        list.add("ICN");
        dfs_airline("ICN", 0, tickets);

        return answer;
    }

    private void dfs_airline(String strat, int count, String[][] tickets) {
        if(isFound){
            return;
        }
        if(count == tickets.length){
            answer = list.toArray(new String[0]);
            isFound = true;
            return;
        }

        String current = strat;
        if(map.containsKey(current)){
           List<Ticket> ticketFromHere = map.get(current);
           for(Ticket ticket : ticketFromHere){
               if(!ticket.isUsed){
                   ticket.isUsed = true;
                   list.add(ticket.end);
                   dfs_airline(ticket.end, count + 1, tickets);
                   if(!isFound){
                       ticket.isUsed = false;
                       list.remove(list.size()-1);
                   }
               }
           }
        }
    }
}
