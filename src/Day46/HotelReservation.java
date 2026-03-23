package Day46;

// 호텔 대실
// 최소한의 객실만을 사용하여 예약 손님을 받으려고함
// 한번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소 후
// 손님을 받음
// 예약 시각이 문자열 형태로 담긴 2차월 배열 매개변수로 주어질때
// 리턴값: 최소 객실의 수
// 예약시간이 자정을 넘어가는 경우는 x

// 샌드박스
// 전처리 스케치 : 문자열 형태를 숫자형태로 변환 시키고 작업 해야할듯?
// 원래는 큐를 생각했지만 바로바로 빠르게 찾아서 연결하려면
// PriorityQueue를 써야될듯
// 손님들을 예약시간이 빠른 순서대로 배치하고
// 선택한 방에 그 수가 10이 차이가 안나면 바로 빼고
// 10이상 차이가 나면 다시 뒤로 넘기는 로직의 느낌이지않을까?

import java.util.Arrays;
import java.util.PriorityQueue;

class HotelReservation {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
             String start = book_time[i][0];
             String end = book_time[i][1];
             String[] start_times = start.split(":");
             String[] end_times = end.split(":");
             times[i][0] = Integer.parseInt(start_times[0]) * 60 + Integer.parseInt(start_times[1]);
             times[i][1] = Integer.parseInt(end_times[0]) * 60 + Integer.parseInt(end_times[1]) +10;
        }
        Arrays.sort(times, (a,b) ->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] time : times) {
            if(!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll();
            }
            pq.offer(time[1]);
        }
        return pq.size();

    }
}
