package Day83;

// 마법의 탑에 사는 민수는 탑이 너무 높아서
// 엘리베이터를 만드려고함

// 마법의 엘리베이터 버튼에는 -1,1,-10,10,-100,100 등과 같이
// 10 ^ c 형태인 정수들이 적힌 버튼잉 ㅣㅆ음
// 이 엘리베이터는 버튼을 누르면 현재 층수에 버튼에 적힌 값을 더한
// 층으로 이동하게 됨
// 엘리베이터 현재 층과 버튼의 값을 더한 결과가 0보다 작으면 엘베는
// 움직이지않음, 이동하는데는 마법을 돌이 사용됨
// 마법의 돌을 아끼기 위해서 민수는 항상 최소한의 버튼을 눌러서 이동하려고함

// 일단 전에 풀어서 조금은 알고있지만 나머지가 0~4인 경우와 6~9까지인 경우를
// 쪼개고 5인 경우엔 몫이 5보다 작다면 버리는게 빠르고 5보다 크다면 올리는게 낫고
// 효율적인걸로 알고있긴함

class MagicalElevator {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){
            int digit = storey % 10;
            int nextDigit = (storey / 10) % 10;

            if (digit < 5){
                answer += digit;
                storey /= 10;
            }
            else if (digit > 5){
                answer += (10 - digit);
                storey = (storey / 10) + 1;
            }
            else {
                answer += 5;
                if(nextDigit < 5){
                    storey /= 10;
                }
                else {
                    storey = (storey / 10) + 1;
                }
            }
        }

        return answer;
    }
}
