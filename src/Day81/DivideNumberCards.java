package Day81;

// 숫자 카드 나누기

// 철수와 영희는 숫자가 하나씩 적힌 카드를 절반씩 나눠서 가진 후
// 다음 두 조건 중 하나를 만족하는 가장 큰 양의 정수 a를 구하려고 한다

// 조건 1 : 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고
// 영희가 가진 카드들에 적힌 모든 숫자들중 하나도 나눌수 없는 양의 정수 a
// 조건 2 : 영희가 가진 카드들에 적힌 모든 숫자를 나눌수있고
// 철수가 가진 카드들에 적힌 모든 숫자를 하나도 나눌수 없는 양의 정수 a

// 입력값이: 철수가 가진 배열 A, 영희가 가진 배열 B가 주어졌을 때
// 주어진 조건을 만족하는 가장 큰 양의 정수 a를 리턴
// 만약 조건에 해당하는 a가 없다면 0을 리턴

// 이중 for문으로 비교하기에는 각 길이가 너무 길어
// 뭔가 수학적 규칙이 있을것 같은데 이 부분은 감이 안오는데
// 일단 느낀게 양 배열의 최대 공약수 각각 찾고 그걸 각각 비교하고
// 그 더 큰 수로 나눠지는지 봐야할것 같은데
// 근데 최대 공약수 한다음에 걔를 증가시키면서 확인해야할지 어떻게 해야할지
// 그 부분이 고민이긴함..

class DivideNumberCards {
    public int solution(int[] arrayA, int[] arrayB) {
        int answerA = 0;
        int answerB = 0;
        int gcdA, gcdB = 0;
        boolean flagA = true;
        boolean flagB = true;

        gcdA = arrayA[0];
        gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] % gcdB == 0){
                flagB = false;
                break;
            }
        }
        if(flagB == true){
            answerB = gcdB;
        }

        for (int i = 0; i < arrayB.length; i++) {
            if(arrayB[i] % gcdA == 0){
                flagA = false;
                break;
            }
        }
        if(flagA == true){
            answerA = gcdA;
        }

        return (answerA > answerB) ? answerA : answerB;
    }

    private int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        return gcd(b, a % b);
    }
}