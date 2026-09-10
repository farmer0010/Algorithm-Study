package Day142;

// 체육복

// 학생들의 번호는 체격순으로 매개져있음
// 바로 앞번호의 학생이나, 바로 앞번호의 학생이나 뒷번호의 학생들에게만
// 체육복을 빌릴 수있음
// 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려
// 최대한 많은 학생이 체육 수업을 들어야함

// 전체 학생의 수 n, 체육복을 도난당한 학생 lost, 여벌의 체육복 reserve
// 여벌의 체육복을 가져온 학생이 도난을 당할 수도 있음
// 이 때 이 학생이 체육복을 하나만 도난 당했다고 가정하고, 남는 체육복은 하나니깐
// 빌릴수 없음 (여분의 체육복의 사람이 도난 당한 사람에 포함되어있는지도 체크)

// 샌드박스
// 1. 일단 그 상황의 최선의 수를 생각해야되니 그리디로 풀긴 하되
// 처음에는 그 앞과 뒤 하나로 인접한 수를 우선 순위큐에 넣으면 어떨까
// 생각을 했는데 그럴 경우에는 하나를 빌려주면 다른 애한테는 못빌려주니깐
// 오히려 우선 순위 큐에서 제거가 더 어려움
// 2. 그래서 reserve 자체를 우선 순위 큐에 넣고 lost에 인접해있는지
// 그리고 answer의 시작점 n에서 lost의 길이를 뺀 만큼 부터 시작하고
// 나머지 작업들 진행하면 좋을듯함

import java.util.*;

class PhysicalEducationUniform {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        HashSet<Integer> set = new HashSet<>();
        boolean flag[] = new boolean[n+1];

        for(int i = 0; i < reserve.length; i++){
            set.add(reserve[i]);
        }

        for(int i = 0; i < lost.length; i++){
            if(!set.contains(lost[i])){
                flag[lost[i]] = true;
            }
            else{
                set.remove(lost[i]);
                answer++;
            }
        }

        // 지금 set에는 실제로 들어있는 애들만 남겨둠
        // flag는 꼭 필요한 애들만 true인 상태

        for(int i = 0; i < flag.length; i++){
            if(flag[i] == true){
                if(set.contains(i-1)){
                    answer++;
                    set.remove(i-1);
                }
                else if(set.contains(i+1)){
                    answer++;
                    set.remove(i+1);
                }
            }
        }

        return answer;
    }
}
