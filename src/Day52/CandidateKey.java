package Day52;

// 후보키
// 모든 인적 상황을 데이터 베이스에 넣고
// 이를 정리를 하던중에 후보키에 대한 고민

// 관계 데이터베이스에서 릴레이션의 튜플을 유일하게
// 식별할 수있는 속성 또는 집합 중 다음 두 성질을
// 만족하는 것을 후보키

// 1. 유일성: 릴레이션에 있는 모든 튜플에 대해 유일하게 식별
// 2. 최소성: 유일성을 가진 키를 구성하는 속성
// 중 하나라도 제외 되는 경우 유일성이 꺠지는 것을 의미함
// 릴레이션의 모든 튜플을 유일하게 식별하는데 꼭 필요한 속성들로만
// 이우러져야함
// 인적상황: 학번, 이름, 전공, 학년으로 테이블이 존재

// 리턴값 후보키
// 릴레이션의 후보키가 되기 위해서는 set 구조가 필요하지않을까?
// 어떤것을 엮을지? 생각을 하고 그것을 보관하는 구조? 흠
// 이거의 gemini 참고: 최소성 검사는 그 후보키가 다른 후보키의
// 부분 집합이 되면 안된다

// 1번: 양이 많지 않기떄문에 브루트포스로 해도될것같기도하고 아니면
// dfs 써도 될것같기도한데 이건 고민좀

// 2번: 이거는 아까 만든 조합을 set에다가 떄려 박으면?

// 3번 contains()를 통해서 부분집합에 포함되어있는지 확인 필요할듯?

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class CandidateKey {
    int colSize = 0;
    List<HashSet<Integer>> mainList = new ArrayList<>();

    public int solution(String[][] relation) {
        colSize = relation[0].length;

        for (int i = 1; i <= colSize; i++) {
            dfs(0, 0, i, new ArrayList<Integer>(), relation);
        }

        return mainList.size();
    }

    private void dfs(int startIdx, int count, int target, ArrayList<Integer> integers, String[][] relation) {
        if (count == target) {
            HashSet<String> set = new HashSet<>();

            for (String[] strings : relation) {
                StringBuilder student = new StringBuilder();
                for (Integer i : integers) {
                    student.append(strings[i]);
                }
                set.add(student.toString());
            }

            if (set.size() == relation.length) {
                HashSet<Integer> currentKey = new HashSet<>(integers);
                boolean isMinimal = true;

                for (HashSet<Integer> existKey : mainList) {
                    if (currentKey.containsAll(existKey)) {
                        isMinimal = false;
                        break;
                    }
                }

                if (isMinimal) {
                    mainList.add(currentKey);
                }
            }
            return;
        }

        for (int i = startIdx; i < colSize; i++) {
            integers.add(i);
            dfs(i + 1, count + 1, target, integers, relation);
            integers.remove(integers.size() - 1);
        }
    }
}
