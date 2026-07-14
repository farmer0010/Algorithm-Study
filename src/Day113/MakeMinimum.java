package Day113;

// 길이가 같은 배열 a,b 두개가 있고
// 각 배열은 자연수로 이루어짐
// 배열 a,b에서 각각 한개의 숫자를 뽑아 두 수를 곱한다.
// 이러한 과정을 배열의 길이 만큼 반복하고 두수를 곱한 값을 누적한다
// 이 떄 최종적으로 누적된 값이 최솟 값으로 리턴

// 샌드 박스
// 이 경우에는 항상 최선을 값을 가지고 해야하는데
// a에서 오름 차순으로 정렬하고 , b에서 내림차순으로
// 정렬 하는 식으로 하고 반복문을 돌린다음 누적하면
// 최소치가 나올듯 함

import java.util.Arrays;

class MakeMinimum
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        // 객체 배열이 아니기 떄문에 뒤집기는 안됨
        Arrays.sort(B);
        for(int i = 0; i < (B.length / 2); i++){
            int temp = B[i];
            B[i] = B[B.length - i - 1];
            B[B.length - i - 1] = temp;
        }

        for(int i = 0;  i < A.length; i++){
            answer += (A[i] * B[i]);
        }

        return answer;
    }
}
