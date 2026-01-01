# 🔥 Java Algorithm Study

매일 꾸준히 알고리즘 문제를 풀고 기록합니다.

## 📚 학습 목표
- **언어:** Java 11+
- **목표:** 하루 1문제 이상 풀기 & 효율적인 자료구조 고민하기
- **기간:** 2025.12.08 ~ (진행중)

---

### Day 14 (2026.01.02) - 정렬 심화 (Custom Sort)

단순한 오름차순/내림차순을 넘어, **람다식(Lambda)**을 활용해 나만의 정렬 기준을 만드는 법을 익혔다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[가장 큰 수](https://school.programmers.co.kr/learn/courses/30/lessons/42746)** | [Link](./Day14/BiggestNumber.java) | `Lambda`, `compareTo` <br> 숫자 크기가 아닌 **문자열 결합 순서**가 핵심. `(o2+o1).compareTo(o1+o2)`로 붙였을 때 더 큰 쪽을 우선순위로 둠. |
| Lv.1 | **[문자열 내 마음대로 정렬하기](https://school.programmers.co.kr/learn/courses/30/lessons/12915)** | [Link](./Day14/StringCustomSort.java) | `Custom Sort` <br> 정렬 조건이 여러 개일 때(n번째 글자 -> 단어 전체) `if-else` 로직을 람다식 내부에 구현함. |

### Day 12 (2025.12.30) - 정렬 (Sort)

가장 기본이 되는 알고리즘인 정렬을 학습했다. 자바의 내장 라이브러리를 활용하면 복잡한 구현 없이도 쉽게 문제를 해결할 수 있다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.1 | **[K번째수](https://school.programmers.co.kr/learn/courses/30/lessons/42748)** | [Link](./Day13/KthNumber.java) | `Sort`, `Arrays.copyOfRange` <br> 배열을 자르고(`copyOfRange`) 정렬(`sort`)하는 과정을 익힘. 인덱스가 0부터 시작하는 점만 주의하면 된다. |

### Day 11 (2025.12.29) - DFS vs BFS 실전 비교

같은 문제를 두 가지 방식으로 모두 풀어보며 차이점을 명확히 정리했다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.3 | **[네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162)** | [DFS](./Day12/Network_dfs.java) <br> [BFS](./Day12/Network_bfs.java) | `DFS/BFS`, `Connected Component` <br> 연결된 덩어리(네트워크)의 개수를 세는 문제. **방문 체크(`visited`)**가 핵심이며, 재귀(DFS)와 큐(BFS) 구현 방식을 비교 학습함. |

### Day 10 (2025.12.26) - 너비 우선 탐색 (BFS)

최단 거리 문제의 치트키, **BFS(Breadth-First Search)**를 학습했다. "가까운 곳부터 모두 방문하고 나아가는" 물결 같은 탐색 방식을 익혔다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844)** | [Link](./Day10/GameMap.java) | `BFS`, `Queue` <br> 최단 경로는 **BFS**가 유리하다. `Queue`를 이용해 방문 순서를 관리하고, 맵에 직접 거리를 누적(`+1`)시키는 테크닉을 사용했다. |

#### 💡 Today I Learned (TIL)
1. **BFS의 핵심은 Queue:** 먼저 발견한 길을 먼저 탐색해야 너비(가로)로 퍼질 수 있다. 그래서 선입선출(FIFO)인 큐를 사용한다.
2. **거리 누적 테크닉:** `maps[next] = maps[current] + 1` 공식을 사용하면, 별도의 변수 없이 맵 자체에 이동 횟수를 기록할 수 있다.
3. **한글 설계의 중요성:** 코드를 바로 치기보다 "큐 생성 -> 시작점 등록 -> 무한반복 -> 4방향 탐색" 순서로 한글 주석을 먼저 적는 것이 구현에 훨씬 도움이 된다.

### Day 9 (2025.12.24) - 깊이 우선 탐색 (DFS)

탐색 알고리즘의 핵심인 **DFS(Depth-First Search)**를 학습했다. "한 우물만 끝까지 판다"는 개념을 익히고, 이를 구현하는 **재귀(Recursion)** 패턴을 연습했다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165)** | [Link](./Day9/TargetNumber.java) | `DFS(Recursion)` <br> 더하거나(+), 빼거나(-) 두 갈래 길로 재귀 호출. 끝까지 갔을 때(`index == length`) 타겟 확인. |
| Lv.2 | **[피로도](https://school.programmers.co.kr/learn/courses/30/lessons/87946)** | [Link](./Day9/Fatigue.java) | `DFS` + `Backtracking` <br> 순열(Permutation)처럼 순서가 중요할 땐 `visited` 배열 사용. 들어갈 때 `true`, 나올 때 `false`가 핵심. |

#### 💡 Today I Learned (TIL)
1. **DFS의 공식:** DFS는 **재귀함수(Recursion)**다. "나와 똑같은 분신을 다음 단계로 보낸다"고 생각하자.
2. **탈출 조건 (Base Case):** 재귀는 영원히 돌면 안 된다. 반드시 `if (index == 끝)` 같은 종료 조건이 맨 위에 있어야 한다.
3. **백트래킹 (Backtracking):** `visited` 체크를 했다가, 재귀가 끝나고 돌아나올 때 다시 풀어주는(`false`) 기술. 그래야 다른 순서의 길도 탐색할 수 있다.

### Day 8 (2025.12.23) - 완전 탐색 (Brute Force)

"컴퓨터의 빠른 계산 능력을 믿자." 모든 경우의 수를 확인하여 정답을 찾는 **완전 탐색** 기법을 연습했다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.1 | **[모의고사](https://school.programmers.co.kr/learn/courses/30/lessons/42840)** | [Link](./Day8/MockExam.java) | `Modulo(%)` <br> `%` 연산자로 반복되는 패턴 구현. `ArrayList`를 활용해 동적 결과 담기. |
| Lv.2 | **[카펫](https://school.programmers.co.kr/learn/courses/30/lessons/42842)** | [Link](./Day8/Carpet.java) | `Math Rule` <br> 약수(`width * height`) 탐색. 테두리 제외 공식 `(w-2)*(h-2) == yellow` 검증. |

#### 💡 Today I Learned (TIL)
1. **나머지 연산자(%):** 배열의 인덱스를 순환시킬 때(`i % length`) 가장 강력한 도구다.
2. **ArrayList vs Array:** 결과의 개수를 모를 땐 `ArrayList`에 담고, 마지막에 `stream`이나 `loop`로 `int[]` 변환을 한다.
3. **완전 탐색의 기본:** 복잡한 알고리즘을 고민하기 전에, **"가능한 범위를 루프로 다 돌려볼 수 있나?"** 먼저 생각하자. (컴퓨터는 생각보다 빠르다.)

### Day 7 (2025.12.22) - 우선순위 큐 & 클래스 활용

오늘은 큐의 심화 버전인 **PriorityQueue**와, 데이터를 객체로 묶어 관리하는 **Class 활용법**을 익혔다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626)** | [Link](./Day7/MoreSpicy.java) | `PriorityQueue` <br> 자동 정렬(최소 힙) 특성 활용. `peek()`로 조건 확인 후 `poll()` 2번 수행. |
| Lv.2 | **[프로세스](https://school.programmers.co.kr/learn/courses/30/lessons/42587)** | [Link](./Day7/ProcessQueue.java) | `Queue` + `Custom Class` <br> 단순 `int`가 아니라 `Document` 객체를 만들어 인덱스와 값을 함께 관리함. |

#### 💡 Today I Learned (TIL)
1. **PriorityQueue의 위력:** `offer`할 때는 순서가 상관없지만, `poll`할 때는 무조건 **가장 작은 값**이 나온다. (최소 힙 구조)
2. **객체 활용 (Relationship):** 큐에 단순히 숫자만 넣으면 위치 정보를 잃어버린다. `class Document { int idx; int priority; }` 처럼 객체로 포장해서 넣어야 상태를 기억할 수 있다.
3. **로직 설계의 디테일:** `boolean flag`를 사용해 상태(나보다 센 놈이 있는가?)를 체크하고, `return`의 위치를 정확히 잡아야 로직이 꼬이지 않는다.

### Day 6 (2025.12.18) - 스택/큐 심화 (Stack & Queue Deep Dive)

이전에 풀었던 문제들을 다시 점검하며, `Stack` 클래스 대신 `ArrayDeque`를 적용하고 로직의 오류(Concurrent Modification)를 개선하는 데 집중했다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909)** | [Link](./Day6/Programmers_12909_올바른괄호.java) | `ArrayDeque` <br> `Integer` 인덱스가 아닌 `Character` 값을 담아 직관성 확보. 불필요한 `push` 방지. |
| Lv.2 | **[기능개발](https://school.programmers.co.kr/learn/courses/30/lessons/42586)** | [Link](./Day6/Programmers_42586_기능개발.java) | `ArrayList` + `Greedy` <br> 큐의 크기가 변하는 루프(`poll`)의 위험성 해결. 기준값(`maxDay`) 갱신 로직. |

#### 💡 Today I Learned (TIL)
1. **자료형의 중요성:** 스택에 인덱스(int)를 넣고 문자(char)와 비교하는 실수를 주의하자. (제네릭 타입 확인 필수)
2. **동적 배열 루프의 함정:** `for (i < list.size())` 내부에서 `remove`나 `poll`을 수행하면 전체 크기가 줄어들어 루프가 조기에 종료되거나 인덱스가 꼬인다.
3. **로직의 단순화:** 무조건 큐를 고집하기보다, `Greedy`하게 기준값(max)을 갱신하며 리스트에 담는 것이 더 효율적일 때가 있다.

### Day 5 (2025.12.17) - 해시 (Hash) 복습 & 재활

오랜만의 알고리즘 복습. Map을 활용해 조회 속도를 높이고, 인덱스를 기억하는 기술을 익혔다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.1 | **[달리기 경주](https://school.programmers.co.kr/learn/courses/30/lessons/178871)** | [Link](./Day5/RunningRace.java) | `HashMap` + `Array` Swap <br> 이름으로 등수 찾기(Map) + 등수로 이름 찾기(Array) 동기화. |
| Lv.1 | **[가장 가까운 같은 글자](https://school.programmers.co.kr/learn/courses/30/lessons/142086)** | [Link](./Day5/NearestLetter.java) | `Map Update` <br> Map은 값을 덮어쓸 수 있다. 최신 인덱스를 계속 갱신(`put`)하며 거리 계산. |

#### 💡 Today I Learned (TIL)
1. **Map의 이중성:** `put`은 데이터를 넣을 때도 쓰지만, **기존 값을 최신 값으로 업데이트**할 때도 쓴다.
2. **거리 계산:** 거리는 항상 `현재 인덱스 - 과거 인덱스`다.
3. **Map에 무엇을 담을까:** 계산된 결과(거리)를 담는 게 아니라, 계산에 필요한 **원본 데이터(인덱스)**를 담아야 한다.

### Day 4 (2025.12.11) - 해시 (Hash)

오늘은 데이터를 **Key-Value** 쌍으로 저장하여 검색 속도를 O(1)로 최적화하는 **해시(Hash)** 알고리즘을 집중 공략했다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.1 | **[완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576)** | [Link](./Day4/DidNotFinish.java) | `HashMap` <br> 참가자(+1), 완주자(-1) 카운팅. 0이 아닌 사람 찾기. |
| Lv.1 | **[추억 점수](https://school.programmers.co.kr/learn/courses/30/lessons/176963)** | [Link](./Day4/MemoryScore.java) | `Map Lookup` <br> 이름-점수 매핑. 이중 for문에서 `map.get`으로 점수 합산. |
| Lv.2 | **[의상](https://school.programmers.co.kr/learn/courses/30/lessons/42578)** | [Link](./Day4/Clothes.java) | `Map.values()` <br> 종류별 개수 세기. `(A+1)*(B+1)...-1` 공식 적용. |
| Lv.1 | **[성격 유형 검사하기](https://school.programmers.co.kr/learn/courses/30/lessons/118666)** | [Link](./Day4/PersonalityTest.java) | `Kakao Tech` <br> 선택지에 따른 점수 배분(비동의/동의). 지표별 점수 비교 및 사전순 정렬. |

#### 💡 Today I Learned (TIL)
1. **빈도수 세기 공식:** `map.put(key, map.getOrDefault(key, 0) + 1);` 은 해시 문제의 알파이자 오메가다.
2. **Key가 필요 없을 때:** 맵의 모든 값을 계산해야 할 때는 `map.values()`를 사용하면 편하다.
3. **Map을 쓰는 이유:** 배열은 인덱스(숫자)로만 찾을 수 있지만, Map은 이름(String) 등 어떤 키로든 O(1)로 찾을 수 있다.

---

### Day 3 (2025.12.10) - 정렬 (Sorting)

오늘은 데이터를 순서대로 나열하여 효율적으로 처리하는 **정렬(Sorting)** 알고리즘을 연습했다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.1 | **[K번째수](https://school.programmers.co.kr/learn/courses/30/lessons/42748)** | [Link](./Day3/KthNumber.java) | `Arrays.copyOfRange`, `Arrays.sort` <br> 자바 인덱스(0부터)와 사람의 순서(1부터) 차이 주의 (-1 필수). |
| Lv.1 | **[예산](https://school.programmers.co.kr/learn/courses/30/lessons/12982)** | [Link](./Day3/Budget.java) | `Greedy` <br> 최대한 많은 팀을 지원하려면 **작은 금액**부터 줘야 함 -> 오름차순 정렬. |
| Lv.1 | **[과일 장수](https://school.programmers.co.kr/learn/courses/30/lessons/135808)** | [Link](./Day3/FruitSeller.java) | `Reverse Indexing` <br> 오름차순 정렬 후, **뒤에서부터** m개씩 끊어서 최저점을 찾아야 이득. |
| Lv.2 | **[H-Index](https://school.programmers.co.kr/learn/courses/30/lessons/42747)** | [Link](./Day3/HIndex.java) | `Sort`, `Comparison` <br> 정렬 후 `인용 횟수(값)`와 `남은 논문 수(길이-i)`가 만나는 균형점 찾기. |

#### 💡 Today I Learned (TIL)
1. **정렬의 힘:** 단순히 줄 세우는 것뿐만 아니라, **Greedy(욕심쟁이)** 전략의 기본이 된다. (작은 것부터 vs 큰 것부터)
2. **인덱스 함정:** 문제에서 "k번째"라고 하면 코드는 무조건 `k-1`이다.
3. **H-Index의 교훈:** 문제는 어려워 보여도 정렬하면 `for`문 하나로 풀린다. **"내 점수 >= 남은 개수"** 공식 기억하기.

---

## 📅 Daily Log

### Day 2 (2025.12.09) - 스택 & 큐 (Stack & Queue)

오늘은 **LIFO(스택)**와 **FIFO(큐)**의 동작 원리를 이해하고, `Deque`와 `LinkedList`를 활용해 순서가 중요한 문제들을 해결했다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909)** | [Link](./Day2/CorrectParentheses.java) | `Stack(Deque)` <br> 여는 괄호 `push`, 닫는 괄호 `pop`. 빈 스택 체크(`isEmpty`)가 핵심. |
| Lv.2 | **[기능개발](https://school.programmers.co.kr/learn/courses/30/lessons/42586)** | [Link](./Day2/FunctionDevelopment.java) | `Queue` <br> `Math.ceil`로 날짜 계산. 앞사람(반장)보다 늦게 끝나면 대기, 빠르면 같이 배포. |
| Lv.2 | **[짝지어 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12973)** | [Link](./Day2/PairRemoval.java) | `Stack` <br> `String` 대신 `Character` 사용(성능). 연속된 같은 글자 터트리기(테트리스). |
| Lv.1 | **[크레인 인형뽑기 게임](https://school.programmers.co.kr/learn/courses/30/lessons/64061)** | [Link](./Day2/CraneGame.java) | `Stack`, `2D Array` <br> `moves` 순서대로 열 탐색. 뽑은 인형을 스택에 넣고 비교/삭제. |

#### 💡 Today I Learned (TIL)
1. **Stack 클래스는 이제 그만:** 옛날 `Stack` 클래스 대신 `Deque<Integer> stack = new ArrayDeque<>();`를 쓰는 것이 더 빠르고 효율적이다.
2. **나눗셈의 함정:** 자바 정수 나눗셈(`7/3=2`)은 소수점을 버린다. 올림(`ceil`)을 하려면 `(double)`로 캐스팅이 필수다.
3. **Queue 활용:** `Queue`는 인터페이스이므로 `LinkedList`로 구현하여 `offer`(넣기), `poll`(빼기)을 사용한다.
4. **로직 분리:** 크레인 게임처럼 복잡할 땐 '탐색(moves)'과 '처리(stack)' 로직을 명확히 분리해야 실수가 적다.

---

### Day 1 (2025.12.08) - 자료구조 기초 (List, Set)

오늘은 **ArrayList**와 **HashSet**의 차이점을 이해하고, 상황에 맞게 골라 쓰는 연습을 했다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.1 | **[같은 숫자는 싫어](https://school.programmers.co.kr/learn/courses/30/lessons/12906)** | [Link](./Day1/HateSameNumber.java) | `ArrayList` <br> `contains()`는 O(n)이라 느림. 직전 값(`get(size-1)`)과 비교하여 O(1)로 처리. |
| Lv.1 | **[폰켓몬](https://school.programmers.co.kr/learn/courses/30/lessons/1845)** | [Link](./Day1/Ponketmon.java) | `HashSet` <br> 중복 제거가 핵심. `Math.min(max, typeCount)` 로직 활용. |
| Lv.1 | **[제일 작은 수 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12935)** | [Link](./Day1/RemoveSmallestNumber.java) | `Collections.min()` <br> `remove(int index)`와 `remove(Object value)` 혼동 주의. |
| Lv.1 | **[두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644)** | [Link](./Day1/PickTwoAndAdd.java) | `HashSet` → `List` <br> 이중 for문(`j=i+1`), `Set`으로 중복 제거 후 `List.sort()` 정렬. |

#### 💡 Today I Learned (TIL)
1. **ArrayList 제거의 함정:** 숫자를 제거할 때 `remove(10)`을 하면 10번째 인덱스가 지워짐. 값을 지우려면 `remove(list.indexOf(10))` 처럼 인덱스를 찾아야 함.
2. **Set의 위력:** 중복을 제거해야 할 때는 고민하지 말고 `HashSet`을 쓰자.
3. **배열 반환 패턴:** `ArrayList`로 로직을 수행하고 마지막에 `new int[list.size()]`로 변환해서 리턴하는 패턴에 익숙해짐.