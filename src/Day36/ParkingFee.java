package Day36;

// 주차 시스템 만들기
// fees는 주차 요금 안내표, record는 출차기록
// Map구조에 key에 차량번호, value에 누적 시간
// 계산식 = 기본 요금 + ((누적시간 - 기본시간)/단위시간) * 단위 요금
// 주의 해야할 것
// 1. 기본시간 보다 적은 경우 기본 요금으로 산정
// 2. 입차기록은 있지만 출차 기록이 없는 경우 23:59분 출차로 산정
// 3. 차량 번호가 작은 자동차부터 청구 해야하니 순서가 중요, 정렬이 필요하지않을까?
// 4. 단위 시간으로 나누어 떨어지지않으면 올림처리 Math.ceil

// 설계시 자료구조 구체화 필요한것
// 현재 주자중 인차 : 차량 번호, 입차시간
// 누적 주차 시간 : 차량번호, 누적시간
// 시간 변환기 (05:34 라는 문자열을 처리하기 힘드니 분단위 정수로 바꾸는 함수 필요)


import java.util.*;

class ParkingFee {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, String> parkingMap = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        List<String> recordList = new ArrayList<>(timeMap.keySet());
        for (String record : records) {
            String[] parts = record.split(" ");
            String entryTime = parts[0];
            String carNumber = parts[1];
            String inAndOut = parts[2];
            if(inAndOut.equals("IN"))
            {
                parkingMap.put(carNumber, entryTime);
            } else if (inAndOut.equals("OUT")
            ) {
                String inTime = parkingMap.get(carNumber);
                int duration = getMin(entryTime) - getMin(inTime);
                timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + duration);
                parkingMap.remove(carNumber);
            }
        }
        for (String key : parkingMap.keySet()) {
            String inTime = parkingMap.get(key);
            int duration = getMin("23:59") - getMin(inTime);
            timeMap.put(key, timeMap.getOrDefault(key, 0) + duration);
        }
        recordList.addAll(timeMap.keySet());
        Collections.sort(recordList);
        answer = new int[recordList.size()];
        for (int i = 0; i < recordList.size(); i++) {
            String carNumber = recordList.get(i);
            int totalDuration = timeMap.get(carNumber);
            if(totalDuration <= fees[0])
                answer[i] = fees[1];
            else
            {
                int extraTime = (int)Math.ceil(((double) totalDuration - fees[0])/fees[2]);
                answer[i] = fees[1] + (extraTime * fees[3]);
            }
        }
        return answer;
    }
    public int getMin(String time)
    {
        String[] parts = time.split(":");
        return (Integer.parseInt(parts[0]) * 60) + Integer.parseInt(parts[1]);
    }
}
