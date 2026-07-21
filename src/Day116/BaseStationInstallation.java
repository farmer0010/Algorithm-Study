package Day116;

// 기지국 설치

// n개의 아파트가 일렬로 있음
// 상황
// 지금 현재에는 일부 아파트 옥상에 4g가 설치 되어있는데
// 이것을 5g로 바꾸려고함, 하지만 5g 기지국은 4g 기지국
// 보다 전달 범위가 좁아서 이걸 교체할 경우 어떤 아파트에는
// 전파가 도달하지않을 수 있음

// 전파의 도달거리가 w일 때 아파트를 기준으로 전파를 양쪽으로
// w만큼 전달할 수있어야함

// 아파트의 개수 n, 현재 기지죽이 설치된 아파트의 번호가 담긴
// 1차원 배열 스테이션, 전파의 도달거리 w가 매개변수로 주어질
// 때 모든 아파트에 전파를 전달하기 위해 증설해야할 최소 갯수

// 샌드박스
// 1. 그림을 그려보았는데 어떤 조건이 되지않았을 때?
// 이 개수를 늘려가는 식이 다보니 전에 푼 문제와 유사함
// 근데 그조건이 뭐냐?
// 일단 시점을 설치되있는 아파트의 위치를 시점으로 하고
// 가중치를 포면 예를 들어 w가 1인데 그 옆 방향에서 1이 더있으니
// 2라는 지점보다 바깥에 있고 거기안에 기존에 설치된 기지국이 겹치지
// 않으면 설치를 해야한다?
// 이렇게 까지 생각이 들었음

// 힌트 : 전파 범위가 w일때 기지국 하나를 세우면
// 왼쪽 w칸 오른쪽 w칸 자기칸까지 해서 총전파의 길이는
// 2w+1 범위까지 커버가 가능함

class BaseStationInstallation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int pos = 1;
        int coverage = 2 * w +1;

        for (int station : stations) {
            int gap = (station - w) - pos;
            if (gap > 0) {
                answer += (int) Math.ceil((double)gap / coverage);
            }
            pos = station + w + 1;
        }
        if(pos <= n){
            int gap = n - pos + 1;
            answer += (int) Math.ceil((double)gap / coverage);
        }

        return answer;
    }
}
