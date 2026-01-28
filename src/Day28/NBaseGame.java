package Day28;

// 1. n진법, t가 미리구할 숫자의 개수, 참여인원 m, 튜브의 순서 p
// 2. Integer.toString(숫자, 진법) 사용해야되나? t가 미리 구할 숫자의 개수도 이해가 잘 x


class NBaseGame {
    public String solution(int n, int t, int m, int p) {
        //1. 전체 문자열 만들기 (최소 m*t는 나와야함)
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (sb.length() < m * t)
        {
            sb.append(Integer.toString(num++, n));
        }
        StringBuilder answer = new StringBuilder();
        for (int i = p-1; answer.length() < t; i+=m)
        {
            answer.append(sb.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}
