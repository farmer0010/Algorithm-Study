package Day114;

// 최고의 집합

// 자연수 n개로 이루어진 중복 집합 (multi set)
// 중에 두 조건을 만족하는 집합을 최고의 집합이라고 함

// 조건 1 : 각 원소의 합이 S가 되는 수의 집합
// 조건 2 : 위 조건을 만족하면서 각 원소의 곱이
// 최대가 되는 집합

// 집합 원소의 갯수 n과 모든 원소들의 합 s
// 가 매개변수로 주어질 때 최고의 집합을 리턴 하도록
// 최고의 집합은 오름 차순으로 정렬된 1차원 배열을 리턴

// 샌드박스
// 1. 일단 s개를 가지고 합이 n으로 만들어지는 집합을
// 찾아야함
// 2. 그리고 특징을 찾아보니깐 앞에 수와 뒤에서 차이가 적
// 을수록 더 큰 값을 산출함
// 모든 경우의 수를 구하기엔 시간 복잡도 적으로 빡셈
// 그렇기 때문에 수들이 가장 가깝게 뭉쳐있다는 특성을 활용해보면
// 좋음

class BestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int basicNum = s / n;
        int remainNum = s % n;

        if(s < n){
            return new int[]{-1};
        }

        for (int i = 0; i < n; i++) {
            answer[i] = basicNum;
        }
        for (int i = answer.length-1; i > 0; i--) {
            if(remainNum == 0){
                break;
            }
            remainNum--;
            answer[i] += 1;
        }
        return answer;
    }
}
