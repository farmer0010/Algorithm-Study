package Day124;

// 호텔 대실

// 최소한의 객실만을 사용하여 예약 손님을 받으려고함
// 한번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고
// 다음 손님이 이용 가능함

// 예약시간이 문자열 형태로 담기 북타임 배열이 주어질 때 
// 필요한 최소 객실을 리턴해라

// 샌드박스
// 1. 대실 시작 시간과, 대실 종료시간을 파싱해야됨
// 2. 그리고 우선 순위 큐를 활용하여 시작 시간을 기준으로 정렬하고 
// 나는 클래스 노드를 만들어 시작 시간과 종료시간 계산한 값을 넣어둘꺼임 
// 3. 그리고 조건문을 통해서 종료시간 + 10분한게 다음 큐의 시작 시간보다 작다면
// 시작해도 이상 없는거니깐 진행하고 그렇지않다면 방의 개수를 늘린다

import java.util.*;

class HotelReservation {
    class Reserve implements Comparable<Reserve> {
        int start_time;
        int end_time;

        public Reserve(int start_time, int end_time){
            this.start_time = start_time;
            this.end_time = end_time;
        }

        @Override
        public int compareTo(Reserve o){
            return this.start_time - o.start_time;
        }

    }

    public int solution(String[][] book_time) {
        int answer = 0;

        List<Reserve> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < book_time.length; i++){
            int start_t = parse_time(book_time[i][0]);
            int end_t = parse_time(book_time[i][1]) + 10;
            list.add(new Reserve(start_t, end_t));
        }
        Collections.sort(list);

        for(Reserve r : list){
            pq.offer(r.end_time);
            if(! pq.isEmpty() && r.start_time >= pq.peek()){
                pq.poll();
            }
        }

        return pq.size();
    }

    public int parse_time(String s){
        String[] parse = s.split(":");
        int hour = Integer.parseInt(parse[0]);
        int min = Integer.parseInt(parse[1]);

        int total_min = (hour * 60) + min;

        return total_min;
    }
}