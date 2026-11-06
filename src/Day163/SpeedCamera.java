package Day163;

// 단속 카메라

// 고속 도로를 이동하는 모든 차량이 단속용 카메라를 한번은 만나도록
// 카메라를 설치하려고함

// 모든 차량이 한번은 단속용 카메라를 만나도록 하려면 최소 몇대의 카메라를
// 설치해야하는지를 리턴

// 차량 진입 / 진출 시점에 카메라가 설치되어있어도 카메라를 만난것으로 간주
// 지금은 순서가 섞여있기 떄문에 일단 정렬하는 과정이 필요할것같음
// 근데 이걸 시작 지점을 기준으로 해야할지 아니면 끝지점을 기준으로 해야할지
// 는 잘 모르겠음 검사 기준은 끝점으로 하면 되는데

import java.util.*;

class SpeedCamera {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes ,(a,b) -> {
            return a[1] - b[1];
        });

        int cam_idx = routes[0][1];

        for(int i = 1; i < routes.length; i++){
            if(cam_idx >= routes[i][0]){
                continue;
            }
            else{
                cam_idx = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
