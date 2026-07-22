package Day117;

// 튜플

// 셀 수 있는 수량의 순서 있는 열거 또는 어떤 순서를
// 따르는 요소들의 모음을 튜플이라고 함
// n개의 요소를 가진 튜플을 n-tuple이라고 함

// 튜플의 성질
// 1. 중복된 원소를 가질 수 있다.
// 2. 원소의 정해진 순서가 있으며 원소의 순서가 다르면
// 다른 튜플임
// 3, 튜플의 원소의 개수는 유한함

// 근데 우리에게 주어지는 튜플은 원소의 개수가 n개 이고
// 중복되는 원소가 없는 튜플이 주어짐 (set)일 가능성이 있음
// 집합은 원소의 순서가 바뀌어도 상관없음
// 특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로
// 주어질 때 s가 표현하는 튜플을 배열에 담아 리턴

// 샌드박스
// 1. 일단 파싱을 하는 과정이 필요할 것같음 근데 어떻게 파싱을
// 할꺼냐? 고민해봐야함
// 2. 수를 뽑아 오는걸 생각하면 배열안에 원소가 1개이면 첫번째 수를
// 뽑아오고 2개이면 두번째를 수를 뽑아오고 n이면 n번째 자리를 뽑아옴
// 우리는 조회를 하는거기때문에 set을 통하면 빠르게 뽑을 수있음

// 추가 : substring (a , b)까지면 a(포함) b(미포함) 추출
// 정규식 특수문자 → 앞에 \
// 자바 문자열 안에서 정규식을 작성 → \ 하나를 표현하려면 \\

// compare과 compareTo의 차이점은 정적인 변수를 비교하냐?
// 아나면 객체를 비교하냐의 차이임 ex) a.compareTo(b)

import java.util.Arrays;
import java.util.HashSet;

class Tuple {
    public int[] solution(String s) {
        // 1. 규칙성을 만들어 주기 위해 앞자리, 뒤자리 2개 추출
        // 그러면 },{ 이 모양이 반복적으로 나오게 됨

        s = s.substring(2, s.length() -2);
        String[] arr = s.split("\\},\\{");

        Arrays.sort(arr, (a,b) -> Integer.compare(a.length(), b.length()));

        HashSet<Integer> set = new HashSet<>();
        int[] answer = new int[arr.length];
        int idx = 0;

        for(String str : arr){
            String arr2[] = str.split(",");
            for(String str2 : arr2){
                int num = Integer.parseInt(str2);
                if(set.add(num)){
                    answer[idx++] = num;
                }
            }
        }

        return answer;
    }
}
