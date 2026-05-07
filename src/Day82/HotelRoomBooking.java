package Day82;

// 호텔을 운영중인 코니는 최소한의 객실만 사용하여
// 예약 손님을 받으려고함

// 한번 사용한 객실은 퇴실시간을 기준으로 10분간 청소하고
// 다음 손님들이 사용할 수 있어야함

// 예약 시각이 문자열 형태로 담긴 2차원 배열이 매개변수로 주어질 떄
// 코니에게 필요한 최소 객실 수를 리턴 하는 함수를 만드셈

// 일단 생각 드는게 일단 저 시간을 파싱해서 분 형태로 변환이 필요할것
// 같고 우선 순위큐를 활용해서 시작시간이 급한애들을 먼저 넣어 주되
// 그 시작시간이 종료시간 + 10분 보다 작다면 작업을 그대로 진행하고
// 그렇지 않다면 방이 하나씩 더 할당되는 부분이 있어야되지않을까라고 생각함

import java.util.Arrays;
import java.util.PriorityQueue;

class HotelRoomBooking {
    class Reserve implements Comparable<Reserve>{
        int startTime;
        int endTime;

        public Reserve(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        @Override
        public int compareTo(Reserve o) {
            return this.startTime - o.startTime;
        }
    }

    public int solution(String[][] book_time) {
        Reserve[] reserves = new Reserve[book_time.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < book_time.length; i++){
            int startTime = parseTime(book_time[i][0]);
            int endTime = parseTime(book_time[i][1]) + 10;
            reserves[i] = new Reserve(startTime, endTime);
        }
        Arrays.sort(reserves);

        for (Reserve r : reserves) {
            if(!pq.isEmpty() && pq.peek() <= r.startTime){
                pq.poll();
            }
            pq.offer(r.endTime);
        }
        return pq.size();
    }

    private int parseTime(String s) {
        String[] arr = s.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);

        int total = hour * 60 + minute;

        return total;
    }
}