# 🔥 Java Algorithm Study

매일 꾸준히 알고리즘 문제를 풀고 기록합니다.

## 📚 학습 목표
- **언어:** Java 11+
- **목표:** 하루 1문제 이상 풀기 & 효율적인 자료구조 고민하기
- **기간:** 2023.12.XX ~ (진행중)

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

---