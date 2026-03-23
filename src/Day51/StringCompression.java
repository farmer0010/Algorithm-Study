package Day51;

// 문자열 압축
// 대량의 데이터를 처리하기 위한
// 비손실 압축법을 공부중
// 문자열에서 같은 값이 연속해서 나타나는 것을
// 그 문자의 개수와 반복되는 값으로 표현하여
// 더 짧은 문자열로 표현

// 한번만 나타난 경우 1은 생략함
// 근데 이러할 경우 문자가 적은 경우
// 압축이 되지않을 수도 있어서
// 1개 이상의 단위로 잘라서 압축하여
// 더 짧은 문자열로 어떻게 뽀개면 좋을지?

// 리턴값: 가장 짧은 길이를 리턴해야하기떄문에
// 압축하여 표현한 문자열중 가장 짧은 길이를

// 일단 최대한 자를 수 있는 최대의 갯수에 대해서 파악
// 그리고 맵구조를 통해서 일단 문자열과 개수를 저장해
// 야할것같은데 이걸 노드 클래스를 만들어서 해야할지
// 아니면 맵 자료구조로 해야할지 고민중
// 내가 오해한 포인트: 중간에 다른 문자가
// 끼어있을 경우 압축이 되지않음
// 남은 꼬투리 문자열은 비교 후 압축한 문자열과
// 합치기

class StringCompression {
    public int solution(String s) {
        int answer = s.length();

        if (s.length() == 1)
            return 1;

        for (int step = 1; step <= s.length() / 2; step++) {
            StringBuilder cur = new StringBuilder();
            String prev = s.substring(0, step);
            int count = 1;

            for (int j = step; j < s.length(); j += step) {
                int endIdx = Math.min(j + step, s.length());
                String curr = s.substring(j, endIdx);

                if (prev.equals(curr)) {
                    count++;
                } else {
                    if (count > 1) {
                        cur.append(count);
                    }
                    cur.append(prev);

                    prev = curr;
                    count = 1;
                }
            }

            if (count > 1) {
                cur.append(count);
            }
            cur.append(prev);

            answer = Math.min(answer, cur.length());
        }

        return answer;
    }
}