package Day153;

// 주차장 요금표와 차량이 들어오고 나간 기록이 주어졌을 때 차량별로 주차요금을 계산하려고함

// fee는 기본 요금표 (기본시간, 기본 요금, 단위시간, 단위 요금)
// records는 자동차별 주차요금 (시간 차량번호 내역) -> 공백으로 구별됨
// 만약 들어왔지만 나가지 않은 경우는 23:59로 출차 시간을 계산
// 차량 번호가 작은 자동차부터 청구할 주차요금을 차례대로 정수배열에 담아서 리턴

// 샌드박스
// 1. 일단 저 records를 파싱 먼저해야할 필요가 있는데 일단
// 차량 번호와 입차시간을 저장할 맵이 필요하고 차량번호와 출차시간을 저장할 맵으로 잡아야할지 아니면
// 차량번호와 요금을 저장할 그걸로 해야할지가 감이 좀 덜오는 상태
// 원래는 출차 시간을 넣으려고했으나 out이 나왔을때 그냥 시간 계산하는 식으로 해야할듯
// 순서 유지가 어려움

import java.util.HashMap;
import java.util.TreeMap;

class ParkingFee {
    public int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> inMap = new HashMap<>();
        TreeMap<String, Integer> outMap = new TreeMap<>();

        for(int i = 0; i < records.length; i++){
            String[] record = records[i].split(" ");

            String[] times = record[0].split(":");

            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);

            String carNum = record[1];
            String status = record[2];
            int time = (hour * 60) + min;

            if(status.equals("IN")){
                inMap.put(carNum, time);
            }
            else{
                if(inMap.containsKey(carNum)){
                    outMap.put(carNum, outMap.getOrDefault(carNum, 0) + (time - inMap.get(carNum)));
                    inMap.remove(carNum);
                }
            }
        }

        for(String carNum : inMap.keySet()){
            int t = (23 * 60) + 59 - inMap.get(carNum);
            outMap.put(carNum, outMap.getOrDefault(carNum, 0) + t);
        }

        int[] answer = new int[outMap.size()];

        int index = 0;

        for(int t : outMap.values()){
            if(t <= fees[0]){
                answer[index] = fees[1];
            }
            else{
                answer[index] = fees[1] + (int)Math.ceil((double)(t - fees[0]) / fees[2]) * fees[3];
            }
            index++;
        }

        return answer;
    }
}
