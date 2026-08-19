package Day134;

// 카페 확정

// 카페에는 영업을 시작하자마자 0초에 손님이 한명이 가게에 도착하고
// 정확히 k초마다 새로운 손님 한명이 와서 줄을 섬
// 주문을 받으면 주문받은 순서대로 음료를 만듬

// 음료는 한번에 하나씩 만들고 손님은 자신이 주문한 음료를 받자마자 카페를 나감
// 각 음료들은 0번부터 차례대로 번호가 지정하고 같은 종류의 음료를 만드는데 걸리는 시간은
// 항상 동일함

// 오늘 주문 받은 음료 목록을 보며 카페에서 사람들이 동시에 최대 몇명이 머물렀는지 알고싶어함
// 주문에 걸린 시간과, 카페를 나가는 시간은 무시하고 음료 제조시간만 신경 쓰기로함
// 간단하게 생각해보자면 우리는 가장 카페에 사람들의 시간이 몰렸을떄를 찾으면 되는거임

// 샌드박스
// 처음에 큐와 스택을 생각해서 주문열과 대기 스택을 생각했는데
// 스택은 먼저온 사람을 처리하기엔 적합 하지않아 큐를 두개 만들어야겠다고 생각함

// 그리고 그림을 그려보며 떠오른 생각이 메인 큐에 일단 넣음 이제 k초마다
// 사람이 투입됨 메인 큐의 시간이 끝나지않았다면 서브큐에 계속 투입하고
// 서브 큐에다가 +1 한값을 반환하면 되지않을까 생각함

// 일단 우리가 체크해야되는게 새로운 사람이 들어오면 전에 사람의 끝나는 시간이 언제인지


class CafeExpansion {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;

        // 큐 어떻게 쓸지는 추후 생각

        int prev_end = 0;

        // 입장 시간과 종료시간 관리
        int caffee_mem[][] = new int[order.length][2];

        for(int i = 0; i < order.length; i++){
            int arr_time = i * k;
            int order_time = menu[order[i]];

            int start_time = Math.max(prev_end, arr_time);
            prev_end = start_time + order_time;

            caffee_mem[i][0] = arr_time;
            caffee_mem[i][1] = prev_end;
        }

        int arrTimes[] = new int[caffee_mem.length];
        int depTimes[] = new int[caffee_mem.length];

        for(int i = 0; i < caffee_mem.length; i++){
            arrTimes[i] = caffee_mem[i][0];
            depTimes[i] = caffee_mem[i][1];
        }

        int count = 0;
        int i = 0;
        int j = 0;

        while(i < arrTimes.length){
            if(arrTimes[i] < depTimes[j]){
                count++;
                i++;
                answer = Math.max(answer, count);
            }
            else{
                count--;
                j++;
            }
        }

        return answer;
    }
}
