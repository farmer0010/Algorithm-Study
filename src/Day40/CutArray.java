package Day40;

// N^2 배열 자르기
// 정수 N과 left, right가 주어짐
// n*n 크기의 비어있는 2차원 배열 생성
// 1행 1열부터 i행 i열까지의 영역내 모든 빈칸을 숫자 i로
// 채움니다 1행부터 n행을 잘라내어 모두 이어붙인
// 새로운 배열생성
// 새로운 1차원 배열을 arr이라 할떄
// arr[left], arr[left+1]..arr[right]만 남기고
// 나머지는 싹 지움

// 샌드박스 힌트: 좌표의 규칙
// 일단 1차원 배열을 2차원 배열로 변환해본다 생각하고
// 느낌 파악: i를 n으로 나누어 나눈 몫과 나머지를 활용해서
// 몇행 몇열인지 파악

// 좌표 숫자로 (row, col) 확인 -> 행을 통해
// 관련값을 체크할수있다

class CutArray {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) +1];
        int index = 0;

        for (long i = left; i <= right; i++) {
            int row = (int) (i/n);
            int col = (int) (i%n);
            answer[index++] = Math.max(row, col) + 1;
        }
        return answer;
    }
}
