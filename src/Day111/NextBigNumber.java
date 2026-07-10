package Day111;

// 자연수 n이 주어졌을 때 n의 다음 큰 숫자는
// 다음과 같이 정의한다.
// 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수이다.
// 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때
// 1의 개수와 같다
// 조건 3. n의 다음 큰 숫자는 조건 1,2를 만족하는 가장
// 작은 수이다

// 샌드박스
// 1. 조건의 순서대로 해결하는게 제일 크다
// 2. 일단 2진수로 변환을 한후 그것보다 큰 수인데
// 1의 개수는 같아야 되기떄문에 그거의 갯수를 비교하는 과정
// 이 필요하고
// 3. 그 중에 제일 작은 수를 택해야하니 math.min을 써야되나
// 일단 고민정도로만 생각해보자
// 주의할점은 n의 숫자는 매우크다 하나하나 다 비교하고 넣기에는
// 너무 크다 그러니 모든 수를 반복문으로 돌릴수 없음은 인지를 하자
// 이건 추가적인 고민이긴한데 이진수의 0과 1의 개수를 만들수있는
// 경우의 수를 찾아서 거기서 최소값을 찾는 방법은 빡센가??
// Integer.bitcount를 통해 n의 2진수의 1의개수를 바로
// 찾을수도 있다
// 그리고 어차피 다음 숫자까지의 반복문은 얼마 돌리지않음 다시
// 알아차린단걸 추가적으로 암

class NextBigNumber {
    public int solution(int n) {
        int answer = 0;

        // 수를 2진수로 변환해주는 작업
        String bin2 = Integer.toBinaryString(n);
        int bin2_count = 0;

        // 1의 개수를 세주는 작업
        for(int i = 0; i < bin2.length(); i++){
            if(bin2.charAt(i) == '1'){
                bin2_count++;
            }
        }
        int target =  n + 1;
        while(true){
            String targetBin = Integer.toBinaryString(target);
            int target_count = 0;

            for(int i = 0; i < targetBin.length(); i++){
                if(targetBin.charAt(i) == '1'){
                    target_count++;
                }
            }
            if(target_count == bin2_count){
                answer = target;
                break;
            }
            else
                target++;
        }
        return answer;
    }
}
