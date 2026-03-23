package Day50;

// 프렌즈 4블록

// 같은 모양의 카카오프렌즈 블록이
// 2*2 형태로 4개가 붙어있는 경우 사라지면서
// 점수를 얻는게임

// 같은 블록은 여러 2*2에 포함 될수있으며
// 지워지는 조건에 만족하는 2*2 모양이 여러개있다면
// 한꺼번에 지워진다

// 블록이 지워진 후에 위에 있는 브록이 아래로 떨어져
// 빈공간을 채우게 되고 만약 빈공간을 채운후에
// 다시 2*2 형태의 브록이 모이며 다시 지워지고
// 떨어지고를 반복한다

// 리턴값: 블록의 첫 배치가 주어졌을때 지워지는
// 블록은 모두 몇개인지 판단하는 프로그램 제작
// 판의 높이 m , 판의 폭 n, 판의 배치정보가 주어진
// 배열이 주어짐
// 라이언 r, 무지 m, 어피치 a, 프로도 f, 네오 n
// 튜브 t, 제이지 j, 콘 c

// 동시 폭발로직 : 일단 2*2의 형태가 있다면 근처를
// 탐색하며 그것이 있는지 확인하고 둘다 지우게 하는 로직
// 찜을 어떻게 할지는 잘 모르겠음

// 중력 로직: 위에서 아래로 이동 시켜야할것같고 문자를
// 만나기전까지 끌어내리는건 어떻게 할지 짐작이 잘안가는 느낌
// 이란 샌드박스 힌트에 맞게 더 고민해봐야할듯

// 일단 처음에 동일한 판을 만들어두기
// 이제 무한루프로 끝까지 탐색한후에 터질 부분에 대한
// 갯수를 체크 해주고 원래 본판은 그 부분 지워주기
// 그리고 다시 처음부터 끝까지 탐색하며 문자 부분만
// 다시 큐 형태로 판에 넣어주기
// 더 이상 없다면 리턴하고 종료?

import java.util.LinkedList;
import java.util.Queue;

class Friends4Block {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        while(true)
        {
            boolean[][] visited = new boolean[m][n];
            boolean isPang = false;

            for (int i = 0; i < m -1; i++) {
                for (int j = 0; j < n-1; j++) {
                    char ch = map[i][j];

                    if(ch == '-')
                        continue;
                    if(ch == map[i+1][j] && ch == map[i+1][j+1] && ch == map[i][j+1])
                    {
                        visited[i][j] = true;
                        visited[i+1][j+1] = true;
                        visited[i+1][j] = true;
                        visited[i][j+1] = true;
                        isPang = true;
                    }
                }
            }
            if(isPang == false)
                break;
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                    if(visited[k][l] == true)
                    {
                        answer++;
                        map[k][l] = '-';
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                Queue<Character> q = new LinkedList<>();
                for (int j = m-1; j >= 0; j--) {
                    if(map[j][i] != '-')
                        q.add(map[j][i]);
                }
                for(int j = m-1; j >= 0; j--) {
                    if(!q.isEmpty())
                    {
                        map[j][i] = q.poll();
                    }
                    else
                        map[j][i] = '-';
                }
            }
        }

        return answer;
    }
}
