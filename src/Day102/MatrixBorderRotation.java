package Day102;

// 행렬 테두리 회전하기
// row * columns 크기의 행렬이 있고
// 행렬은 1부터 row * column 까지 값이 들어있음
// 행렬에서 직사각형 모양의 범위를 여러번 선택해
// 테두리 부분에 있는 숫자들을 시계 모양으로 회전하려고함

// 각 회전은 (x1,y1,x2,y2)인 정수 4개로 표현하고
// 그 의미는 x1행 y1열 부터, x2행 y2열까지의 영역에
// 해당하는 직사각형에서 테두리에 있는 숫자들을 한칸씩
// 시계 방향으로 회전함 (일단 우리가 인식하는건 1이지만 컴퓨터에서
// 0 이니깐 공간 널널하게 해두는걸 생각하고 기준 잡아야 할듯)
// 그리고 시계 방향으로 도는 테두리열과 , 움직이지않는 열을 생각하고
// 모서리 경계를 통해서 어떨떄 y좌표가 증가할지, 감소할지
// ㄴ 이같은 경우에는 코드가 꼬이고 버그 나기가 쉬워서 이럴떄는
// 시계방향으로 움직이는 빈칸을 만들고 역방향으로 값을 하나씩
// 땡겨오는 방식 사용
// 어떨 때 x좌표가 증가하고 감소할지 판별하는 경계조건을 파악해야할듯

// 가장 작은 숫자들을 순서대로 배열에 담아 리턴해야함

// 내가 궁금했던 내용 : 우리가 좌표값을 백업해둬야하는 곳에
// 백업을 해두었는데 그게 어떻게 빈공간으로 취급하냐였는데
// 생각을 해보니 숫자는 백업을 해두었고 그 백업자리는 덮어씌어도
// 되는 자리니깐 그걸 빈 공백 취급해도 상관없다라는 것을 인지함

class MatrixBorderRotation {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows +1 ][columns + 1];
        int num = 1;

        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                matrix[i][j] = num++;
            }
        }


        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int temp = matrix[x1][y1];
            int min = temp;

            for(int x = x1; x < x2; x++){
                matrix[x][y1] = matrix[x+1][y1];
                min = Math.min(min, matrix[x][y1]);
            }

            for(int y = y1; y < y2; y++){
                matrix[x2][y] = matrix[x2][y+1];
                min = Math.min(min, matrix[x2][y]);
            }

            for(int x = x2 ; x > x1; x--){
                matrix[x][y2] = matrix[x-1][y2];
                min = Math.min(min, matrix[x][y2]);
            }

            for(int y = y2 ; y > y1 + 1; y--){
                matrix[x1][y] = matrix[x1][y-1];
                min = Math.min(min, matrix[x1][y]);
            }

            matrix[x1][y1+1] = temp;
            answer[i] = min;
        }
        return answer;
    }
}
