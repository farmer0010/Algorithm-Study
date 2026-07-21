package Day116;

// 주차 요금 계산

// 주차장의 요금표와 차량이 들어오고 나간 기록이
// 주어졌을때 주차 요금을 계산하려고함
// fees[0] : 기본시간
// fees[1] : 기본 요금
// fees[2] : 단위 시간
// fees[3] : 단위 요금

// 입출차 기록 (한 배열에 들어있기 떄문에 아래와 같이 쪼개야함)
// records[0]: 시각 (시 : 분)
// records[1] : 차량번호
// record[2] : 입출차 내역

// 차량이 입차 된 후에 출차된 내역이 없다면
// 23:59에 출차 된 것으로 간주함
// 누적 주차 시간이 기본 시간 이하라면 기본 요금을 청구함
// 누적 추차시간 : 기본 요금  + (단위시간 * 단위 분)
// 초과한 단위시간은 올림 처리
// 차량 번호가 작은 자동차부터 차례대로 정수 배열로 정렬 필요

// 샌드박스
// 1. 입차기록과 출차기록을 따로 맵으로 분리하여 맵을 두개로
// 만듬 키 값은 차량 번호, 벨류 값은 시간으로 관리 하는데
// 합산합 분으로 처리를 해야할 것같아서 String Integer

// 1차본의 문제 : 입 출차 두개를 쪼개서 했는데 같은 차가 여러번
// 들어갔단 나가면 덮어씌어져 버리기떄문에 시간을 관리하는 맵과
// 입차를 관리하는 맵으로 구별

import java.util.HashMap;
import java.util.TreeMap;

class ParkingFee {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> inMap = new HashMap<>();
        TreeMap<String, Integer> totalTimeMap = new TreeMap<>();

        for (String record : records) {
            String[] timeRecord = record.split(" ");
            String time[] = timeRecord[0].split(":");
            int totalTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            String carNum = timeRecord[1];
            String status = timeRecord[2];

            if(status.equals("IN")){
                inMap.put(carNum, totalTime);
            }
            else if(status.equals("OUT")){
                // remove 함수는 삭제하는 것과 동시에 value 값도
                // 반환함을 인지
                 int inTime = inMap.remove(carNum);
                 int useTime = totalTime - inTime;
                 totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + useTime);
            }
        }

        for(String carNum : inMap.keySet()){
            int inTime = inMap.get(carNum);
            int useTime = ((23 * 60) + 59) - inTime;
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + useTime);
        }

        int[] answer = new int[totalTimeMap.size()];
        int idx = 0;

        for (Integer time : totalTimeMap.values()) {
            int totalFee =  fees[1];

            if(time > fees[0]){
                int extraTime = time - fees[0];
                int extraFee =  ((int)Math.ceil((double) extraTime / fees[2])) * fees[3];
                totalFee +=  extraFee;
            }
            answer[idx++] = totalFee;

        }

        return answer;
    }
}
