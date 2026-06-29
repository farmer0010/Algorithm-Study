package Day103;

// 주차 요금 계산

// 주차장의 요금표와 차량이 들어오고 나간 기록이 주어졌을 때
// 차량별로 요금을 계산하려고함

// 요금 표
// 기본시간(분), 기본 요금(원), 단위시간(분), 단위 요금(원)
// 출차기록표
// 시각 , 차량번호(문자열), 내역 (하나의 공백으로 구분)

// 차량이 입차는 있지만 출차는 없다면 23:59분에 출차한것으로 간주
// 누적 추차시간이 기본시간 이하라면, 기본 요금을 청구
// 초과한 시간이 단위시간으로 나누어 떨어지지않으면 올림으로 처리

// 샌드박스
// 같은 차량이 하루에 두번 들어오는 경우도 생기니깐
// 맵 구조로 차량번호, 누적 시간 식으로 만들면 될것같고
// 시간을 계산해주는 함수를 하나 만들어 두면 편할듯하긴함
// 트리맵은 키를 기준으로 정렬해줌
// 누적시간을 관리하는 맵과, 입차시간을 관리하는 맵 사용


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class ParkingFee {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalMap = new TreeMap<>();
        Map<String, Integer> inTimeMap = new HashMap<String, Integer>();

        for(String record : records){
            String[] split = record.split(" ");

            int time = toMin(split[0]);
            String carNum = split[1];
            String status = split[2];

            if(status.equals("IN")){
                inTimeMap.put(carNum, time);
            }
            else {
                int intime = inTimeMap.remove(carNum);
                totalMap.put(carNum, totalMap.getOrDefault(carNum, 0) + time - intime);
            }
        }

        for(String num : inTimeMap.keySet()){
            int inTime = inTimeMap.get(num);
            int maxTime = toMin("23:59");

            totalMap.put(num, totalMap.getOrDefault(num, 0) + maxTime - inTime);
        }

        int[] answer = new int[totalMap.size()];
        int idx = 0;

        for(String num : totalMap.keySet()){
            int totalTime = totalMap.get(num);
            answer[idx++] = calculateTime(totalTime, fees);
        }
        return answer;
    }

    private int calculateTime(int totalTime, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int plusTime = fees[2];
        int plusFee = fees[3];

        if(totalTime <= baseTime){
            return baseFee;
        }
        else{
            int extraTime = totalTime - baseTime;
            int extraFee = (int)Math.ceil((double) extraTime / plusTime) * plusFee;
            return extraFee + baseFee;
        }
    }

    private int toMin(String str) {
        int totalMin = 0;
        String[] split = str.split(":");

        totalMin = (Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        return totalMin;
    }
}
