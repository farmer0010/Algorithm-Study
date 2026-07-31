package Day122;

// 마법의 엘리베이터

// 마법의 엘리베이터 버튼
// -1 , +1, -10, +10, -100, +100등과 같이 절대값이 10^c 형태인 정수들이 적힌 버튼이 있음
// 이 버튼을 누르면 현채 층수에 버튼에 적혀있는 값을 더한층으로 이동하게 됨

// 단 엘리베이터가 위치해있는 층과 버튼 값을 더한 결과가 0보다 작으면 엘리베이트는 움직이지않음
// 최소한의 버튼으로 이동해야되고 엘리베이터의 어떤 층에서 0층으로 내려가는데 필요한 마법의 돌의 최소
// 개수를 구하시오

// 샌드박스
// 숫자가 1,2,3,4일떄는 내리는게 빠르고 6,7,8,9 일떄는 올리는게 더 빠르다 (버튼 최소화)
// 5일때 경우를 생각해보면 뒤에 나머지가 1,2,3,4,5일때는 올리는게 빠르고, 6,7,8,9일떄는 내리는게 빠름

class MagicElevator {
    public int solution(int storey) {
        int answer = 0;

        while(storey > 0){
            int mod = storey % 10;
            int next = (storey / 10) % 10;
            if(mod < 5)
            {
                answer += mod;
                storey /= 10;
            }
            else if(mod > 5)
            {
                answer += (10- mod);
                storey = (storey / 10) +1;
            }
            else{
                if(next >= 5){
                    answer += 5;
                    storey = (storey / 10) +1;
                }
                else{
                    answer += 5;
                    storey /= 10;
                }
            }
        }

        return answer;
    }
}