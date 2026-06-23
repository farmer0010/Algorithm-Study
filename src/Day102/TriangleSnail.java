package Day102;

// 삼각 달팽이
// 정수 n이 매개변수로 주어지고
// 밑변의 길이와 높이가 n인 삼각형에서
// 맨위 꼭지점에서 반시계 방향으로 달팽이 채우기를
// 진행한 후, 첫 행부터 마지막 행까지 모두 순서대로 합친
// 새로운 배열을 리턴

// 샌드박스
// 이걸 배열로 나열해서 생각하면
// 방향을 세가지로 생각 할수있음
// 세로로 내려가고, 가로로 이동하고, 그 다음에 좌대각으로 올라가고
// 결국 이 3가지 경우의 수를 반복하여 저 배열이 완성되게 됨

// 그래서 일단 맵은 n * n 크기로 만들어주면 되고

class TriangleSnail {
    public int[] solution(int n) {
        int matrix[][] = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0){
                    x++;
                }
                else if(i % 3 == 1){
                    y++;
                }
                else if(i % 3 == 2){
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }
        int []answer = new int[n*(n+1)/2];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[index++] = matrix[i][j];
            }
        }
        return answer;
    }
}
