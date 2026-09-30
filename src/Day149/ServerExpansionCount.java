package Day149;

// 서버 증설 횟수

// 같은 시간대에 게임을 이용하는 사람이 m명이 늘어날떄마다 서버가 1대가 추가로 필요함
// 어느 시간대의 이용자가 m명이라면 서버 증설이 필요하지 x
// 어느 시간 대 이용자가 n * m 이거나 (n + 1) * m 명 미만이라면 최소 n대의 증설된 서버가 필요함
// 한번 증설한 서버는 k시간 동안 운영하고 그 이후는 반납됨

class ServerExpansionCount {
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 증설 횟수 기록

        int server_n = 0; // 증설 된 서버의 수
        int[] server = new int[24 + k]; // 서버 회수하기 위한 기록

        for(int i = 0; i < players.length; i++){
            int person = players[i];

            if(server[i] > 0){
                server_n -= server[i];
                server[i] = 0;
            }

            int plus = person / m;

            if(server_n < plus){
                answer += (plus - server_n);
                server[i+k] += (plus- server_n);
                server_n = plus;
            }
        }


        return answer;
    }
}
