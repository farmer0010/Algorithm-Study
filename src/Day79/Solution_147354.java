package Day79;

// 테이블 해시 함수

// 어떤 데이터 베이스 한 테이블은 모두 정수 타입인 컬럼으로 이루어짐
// 행은 튜플을, 열은 컬럼을 나타냄

// 첫번 째 컬럼은 기본키로서 모든 튜플에 대해 그 값이 중복되지않도록
// 보장됨 -> 우리는 이 첫번쨰 컬럼을 가지고 뭐를 할수도 있겠다 생각을 헤야함

// 1. 해시함수는 col, row_begin, row_end을 입력 받음
// 2. 테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름 차순으로 정렬 하되
// 만약 그 값이 동일하면 기본키인 첫번째 컬럼의 값을 기준으로 내림차순 정렬
// 3. 정렬된 데이터에서 s_i를 i번째 행의 튜플에 대해 칼 컬럼의 값을 i로
// 나눈 나머지의 합으로 정의함
// 4. row_begin <= i <=row_end인 모든 s_i값을 누적하여 xor한 값을
// 해시값으로서 반환함

// 일단 데이터 튜플을 col 번째 컬럼 기준으로 먼저 정렬?

import java.util.Arrays;

class Solution_147354 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> {
            if(a[col-1] == b[col-1])
                return b[0] - a[0];
            else
                return a[col-1] - b[col-1];
        });
        int answer = 0;

        for(int i = row_begin; i <= row_end; i++) {
            int s_i = 0;
            int row[] = data[i-1];
            for (int value : row) {
                s_i += (value % i);
            }
            if(i == row_begin)
                answer = s_i;
            else
                answer ^= s_i;

        }
        return answer;
    }
}