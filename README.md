# 🔥 Java Algorithm Study

매일 꾸준히 알고리즘 문제를 풀고 기록합니다.

## 📚 학습 목표
- **언어:** Java 11+
- **목표:** 하루 1문제 이상 풀기 & 효율적인 자료구조 고민하기
- **기간:** 2025.12.08 ~ (진행중)

---

### Day 55 (2026.03.23) - 백준(BOJ) 생태계 적응 및 코어 근육 다지기 (1)

백준(BOJ) 본격 진출 1일 차. 프로그래머스의 '메서드 구현' 방식에서 벗어나, `BufferedReader`와 `StringTokenizer`를 활용한 입출력 제어 및 $O(1)$ 탐색, Stack을 활용한 상태 관리 등 실무형 코어 근육을 단련함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| 실버 4 | **[수 찾기 (BOJ 1920)](https://www.acmicpc.net/problem/1920)** | **HashSet을 활용한 $O(1)$ 탐색**. <br> 1. 최대 10만 개의 데이터를 이중 `for`문으로 탐색하면 $O(N^2)$으로 시간 초과가 발생함을 인지. <br> 2. 데이터를 보관할 때 `HashSet`을 사용하여 조회 속도를 $O(1)$로 최적화함. <br> 3. `contains()` 메서드를 활용하여 존재 유무에 따라 1과 0을 조건부 출력하는 로직 구현. |
| 실버 4 | **[괄호 (BOJ 9012)](https://www.acmicpc.net/problem/9012)** | **Stack (`ArrayDeque`) 방어 로직 & 테스트 케이스 반복**. <br> 1. 입력 데이터 수(`T`)만큼 `for`문을 돌며 매번 새로운 Stack과 깃발(`flag`) 변수를 초기화하는 구조 체득. <br> 2. 닫는 괄호 `)`가 들어올 때, 스택이 비어있는 상태(`isEmpty()`)에서 `pop()`을 시도하면 `NoSuchElementException` 런타임 에러가 발생함을 방어. <br> 3. `printf` 대신 `println`을 사용하여 백준이 요구하는 '각 테스트 케이스당 한 줄 출력' 형식을 완벽히 맞춤. |

#### 💡 Today I Learned (TIL)
1. **입력 템플릿의 정체 직역:** `BufferedReader`는 입력 스트림에서 한 줄을 통째로 퍼 오는 '수레' 역할을 하고, `StringTokenizer`는 퍼 온 문자열을 공백 기준으로 메모리 낭비 없이 썰어주는 '칼' 역할을 한다는 점을 완벽히 이해했다.
2. **출력 형식의 중요성:** 알고리즘 로직이 100% 맞더라도, 백준에서는 `System.out.println()`으로 명확히 줄바꿈을 해주지 않으면 '틀렸습니다'를 받을 수 있다. (출력의 꼼꼼함)
3. **스택의 3박자 방어:** 넣을 때(`push`)는 자유롭지만, 뺄 때(`pop`)는 항상 "내용물이 있는가?(`isEmpty`)"를 의심하고 방어하는 코드를 짜는 습관을 들였다.

### Day 54 (2026.03.20) - 코테 실전 압축 훈련 (2): PQ & 투 포인터, 그리고 백준(BOJ) 입성

과거에 풀었던 프로그래머스 코어 문제(PQ, Two Pointers)들을 백지상태에서 다시 마주하며 템플릿 체화 수준을 점검함. 이후, 알고리즘 코어 근육을 집중적으로 키우기 위해 압도적인 문제 풀(Pool)을 가진 **백준(BOJ) 플랫폼으로 훈련 영역을 확장**하여 첫 실버 등급 문제를 성공적으로 격파함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626)** | **PriorityQueue (최소 힙) 스케줄링**. <br> 1. 넣고(`offer`) 뺄(`poll`) 때마다 $O(\log N)$으로 가장 작은 값을 찾아주는 자동 정렬 PQ의 완벽한 사용처. <br> 2. `while (pq.peek() < K)` 조건으로 불필요한 연산을 차단하고, `if (pq.size() < 2)`로 예외(방어) 로직을 처리하는 실전 디테일 점검. |
| Lv.2 | **[구명보트](https://school.programmers.co.kr/learn/courses/30/lessons/42885)** | **Two Pointers (양끝 좁혀오기) & Greedy**. <br> 1. 어차피 타야 할 '가장 무거운 사람'을 '가장 가벼운 사람'과 짝지어보는 $O(N)$ 최적화 로직. <br> 2. 무게 초과 여부와 상관없이 무거운 사람(`right`)은 무조건 탑승한다는 사실을 이용해 로직을 우아하게 압축함. |
| 실버 4 | **[수들의 합 2 (BOJ 2003)](https://www.acmicpc.net/problem/2003)** | **Two Pointers (애벌레 슬라이딩) & BOJ 템플릿**. <br> 1. **BOJ 입력 템플릿 도입:** 시간 초과를 막기 위해 `Scanner` 대신 `BufferedReader`와 `StringTokenizer`를 사용하는 실무/코테 표준 입력 방식을 체득함. <br> 2. **연속 부분 배열 탐색:** `left`와 `right`가 같은 곳에서 출발하여, 합(`sum`)이 목표치보다 작으면 `right`를 늘리고, 크거나 같으면 `left`를 당겨서 조절하는 "애벌레 이동 패턴" 구현. <br> 3. **안전장치:** 배열의 끝(`right == N`)에 도달했을 때 무한 루프나 `IndexOutOfBounds`가 터지지 않도록 `break` 조건을 명확히 설계함. |

#### 💡 Today I Learned (TIL)
1. **투 포인터의 두 가지 얼굴:** - 정렬 후 **양 끝에서 마주 보며** 좁혀오는 패턴 (구명보트)
    - 같은 곳에서 출발해 **애벌레처럼 늘어났다 줄어들며** 이동하는 패턴 (부분 배열의 합)
2. **백준(BOJ) 생태계 적응:** 친절하게 배열을 던져주는 프로그래머스와 달리, 수레(`BufferedReader`)로 퍼 와서 칼(`StringTokenizer`)로 직접 썰어 쓰는 입력 템플릿의 필요성과 원리를 완벽히 이해했다. `package` 선언 시 발생하는 런타임 에러(NoClassDefFoundError) 대처법도 체득 완료.
3. **학습 마인드셋:** '아는 문제'는 템플릿 타이핑 속도를 올리는 데 쓰고, '낯선 문제(BOJ)'를 통해 뇌의 논리 회로를 강제로 돌려 구현력을 끌어올리는 투-트랙 전략을 실행할 것이다.

### Day 53 (2026.03.19) - 코테 실전 압축 훈련 (1): 해시(Hash) & 스택(Stack) 코어 패턴

어려운 빡구현 문제 풀이에서 잠시 벗어나, 코딩테스트의 '구구단'과 같은 코어 자료구조 패턴을 백지에서 빠르고 정확하게 타이핑해 내는 실전 압축 훈련을 진행함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[신고 결과 받기](https://school.programmers.co.kr/learn/courses/30/lessons/92334)** | **HashMap & HashSet 퓨전 설계 (Two-Pass 장부)**. <br> 1. **다중 장부 분리:** 2개의 우주(데이터)를 통제하기 위해 장부를 분리함. <br> &nbsp;&nbsp; - 장부 A (명단): `Map<String, Set<String>>` (내가 신고한 사람들의 고유 명단) <br> &nbsp;&nbsp; - 장부 B (카운터): `Map<String, Integer>` (피의자가 신고당한 총 횟수) <br> 2. **Map 업데이트 공식:** 기존 값을 꺼내서 1을 더한 뒤 다시 덮어쓰는 패턴 `map.put(target, map.get(target) + 1)` 완벽 각인. <br> 3. **문자열 결합의 위험성:** 명단을 관리할 때 `String`에 `+=` 연산으로 이어 붙이면 `contains()` 오작동(이름 겹침) 및 메모리 초과(OOM)가 발생함을 깨닫고, `Set`을 바구니로 사용하는 실무적 설계를 체득함. |
| Lv.2 | **[짝지어 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12973)** | **Stack (`ArrayDeque`) 테트리스 패턴**. <br> 1. **자료구조 선택:** 연속된 두 짝을 터뜨리고, "과거의 글자"와 "새로운 글자"를 다시 만나게 하려면 프링글스 통 모양의 후입선출(LIFO) `Stack`이 유일한 정답. <br> 2. **3박자 검증 로직:** 텅 빈 스택을 방어(`!stack.isEmpty()`) -> 맨 위 글자 확인(`stack.peek() == c`) -> 일치하면 터뜨림(`pop`), 다르면 넣음(`push`)의 정석 흐름 복구. <br> 3. **변수 vs 문자 리터럴:** `peek() == 'c'` (문자 c)와 `peek() == c` (변수 c)의 치명적 차이를 인지하고 기본 문법의 중요성을 다시 한번 점검함. |

#### 💡 Today I Learned (TIL)
1. **변수 네이밍은 설계의 나침반이다:** `reportMap`, `reportSet`처럼 비슷한 단어로 도배하면 뇌에 정지가 온다. `reporterToTargets`, `targetToCount` 처럼 "누가(Key) 무엇을(Value)" 가지는지 명확히 지어야 `for`문 내부에서 길을 잃지 않는다.
2. **String은 바구니가 아니다:** 문자열은 불변(Immutable) 객체다. 여러 개의 데이터를 묶어둬야 할 때는 무조건 `List`나 `Set`을 꺼내는 것이 메모리와 정확도를 지키는 길이다.
3. **기본기의 중요성:** 복잡하고 어려운 로직을 뚫어내는 뇌의 체력도 중요하지만, `ArrayDeque` 선언부터 3박자 검증 로직까지 척수 반사로 타이핑이 튀어나오게 만드는 '코어 패턴 훈련'이 뒷받침되어야 뇌의 RAM을 온전히 로직 고민에 쏟을 수 있다.

### Day 52 (2026.03.18) - Phase 5 카카오 기출 2연전 (3): 기괴한 재귀와 완전탐색의 정석

카카오 블라인드 기출 중에서도 가장 까다로운 '지문 강제형 재귀(Recursion)'와 '조합(DFS) + 부분집합(최소성) 검사'를 하루에 모두 격파함. 뼈대를 세우고 한계를 마주하며 질문하는 페어 프로그래밍(Pair Programming)의 진수를 경험함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[괄호 변환](https://school.programmers.co.kr/learn/courses/30/lessons/60058)** | **문자열 처리 + 재귀(Recursion) 직역**. <br> 1. **지문 직역의 중요성:** 카카오 특유의 "하라는 대로 해라"식 문제는 내 생각을 섞지 않고 1번부터 4번까지 단계별로 로직을 분리해 기계처럼 번역하는 것이 핵심. <br> 2. **균형잡힌 괄호 분리:** 여는 괄호와 닫는 괄호의 개수를 카운팅(`leftCnt == rightCnt`)하여 최초로 같아지는 순간 자르기(`substring`). <br> 3. **올바른 괄호 판별 최적화:** 무거운 `Stack` 객체 대신 정수 카운터(`openCnt`) 하나로, 순회 중 0 미만이 되는 순간 `false`를 반환하도록 속도 최적화. <br> 4. **재귀의 본질:** 깊게 파고들려 하지 말고 "결과값을 믿고 조립(`return u + solution(v);`)"하는 뻔뻔한 마인드셋 획득! |
| Lv.2 | **[후보키](https://school.programmers.co.kr/learn/courses/30/lessons/42890)** | **완전탐색(DFS 조합) + 자료구조(HashSet) + 최소성 검사**. <br> 1. **컬럼 조합 뽑기 (DFS):** 배열의 데이터를 직접 뽑는 것이 아니라, **"컬럼의 인덱스 번호"**를 조합으로 뽑아내는 것이 첫 번째 관문. (`add` -> `dfs` -> `remove`의 백트래킹 정석 패턴) <br> 2. **유일성 검사:** 뽑아낸 인덱스에 해당하는 문자열을 뭉친 뒤 `HashSet`에 넣고, `set.size()`와 전체 학생 수가 같은지 비교하여 판별. <br> 3. **최소성 검사 [최종 보스]:** 단순 문자열 포함 여부(`contains`)가 아니라, 집합 간의 포함 여부인 `containsAll`을 사용해야 함. 정답 명단을 `List<HashSet<Integer>>` 형태로 관리하면 `currentKey.containsAll(existKey)` 로직을 매우 우아하고 안전하게 구현할 수 있음. |

#### 💡 Today I Learned (TIL)
1. **재귀의 매개변수는 '세이브 파일'이다:** DFS의 매개변수는 "어디서부터(`startIdx`) + 얼만큼 진행됐고(`count`) + 목표는 뭐고(`target`) + 결과는 어디에 담을지(`List`)"를 정의하는 상태 저장소다.
2. **최소성 검사의 함정:** 문자열 "012"는 "02"를 포함(`contains`)하지 않는다. 부분집합을 검사할 때는 반드시 `Set`의 `containsAll`을 사용해야 논리적 오류를 막을 수 있다.
3. **질문은 실력이다:** 뇌의 RAM이 꽉 차서 한계에 부딪혔을 때, "여기까지 짰는데 이다음이 막혀!"라고 본인의 상태를 정확히 인지하고 피드백을 구하는 것이야말로 실무(페어 프로그래밍)에서 가장 요구되는 개발자의 진짜 역량임을 깨달았다.

### Day 51 (2026.03.16) - Phase 5 카카오 기출 2연전 (2): 문자열 정규화 및 예외 처리

문자열을 조각내고, 규칙에 맞게 재조립하며, 특수 기호(`#`) 등으로 발생하는 불규칙한 단위를 정규화(Normalization)하여 구현의 난이도를 낮추는 기법을 집중 훈련함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[문자열 압축](https://school.programmers.co.kr/learn/courses/30/lessons/60057)** | **문자열 슬라이싱 + 시뮬레이션**. <br> 1. **단위 탐색:** 압축 단위(`step`)를 1부터 문자열 길이의 절반까지 늘려가며 전수 조사. <br> 2. **인덱스 방어:** `Math.min(j + step, s.length())`를 활용해 `substring` 시 발생하는 `IndexOutOfBounds` 에러를 원천 차단. <br> 3. **잔여 처리:** 루프 종료 후 변수(`prev`, `count`)에 남아있는 마지막 압축 조각이 도화지에 누락되지 않도록 수동으로 털어 넣는 예외 처리 수행. |
| Lv.2 | **[방금그곡](https://school.programmers.co.kr/learn/courses/30/lessons/17683)** | **시간 파싱 + 문자열 치환(Normalization) + 시뮬레이션**. <br> 1. **분 단위 통합:** `HH:MM` 형태를 `(H * 60) + M` 정수로 변환하여 재생 시간을 직관적으로 계산. <br> 2. **치환 치트키:** `C#` → `c` 처럼 2글자 음표를 소문자 1글자로 `replace` 하여 '1분 = 1글자' 대응 관계를 만듦. 이를 통해 `contains()` 오작동 및 길이 계산 오류를 완벽히 해결. <br> 3. **원형 큐 로직:** 재생 시간만큼 악보를 늘릴 때 `j % music.length()`를 사용하여 악보 반복을 우아하게 구현. <br> 4. **우선순위 관리:** `streamTime > maxStreamTime` 조건을 통해 재생 시간이 길고 먼저 입력된 곡을 최적의 해로 도출. |

#### 💡 Today I Learned (TIL)
1. **정규화(Normalization)의 위력:** `C#` 같은 불규칙한 단위를 고정 길이 문자(`c`)로 치환하는 것만으로 알고리즘의 복잡도가 획기적으로 낮아짐을 체감함.
2. **마지막 조각의 법칙:** 모든 반복문이 끝난 직후, 메모리(변수)에 남아있는 마지막 데이터 조각을 도화지에 옮겼는지 확인하는 습관이 '테스트 케이스 탈락'을 막는 핵심임을 깨달음.
3. **StringBuilder의 객체 비교 함정:** `StringBuilder` 자체는 `contains()`를 지원하지 않으며, `equals()` 사용 시 주소값을 비교하므로 반드시 `toString()` 변환 후 비교해야 함.
4. **인덱스 안전망:** `substring`을 사용할 때 끝 인덱스를 `Math.min(target, length)`로 감싸는 습관은 문자열 문제의 '방어 운전'과 같음.

### Day 50 (2026.03.13) - Phase 5 카카오 기출 2연전 (1)

머릿속으로 설계한 다단계 논리(파싱, 상태 마킹, 시뮬레이션)를 실제 코드로 완벽하게 번역해 내는 '구현력(Implementation)' 집중 훈련.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[수식 최대화](https://school.programmers.co.kr/learn/courses/30/lessons/67257)** | **문자열 파싱 + 브루트 포스 + 리스트 조작**. <br> 1. `StringBuilder`를 활용해 연속된 숫자를 누적하고, 연산자를 만날 때마다 `Long`으로 변환하여 숫자와 연산자를 분리함. <br> 2. 연산자가 3개뿐이므로 DFS 대신 $3! = 6$가지의 우선순위 경우의 수를 2차원 배열로 하드코딩(브루트 포스)하여 탐색 속도와 직관성을 높임. <br> 3. 리스트에서 중간 값을 삭제할 때 `remove(index)`가 삭제된 값을 리턴하며 뒤의 요소를 앞으로 당기는 성질을 이용, $O(N)$의 리스트 조작을 안전하게 구현함. |
| Lv.2 | **[프렌즈4블록](https://school.programmers.co.kr/learn/courses/30/lessons/17679)** | **2차원 배열 시뮬레이션 + 상태 마킹(Marking) + Queue(중력)**. <br> 1. **오버플로우 방지:** 2x2 탐색 시 배열 범위를 벗어나지 않도록 `for`문의 조건을 `m-1`, `n-1`로 엄격히 제어함. <br> 2. **상태 분리 (Marking):** 겹치는 블록이 동시에 터지는 로직을 구현하기 위해, 즉시 삭제하지 않고 `boolean[][] visited` 배열에 폭발 예정 위치를 먼저 찜(Marking)해두는 투-패스(Two-pass) 전략 사용. <br> 3. **Queue를 이용한 중력(Gravity):** 세로줄(열)을 기준으로 **밑바닥부터** 알파벳을 `Queue`에 쓸어 담고(`add`), 다시 밑바닥부터 꺼내서(`poll`) 채운 뒤, 남은 윗부분을 빈칸(`'-'`)으로 덮어버리는 우아한 중력 로직 구현. |

### Day 49 (2026.03.12) - Phase 5 하드코어 샌드박스: 카카오 기출 2연전

면접 직후의 피로도를 이겨내고, 카카오 블라인드 기출의 핵심인 2차원 탐색(BFS)과 완전탐색(DFS 조합 + 해시)을 하루에 2문제 연속으로 격파함. 알고리즘 설계(Architecture) 뼈대를 스스로 세우는 구현력을 증명함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[거리두기 확인하기](https://school.programmers.co.kr/learn/courses/30/lessons/81302)** | **BFS (레이더망 탐색)**. <br> 1. **탐색 조건:** 모든 응시자(`P`) 위치에서 BFS를 시작하되, 맨해튼 거리가 2 이하인 곳까지만 탐색(`dist >= 2` 시 `continue`). <br> 2. **장애물 처리:** 빈 테이블(`O`)은 큐에 넣어 통과시키고, 파티션(`X`)은 무시하여 벽을 구현함. <br> 3. **방문 체크:** 방문 배열(`visited`)을 통해 자기 자신을 위반자로 오인하는 무한 루프 및 역주행을 완벽히 차단함. |
| Lv.2 | **[메뉴 리뉴얼](https://school.programmers.co.kr/learn/courses/30/lessons/72411)** | **DFS (조합) + HashMap**. <br> 1. **중복 방지:** "WX", "XW" 같은 순서가 다른 동일 조합을 막기 위해, 원본 주문 문자열을 미리 알파벳순으로 정렬(`Arrays.sort`). <br> 2. **조합 생성:** DFS 재귀(`dfs(order, current + order.charAt(j), j + 1, courseLength)`)를 이용해 목표 길이만큼의 모든 단품 메뉴 조합을 빠짐없이 생성함. (반복문 조건: `j < order.length()`) <br> 3. **Map.Entry 활용:** `HashMap`에 생성된 조합의 등장 횟수를 누적하고, `entrySet()`을 활용해 $O(N)$의 속도로 최대 빈도 조합(최소 2명 이상)을 깔끔하게 추출함. |

### Day 48 (2026.03.10) - Phase 5 면접 웜업: 문자열 파싱 & 해시맵

면접 전날, 코딩 감각을 유지하기 위한 가벼운 웜업. 자바의 문자열 조작(`substring`)과 `HashMap`을 활용한 실시간 사전(Dictionary) 구현 능력을 점검함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[[3차] 압축 (카카오 블라인드)](https://school.programmers.co.kr/learn/courses/30/lessons/17684)** | **LZW 무손실 압축 알고리즘 (HashMap + Two Pointers)**. <br> 1. **자료구조 선택:** 단어(Key)의 존재 여부를 $O(1)$로 확인하고 고유 번호(Value)를 매핑하기 위해 `HashMap`을 사용함. <br> 2. **Two Pointers 탐색:** 시작점 `i`를 기준으로 끝점 `j`를 늘려가며 `substring(i, j)`로 단어를 자름. <br> 3. **종료 조건:** 자른 단어가 사전에 없을 때(`!dict.containsKey`) 탐색을 멈춤. <br> 4. **로직 분기:** 직전까지의 가장 긴 단어(`j-1`)의 색인 번호를 정답 리스트에 추가하고, 사전에 없던 새 단어(`j`)를 다음 번호로 사전에 등록함. <br> 5. **인덱스 제어:** `for`문의 기본 증감식(`i++`)을 제거하고, `i = j - 1`로 시작점을 직접 점프시켜 중복 탐색을 방지함. |

### Day 47 (2026.03.09) - Phase 5 공채 특화 모드: 탐색 심화 & 자료구조 최적화

단순한 BFS 탐색을 넘어, 대기업 실전 코딩테스트의 핵심 트렌드인 **'탐색(BFS) + 자료구조(Map, Set) 결합을 통한 시간 복잡도 최적화'**를 완벽하게 훈련함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[석유 시추 (PCCP 기출)](https://school.programmers.co.kr/learn/courses/30/lessons/250136)** | **Two-Pass 전략 (BFS + HashMap + HashSet)**. <br> 1. **시간 초과 방지:** 시추관을 찌를 때마다 탐색하면 $O(N^3)$으로 터짐. 미리 조사를 끝내고 나중에 조회만 하는 Two-Pass 설계가 필수적임. <br> 2. **Pass 1 (장부 기록):** 전체 땅을 순회하며 `1`을 만나면 BFS를 돌림. 덩어리 크기(Size)를 구하고, 지나간 땅은 고유한 `ID(2, 3...)`로 덮어씌움. 알아낸 매장량은 `HashMap`에 `[ID: Size]` 형태로 기록. <br> 3. **Pass 2 (시추 및 계산):** 각 열을 수직으로 찌르면서 만나는 땅의 `ID`들을 `HashSet`에 담음. (ㄷ자 모양 덩어리를 두 번 관통할 때 발생하는 중복 합산 방지). 이후 Set에 담긴 고유 ID들만 Map에서 찾아 값을 더해 최댓값을 갱신함. |

### Day 46 (2026.03.03) - Phase 5 공채 특화 모드: 스케줄링 & 모노토닉 스택

공채 코딩테스트에 무조건 출제되는 필수 유형 2가지 집중 훈련. "시간의 흐름에 따른 상태 변화"를 우선순위 큐(PQ)와 스택(Stack)으로 $O(N \log N)$ 및 $O(N)$으로 최적화하는 기법을 마스터함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[호텔 대실](https://school.programmers.co.kr/learn/courses/30/lessons/155651)** | **스케줄링 (Sorting + PriorityQueue)**. <br> 1. **시간 파싱:** `"HH:MM"` 문자열을 `HH * 60 + MM` 형태의 분(Minute) 단위 정수로 변환. <br> 2. **2-Step 정렬:** 먼저 손님들을 **'시작 시간' 기준 오름차순**으로 정렬 (`Arrays.sort`). <br> 3. **PQ 상태 관리:** `PriorityQueue`에는 사용 중인 방의 **'청소 완료 시간(종료 시간 + 10)'**만 저장. `pq.peek() <= 현재 시작 시간` 이면 기존 방을 이어서 쓰고(`poll`), 아니면 새 방을 파서(`offer`) 최종 `pq.size()`로 필요 객실 수를 구함. |
| Lv.2 | **[뒤에 있는 큰 수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/154539)** | **모노토닉 스택 (Monotonic Stack)**. <br> 1. **O(N) 최적화:** 100만 개의 배열을 이중 for문으로 돌면 시간 초과. 단 한 번의 순회로 해결해야 함. <br> 2. **인덱스 저장:** 스택에 숫자의 '값'이 아닌 **'인덱스(위치)'**를 저장(`stack.push(i)`)하는 것이 핵심. <br> 3. **대기실 로직:** 현재 숫자(`numbers[i]`)가 스택 맨 위 인덱스의 숫자(`numbers[stack.peek()]`)보다 크면, `pop`한 인덱스 위치의 정답을 현재 숫자로 갱신함. |


### Day 45 (2026.03.02) - Phase 5 공채 빈출 모드: 그리디 & 투 포인터

데이터의 크기가 커서(10만~100만) BFS/이중 루프 탐색이 불가능할 때, 직관적인 그리디(양팔 저울) 방식과 투 포인터(Two Pointers)를 활용하여 $O(N)$ 시간 복잡도로 최적화하는 실전 기법을 훈련함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[두 큐 합 같게 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/118667)** | **Queue & Greedy (양팔 저울 알고리즘)**. <br> 1. **탐색의 함정:** 최소 횟수라고 무조건 BFS를 쓰면 길이(300,000) 때문에 터짐. <br> 2. **직관적 최적화:** 두 큐의 합을 비교해 무거운 쪽에서 빼서(`pop`) 가벼운 쪽에 넣는(`insert`) 과정을 반복하는 O(N) 로직 구현. <br> 3. **안전장치:** 누적합 오버플로우 방지를 위한 `long` 타입 사용 및 무한 루프 방지를 위한 한계치(`queue.length * 4`) 설정. |
| Lv.2 | **[연속된 부분 수열의 합](https://school.programmers.co.kr/learn/courses/30/lessons/178870)** | **투 포인터 (Two Pointers)**. <br> 1. **O(N) 최적화:** 길이가 100만인 배열에서 이중 for문은 무조건 시간 초과. `left`, `right` 두 개의 포인터를 벌레처럼 움직여 한 번의 순회로 탐색. <br> 2. **조건 분기:** `sum < k` 이면 `right` 증가(확장), `sum > k` 이면 `left` 증가(축소). <br> 3. **경계값 주의:** `right`를 증가시킬 때 배열의 끝을 넘어가는지 확인하는 `if (right < sequence.length)` 안전장치가 필수적임. |

### Day 44 (2026.02.27) - Phase 5 자립심 훈련: 탐색 심화 & 자료구조 직관

스스로 문제의 요구사항을 분석하여 올바른 자료구조(Stack)를 선택하는 직관력을 기르고, 까다로운 예외 조건과 상태 복구(Backtracking)가 포함된 깊이 우선 탐색(DFS)을 완벽하게 구현함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[양궁대회](https://school.programmers.co.kr/learn/courses/30/lessons/92342)** | **DFS & Backtracking (평행우주 템플릿)**. <br> 1. **이분 탐색적 접근:** 과녁마다 "어피치보다 딱 1발 더 쏜다" vs "0발 쏘고 포기한다" 두 갈래로만 뻗어나가 최적화. <br> 2. **백트래킹:** `ryan[index] = 0`으로 탐색 후 화살을 회수하여 이전 상태로 완벽히 원상 복구함. <br> 3. **안전한 복사:** 배열 참조(주소) 오류를 막기 위해 정답 갱신 시 반드시 `answer = ryan.clone()`을 사용하여 스냅샷을 찍음. |
| Lv.2 | **[택배상자](https://school.programmers.co.kr/learn/courses/30/lessons/131704)** | **Stack (파이프라인 단일화)**. <br> 1. **자료구조 도출:** "가장 마지막에 보관한 상자부터 꺼낸다"는 지문에서 **후입선출(LIFO) Stack**을 정확히 캐치함. <br> 2. **로직 최적화:** 메인 벨트 처리와 보조 벨트 처리를 `if-else`로 나누지 않고, 일단 다가오는 모든 상자를 스택에 무조건 `push` 한 뒤, 스택의 맨 위(`peek()`)를 검사해 `while`문으로 가능한 만큼 `pop` 하는 우아한 파이프라인 로직을 구현함. |

### Day 43 (2026.02.26) - 탐색(BFS)의 유연한 활용과 2차원 DP 심화

단순한 길 찾기를 넘어 다중 목표를 순차적으로 탐색하는 BFS 모듈화 기법과, 이전의 결과를 메모장에 기록하여 재활용하는 2차원 보드판 DP(동적계획법)를 훈련함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[미로 탈출](https://school.programmers.co.kr/learn/courses/30/lessons/159993)** | **2단 콤보 BFS & 상태 캡슐화**. <br> 1. **BFS 모듈화:** 출발지(S) -> 레버(L) -> 출구(E)로 이어지는 다중 목표 탐색을 위해, 타겟 문자만 바꿔 재사용할 수 있도록 BFS 로직을 분리함. <br> 2. **상태 캡슐화:** 큐에 단순히 좌표만 넣지 않고 `x, y, count(이동 시간)`를 묶은 `Node` 클래스를 담아 갈림길에서의 거리 계산 오류를 방지함. <br> 3. **예외 처리:** 중간 기착지(L)로 갈 수 없는 경우(`time1 == -1`), 끝까지 계산하지 않고 조기 종료하는 방어 로직 구현. |
| Lv.2 | **[가장 큰 정사각형 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/12905)** | **2차원 DP (Bottom-Up) & 배열 패딩**. <br> 1. **점화식 도출:** 현재 칸이 1일 때, `Math.min(왼쪽, 위쪽, 왼쪽 대각선 위) + 1`을 통해 자신이 우측 하단 꼭짓점이 되는 가장 큰 정사각형의 길이를 메모이제이션(Memoization) 함. <br> 2. **배열 패딩(Padding):** 보드판의 0번 인덱스 행/열에서 `-1` 조회가 일어나는 `IndexOutOfBounds` 에러를 막기 위해, 원본 배열보다 가로세로 1칸씩 더 큰 `dp[rows+1][cols+1]` 보드판을 깔아두는 실무적 트릭 적용. |

#### 💡 Today I Learned (TIL)
1. **BFS 이동 거리의 함정:** 큐를 돌릴 때 외부 변수(`int count = 0`)를 증가시키면 큐에 쌓인 개수만큼 숫자가 뻥튀기된다. 반드시 현재 노드가 가진 이동 거리에 `+1`을 해서 다음 노드로 넘겨야 한다 (`node.count + 1`).
2. **DP의 본질 (바텀업):** DP는 복잡한 수식이 아니라, "빈 도화지(판)를 쫙 깔아두고, 앞 칸의 결과를 베껴서 내 칸을 채우는" 타뷸레이션(Tabulation) 기법임을 완벽히 체감했다.
3. **도화지 늘리기 (Padding):** 2차원 배열의 경계선(0번 인덱스) 바깥을 탐색해야 할 때는, 조건문(`if`)으로 덕지덕지 막는 것보다 처음부터 배열 크기를 `+1` 해서 `0`으로 채워진 완충 지대를 만드는 것이 훨씬 우아하고 안전한 코딩이다.

### Day 42 (2026.02.25) - 탐색 & DP의 귀환

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[무인도 여행](https://school.programmers.co.kr/learn/courses/30/lessons/154540)** | **BFS (Connected Component) & Stream API**. <br> 1. **2차원 격자 탐색:** `dx, dy` 방향 배열을 활용해 상하좌우를 탐색하며 조건(바다 아님, 방문 안 함)에 맞는 연결된 칸(섬)을 `Queue`를 이용해 싹쓸이함. (주의: BFS 구현 시 재귀 호출 섞지 않기!) <br> 2. **리스트 변환 문법:** `List<Integer>`를 `int[]`로 변환할 때 `list.stream().mapToInt(i -> i).toArray()`를 사용하여 코드를 한 줄로 간결하게 처리. |
| Lv.2 | **[숫자 변환하기](https://school.programmers.co.kr/learn/courses/30/lessons/154538)** | **BFS 최단거리 탐색 vs DP (바텀업)**. <br> 1. **BFS 접근:** `[현재 숫자, 연산 횟수]`를 큐에 넣고 `+n, *2, *3` 세 갈래로 탐색. 1차원 배열 `visited`를 사용해 중복 계산을 방지하고 가장 먼저 `y`에 도달하는 최단거리를 구함. <br> 2. **DP 접근:** `y+1` 크기의 배열을 만들고, `x`부터 `y`까지 순회하며 미래의 위치(`i+n, i*2, i*3`)에 `Math.min(현재 기록, 내 위치 기록 + 1)`로 최솟값을 갱신해 나가는 보드판 채우기 방식. |

### Day 41 (2026.02.24) - 원형 수열 & 완전탐색

슬라이딩 윈도우의 확장판인 원형 수열 처리와, 재귀함수를 이용해 모든 경우의 수를 빠짐없이 만들어내는 완전탐색(DFS) 훈련.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[연속 부분 수열 합의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/131701)** | **원형 수열 (Modulo) & 누적 합 & HashSet**. <br> 1. **원형 인덱스 처리:** 배열 크기를 2배로 늘리지 않고, `(i + j) % length`를 사용하여 배열 끝을 넘어갈 때 0번 인덱스로 자연스럽게 회귀하도록 최적화. <br> 2. **누적 합 & 중복 제거:** 이중 루프(바깥 `i`: 시작점, 안쪽 `j`: 걸음 수)를 돌며 누적 합(`sum`)을 구하고, 매 턴마다 `Set`에 `add`하여 길이에 상관없이 모든 경우의 수와 중복을 한 번에 해결. |
| Lv.2 | **[모음 사전](https://school.programmers.co.kr/learn/courses/30/lessons/84512)** | **DFS (완전탐색)**. <br> 1. **재귀(Recursion) 설계:** 빈 문자열 `""`부터 시작하여 재료(`A, E, I, O, U`)를 순차적으로 붙여가며 재귀 호출. <br> 2. **탈출 조건:** 단어의 길이(`len`)가 5가 되면 즉시 `return`. <br> 3. **List & indexOf:** 생성된 모든 단어를 전역 변수 `List`에 순서대로 담고, `indexOf(word)`를 통해 인덱스를 찾음 (0부터 시작하므로 정답은 `+1` 처리). 제한사항이 작을 때는 직관적인 완전탐색이 가장 안전한 방법임. |
### Day 40 (2026.02.23) - 정렬의 재발견 & 규칙 찾기

배열을 직접 만들거나 이중 루프를 돌리면 터지는 효율성 문제들을 정렬(Sort), 해시(Hash), 그리고 수학적 규칙(Math)으로 우아하게 해결하는 훈련.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[전화번호 목록](https://school.programmers.co.kr/learn/courses/30/lessons/42577)** | **Sort vs Hash 두 가지 풀이법**. <br> 1. **정렬(Sort) 풀이:** 문자열 배열을 `Arrays.sort()` 하면 비슷한 문자열이 인접하게 정렬됨. `phone_book[i+1].startsWith(phone_book[i])`로 바로 뒷사람과만 비교하여 O(N)으로 최적화. <br> 2. **해시(Hash) 풀이:** `HashSet`에 모든 번호를 넣고, 각 번호를 `substring`으로 쪼개가며 `set.contains(조각)`으로 접두어 존재 여부 확인. |
| Lv.2 | **[n^2 배열 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/87390)** | **Math & 규칙 찾기**. <br> 1. **메모리 초과 방지:** 크기가 최대 천만 단위인 배열을 실제로 생성하면 안 됨. <br> 2. **좌표 역추적:** 1차원 인덱스 `i`를 통해 2차원 좌표를 `row = (int)(i / n)`, `col = (int)(i % n)`으로 구함. <br> 3. **값 규칙:** 해당 칸에 들어가는 숫자는 `Math.max(row, col) + 1`. <br> 4. **자료형 주의:** `left`, `right`가 매우 크므로 순회 시 `long i`를 사용해야 하며, 형변환 캐스팅 위치 주의. |

### Day 39 (2026.02.21) - 홈 오피스 코딩: 슬라이딩 윈도우 & 상태 관리

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[할인 행사](https://school.programmers.co.kr/learn/courses/30/lessons/131127)** | **HashMap & 슬라이딩 윈도우(Sliding Window)**. <br> 1. **타겟 세팅:** `want`와 `number` 배열을 묶어 기준이 되는 `mainMap` 생성. <br> 2. **윈도우 이동:** `discount` 배열을 0부터 `길이 - 10`까지 순회하며 10일 치 창문을 이동. <br> 3. **상태 초기화:** 매 반복마다 `subMap`을 새로 생성(`new HashMap<>()`)하여 이전 루프의 데이터 오염 방지. <br> 4. **비교 치트키:** `mainMap.equals(subMap)`을 사용하여 종류와 개수가 완벽히 일치하는지 한 번에 확인. |
| Lv.2 | **[괄호 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/76502)** | **String(회전) & Stack(올바른 괄호) & 메서드 분리**. <br> 1. **문자열 회전:** `s.substring(1) + s.substring(0, 1)`을 통해 앞글자를 맨 뒤로 보내는 방식 사용. <br> 2. **메서드 분리(Refactoring):** 회전 로직과 괄호 검사 로직을 분리(`isValid` 메서드)하여 코드의 가독성을 높임. <br> 3. **Stack 짝꿍 검사:** 여는 괄호는 `push`, 닫는 괄호는 `peek()`으로 짝꿍(`()`, `{}`, `[]`)이 정확히 맞는지 확인 후 `pop()`. 비어있거나 짝이 다르면 `false` 반환. |

### Day 38 (2026.02.20) - 실무형 자료구조 (Map & LRU)

상태 변화를 추적하고, 제한된 공간에서 데이터를 관리하는 실무 밀접형 로직 훈련.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888)** | **HashMap & Two-Pass 전략**. <br> 1. **1차 순회:** `Enter`, `Change` 이벤트 시 `map.put(id, nickname)`으로 최신 닉네임만 덮어쓰기. <br> 2. **2차 순회:** `Enter`, `Leave` 이벤트 시 `map.get(id)`로 최종 닉네임을 불러와 메시지 리스트(`ArrayList`) 생성. <br> 3. `Leave` 시에는 닉네임 배열(`words[2]`)이 없으므로 `IndexOutOfBounds` 주의. |
| Lv.2 | **[[1차] 캐시](https://school.programmers.co.kr/learn/courses/30/lessons/17680)** | **LRU(Least Recently Used) 알고리즘 & List**. <br> 1. **예외 처리:** `cacheSize == 0`일 때는 캐시가 없으므로 무조건 `길이 * 5` 리턴. <br> 2. **Cache Hit:** 리스트에 존재하면 해당 요소를 `remove()`하고 다시 `add()`하여 **맨 뒤(최신)**로 보냄 (+1). <br> 3. **Cache Miss:** 리스트에 없고 꽉 찼다면(`size >= cacheSize`), **맨 앞(index 0, 가장 오래된 것)**을 `remove(0)`하고 새 요소를 맨 뒤에 `add()` (+5). <br> 4. `String` 불변성 주의: `city = city.toUpperCase();` 처럼 변수에 다시 담아줘야 함. |

### Day 37 (2026.02.19) - 두뇌 부팅: Set과 DP(규칙 찾기)

연휴 복귀 후 가벼운 로직 설계 훈련. 중복 제거와 수열 규칙 발견 감각 회복.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[영어 끝말잇기](https://school.programmers.co.kr/learn/courses/30/lessons/12981)** | **HashSet & Math**. <br> 1. **중복 체크:** `Set`에 등장한 단어를 저장하고 `contains()`로 확인. <br> 2. **순서 계산:** 사람 번호는 `(i % n) + 1`, 차례는 `(i / n) + 1`. (인덱스 보정 주의) |
| Lv.2 | **[멀리 뛰기](https://school.programmers.co.kr/learn/courses/30/lessons/12914)** | **DP (피보나치 수열)**. <br> 1. **규칙 발견:** 1칸(1), 2칸(2), 3칸(3), 4칸(5)... -> 앞의 두 수를 더하면 다음 수가 됨. <br> 2. **점화식:** `dp[i] = (dp[i-1] + dp[i-2]) % 1234567`. <br> 3. **초기화 주의:** `n=1`일 때 예외 처리 및 `dp` 배열 크기(`n+1`) 설정 필수. |

### Day 36 (2026.02.12) - 구현력(Implementation) 끝판왕: 파싱과 해시맵

복잡한 요구사항을 코드로 옮기는 '구현력' 집중 훈련. 문자열 파싱과 자료구조(Map) 활용 능력 강화.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335)** | **String Parsing & Math**. <br> 1. `split("0")`: 0을 기준으로 자르면 복잡한 소수 조건(0P0, P0 등)이 자동 해결됨. <br> 2. `Long.parseLong`: k진수로 변환하면 숫자가 매우 길어지므로 `long` 필수. <br> 3. 소수 판별: `Math.sqrt(n)`까지만 검사하여 효율성 확보 (`num % i == 0`). |
| Lv.2 | **[주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341)** | **Hash Map & Simulation**. <br> 1. **Two Maps Strategy**: `parkingMap`(입차 기록)과 `timeMap`(누적 시간) 분리 관리. <br> 2. **Helper Method**: 시간 문자열("HH:MM")을 분(min)으로 바꾸는 로직을 분리하여 가독성 확보. <br> 3. `Math.ceil`: `(double)` 캐스팅 없이 나누면 소수점이 버려지는 점 주의. |

### Day 35 (2026.02.10) - 구현력 강화: 문자열 파싱과 집합 (샌드박스 훈련 시작)

힌트 없이 스스로 로직을 설계하는 **15분 샌드박스** 훈련 도입. 직관적인 아이디어를 코드로 옮기는 구현력 집중 연습.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[튜플](https://school.programmers.co.kr/learn/courses/30/lessons/64065)** | **String Parsing & Sort**. <br> 1. 집합의 **길이(`s.length()`)** 순서대로 정렬해야 순서를 알 수 있다는 핵심 아이디어 도출. <br> 2. `Set`으로 중복을 체크하며 순서대로 배열에 담기. |
| Lv.2 | **[뉴스 클러스터링](https://school.programmers.co.kr/learn/courses/30/lessons/17677)** | **다중집합(Multi-set) 구현**. <br> 1. 2글자씩 자를 때 인덱스 범위는 `length() - 1`까지. <br> 2. 교집합: `list2.remove(item)`이 `true`면 교집합. <br> 3. 합집합: `(list1 전체) + (list2 남은 것)`으로 최적화 구현. |

### Day 34 (2026.02.09) - BFS & DFS 실전 응용: 흐름을 제어하라

정해진 규칙에 따라 움직이는 시뮬레이션과, 모든 가능성을 열어두는 완전 탐색의 실전 문제 풀이.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[리코쳇 로봇](https://school.programmers.co.kr/learn/courses/30/lessons/169199)** | **BFS + 구현(Simulation)**. <br> 1. 한 칸씩 이동이 아니라, 장애물이나 벽에 부딪힐 때까지 `while`로 미끄러지는 로직 구현. <br> 2. `visited`는 이동 경로가 아닌 **도착(멈춤) 지점**에만 체크해야 함. |
| Lv.2 | **[이모티콘 할인행사](https://school.programmers.co.kr/learn/courses/30/lessons/150368)** | **DFS(Backtracking) + 완전 탐색**. <br> 1. 이모티콘마다 4가지 할인율을 적용하는 모든 경우의 수($4^m$) 탐색. <br> 2. `calculate()` 로직 분리: 장바구니 담기(Loop) -> 예산 비교(Loop 종료 후) -> 최댓값 갱신(전체 종료 후). |

### Day 33 (2026.02.07) - 완전 탐색 & 백트래킹: 컴퓨터를 믿어라

모든 경우의 수를 다 확인하는 완전 탐색(Brute Force)과, 갔던 길을 되돌아오는 백트래킹(Backtracking) 학습.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[피로도](https://school.programmers.co.kr/learn/courses/30/lessons/87946)** | **순열(Permutation) + DFS**. <br> 1. `visited` 배열로 방문 체크. <br> 2. 재귀 호출이 끝나면 `visited = false`로 되돌려(Backtracking) 다른 순서 탐색 가능하게 함. |
| Lv.2 | **[전력망을 둘로 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/86971)** | **완전 탐색 + BFS**. <br> 1. 전선 하나를 끊음 (`map[a][b] = 0`). <br> 2. BFS로 한쪽 네트워크 송전탑 개수(`cnt`) 산출. <br> 3. 전선 복구 (`map[a][b] = 1`) 후 다음 전선으로 이동. |

### Day 32 (2026.02.06) - 그리디 (Greedy): 현재의 최선이 미래의 최선

순간의 선택이 전체 결과에 영향을 미치는 탐욕법(Greedy) 알고리즘 학습. "기준(Criteria)"을 어떻게 세우느냐가 핵심.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[요격 시스템](https://school.programmers.co.kr/learn/courses/30/lessons/181188)** | **구간 스케줄링(Interval Scheduling)** 변형. <br> 1. 미사일의 **끝나는 지점(End)** 기준으로 오름차순 정렬. <br> 2. `start >= lastShot`일 때만 새로 발사하고, 발사 위치는 해당 미사일의 `end`로 설정하여 최대한 겹치게 유도. |
| Lv.2 | **[마법의 엘리베이터](https://school.programmers.co.kr/learn/courses/30/lessons/148653)** | **자릿수 처리 + 조건 분기**. <br> 1. 일의 자리부터 처리하며 0으로 만들기. <br> 2. `digit > 5`: 올림, `digit < 5`: 내림. <br> 3. **`digit == 5`**: 앞자리가 5 이상이면 올림(`>= 5`), 아니면 내림. (연쇄적인 자릿수 올림 효과 고려) |

### Day 31 (2026.02.05) - DP의 정석과 심화 (규칙 찾기)

DP의 가장 기본적인 패턴(누적 합)과 수학적 규칙을 찾아야 하는 심화 유형을 학습함.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.3 | **[정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105)** | **2차원 배열 DP (Top-Down)**. <br> 1. 위층의 왼쪽(`j-1`)과 오른쪽(`j`) 중 큰 값을 선택해 내려오며 더함. <br> 2. `dp[i][j] += Math.max(prev[left], prev[right])` 점화식이 핵심. |
| Lv.2 | **[3 x n 타일링](https://school.programmers.co.kr/learn/courses/30/lessons/12902)** | **수학적 점화식 유도**. <br> 1. 홀수는 불가(0). <br> 2. **기본 규칙:** `dp[i-2] * 3` (3가지 모양). <br> 3. **특수 규칙:** `dp[i-4], dp[i-6]...` 각각 `* 2` (쪼개지지 않는 꼬인 모양). <br> 4. `long` 타입과 나머지 연산 필수. |

### Day 30 (2026.02.02) - BFS 심화 (그래프와 상태 변화)

오늘은 **너비 우선 탐색(BFS)**의 끝판왕 문제들을 다뤘음. 그래프가 눈에 보일 때와 보이지 않을 때(논리적 연결)를 모두 해결하는 능력을 기름.

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.3 | **[가장 먼 노드](https://school.programmers.co.kr/learn/courses/30/lessons/49189)** | **그래프 구현 & 거리 계산**. <br> 1. `ArrayList<ArrayList<Integer>>`로 흩어진 간선 정보를 **인접 리스트**로 정리. <br> 2. `dist[next] = dist[cur] + 1` 공식을 사용해 시작점으로부터 퍼져나가는 물결의 거리를 기록함. |
| Lv.3 | **[단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163)** | **암시적 그래프 탐색 (Implicit Graph)**. <br> 1. 연결선이 없으므로 `canChange(s1, s2)` 함수를 만들어 논리적으로 연결 여부 판단. <br> 2. 큐에 `(단어, 단계)` 객체를 `offer`하는 행위가 곧 **"다음 징검다리로 갈아타는 것"**임을 이해함. |

### Day 29 (2026.01.30) - 고급 도구 장착 (다익스트라 & DP)

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[배달](https://school.programmers.co.kr/learn/courses/30/lessons/12978)** | **다익스트라(Dijkstra)** 알고리즘 입문. <br> 1. `dist` 배열을 무한대로 초기화. <br> 2. `PriorityQueue`로 가장 가까운 노드부터 탐색. <br> 3. `nextTime < dist[next]` 일 때만 갱신(Update)하고 큐에 넣는다. |
| Lv.2 | **[2 x n 타일링](https://school.programmers.co.kr/learn/courses/30/lessons/12900)** | **DP (동적계획법)**. <br> 마지막 타일을 놓는 경우의 수(세로 1개 vs 가로 2개)를 생각하면 **피보나치 수열**(`dp[i] = dp[i-1] + dp[i-2]`)이 된다. <br> 숫자가 크므로 `%` 연산 필수. |

### Day 28 (2026.01.28) - 카카오 기출 (문자열 구현 끝판왕)

| 난이도 | 문제 이름 | 핵심 정리 |
|:---:|:---|:---|
| Lv.2 | **[n진수 게임](https://school.programmers.co.kr/learn/courses/30/lessons/17687)** | `Integer.toString(num, n)`으로 진수 변환. <br> 전체 문자열을 `StringBuilder`로 먼저 다 만들고, 인덱스 규칙(`i += m`)으로 추출. |
| Lv.2 | **[파일명 정렬](https://school.programmers.co.kr/learn/courses/30/lessons/17686)** | `Comparator` 커스텀 정렬. <br> 문자열 파싱은 **"인덱스(위치)"**를 먼저 찾고 `substring`으로 자르는 게 정신 건강에 이롭다. |

### Day 27 (2026.01.27) - 문자열 구현력과 완전탐색 설계

복잡한 문자열 요구사항을 꼼꼼하게 구현하거나, 연속된 수의 합을 찾는 로직을 설계함.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[JadenCase 문자열 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12951)** | [Link](./Day27/JadenCase.java) | `String`, `Flag`, `StringBuilder` <br> 공백 처리가 핵심. `split`보다 한 글자씩 순회하며 `boolean flag`로 다음 글자의 대소문자 여부를 결정하는 것이 안전함. |
| Lv.2 | **[숫자의 표현](https://school.programmers.co.kr/learn/courses/30/lessons/12924)** | [Link](./Day27/NumberExpression.java) | `Brute Force`, `Math` <br> 연속된 자연수의 합. 이중 반복문을 사용하되, 합이 타겟을 넘어가면 즉시 `break`하여 효율성 확보. (투 포인터로 최적화 가능) |

### Day 26 (2026.01.26) - 수학적 규칙과 문자열 파싱

문자열을 숫자로 변환하여 대소 비교를 하거나, 유클리드 호제법을 이용해 GCD/LCM을 구하는 수학적 기초 문제 해결.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[최댓값과 최솟값](https://school.programmers.co.kr/learn/courses/30/lessons/12939)** | [Link](./Day26/MaxMin.java) | `String split`, `Parsing` <br> 공백으로 구분된 문자열을 `split`하여 배열로 만들고, `Integer.parseInt` 후 최소/최대 갱신. |
| Lv.2 | **[N개의 최소공배수](https://school.programmers.co.kr/learn/courses/30/lessons/12953)** | [Link](./Day26/NLCM.java) | `GCD`, `LCM`, `Euclidean Algorithm` <br> 두 수의 최소공배수를 구한 뒤, 그 결과와 다음 수의 최소공배수를 구하는 과정을 반복(누적). |
| Lv.1 | **[최대공약수와 최소공배수](https://school.programmers.co.kr/learn/courses/30/lessons/12940)** | [Link](./Day26/GCDLCM.java) | `Recursion` <br> **유클리드 호제법:** `gcd(b, a % b)` 재귀 호출로 최대공약수를 구하고, `(A * B) / GCD` 공식으로 최소공배수 도출. |

### Day 25 (2026.01.23) - 이진수(Binary)와 API 활용

자바의 내장 함수를 활용해 복잡한 이진수 변환과 비트 계산을 효율적으로 처리함.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[이진 변환 반복하기](https://school.programmers.co.kr/learn/courses/30/lessons/70129)** | [Link](./Day25/BinaryTransformation.java) | `Binary`, `String` <br> `Integer.toBinaryString(len)`: 길이를 이진수 문자열로 변환. <br> `replace("0", "")`로 0 제거 후 길이 차이 계산. |
| Lv.2 | **[다음 큰 숫자](https://school.programmers.co.kr/learn/courses/30/lessons/12911)** | [Link](./Day25/NextBigNumber.java) | `Bit Count`, `Brute Force` <br> **`Integer.bitCount(n)`**: 이진수에서 1의 개수를 반환하는 치트키 함수. <br> 조건을 만족할 때까지 1씩 증가시키며 탐색. |

### Day 24 (2026.01.22) - 문자열 처리 & 좌표 구현

자료구조보다는 직관적인 논리와 구현력이 중요한 문제들. '불순물 제거'와 '발자국 기록' 패턴 학습.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[스킬트리](https://school.programmers.co.kr/learn/courses/30/lessons/49993)** | [Link](./Day24/SkillTree.java) | `String`, `indexOf` <br> 선행 스킬 외의 글자는 모두 제거(Filtering)한 뒤, 남은 문자열이 족보의 0번 인덱스부터 시작하는지 확인. |
| Lv.2 | **[방문 길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994)** | [Link](./Day24/VisitingLength.java) | `Implementation`, `HashSet` <br> 좌표 이동 시 **"A->B"**와 **"B->A"**를 모두 Set에 저장하여 중복된 길(Path) 방문을 방지. |

### Day 23 (2026.01.21) - 힙(Heap) & 시뮬레이션

우선순위 큐를 활용해 '가장 큰 위기'를 막거나 '가장 효율적인 작업'을 선택하는 복합 시뮬레이션 구현.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[디펜스 게임](https://school.programmers.co.kr/learn/courses/30/lessons/142085)** | [Link](./Day23/DefenseGame.java) | `PriorityQueue(Max)`, `Greedy` <br> 일단 막고 나중에 무적권을 사용하는 **'사후 조치'** 전략. 지나간 라운드 중 최댓값을 복구함. |
| Lv.3 | **[디스크 컨트롤러](https://school.programmers.co.kr/learn/courses/30/lessons/42627)** | [Link](./Day23/DiskController.java) | `PriorityQueue(Min)`, `Simulation` <br> **SJF(Shortest Job First)** 스케줄링. 요청 시간순 정렬과 소요 시간순 정렬(Heap)을 조합해 평균 대기 시간을 최소화. |

### Day 22 (2026.01.20) - 힙 (Heap) & 우선순위 큐

데이터가 추가될 때마다 자동으로 정렬을 유지하며, 최댓값이나 최솟값을 $O(\log N)$의 속도로 효율적으로 찾아내는 알고리즘.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.3 | **[야근 지수](https://school.programmers.co.kr/learn/courses/30/lessons/12927)** | [Link](./Day22/OvertimeIndex.java) | `PriorityQueue(Max)`, `Greedy` <br> 제곱의 합을 최소로 만들기 위해 **가장 큰 값**부터 줄임. `reverseOrder()`로 최대 힙 구현. |
| Lv.3 | **[이중우선순위큐](https://school.programmers.co.kr/learn/courses/30/lessons/42628)** | [Link](./Day22/DualPriorityQueue.java) | `Dual PQ`, `remove()` <br> 최댓값/최솟값용 큐를 2개 운영. 한쪽 삭제 시 `remove`로 반대쪽 동기화하는 것이 핵심. |



#### 💡 Today I Learned (TIL)
1. **PriorityQueue의 방향성:** 자바의 기본 `PriorityQueue`는 최소 힙(Min Heap)이다. 최대 힙이 필요하면 `Collections.reverseOrder()`를 반드시 명시해야 한다.
2. **peek()와 poll()의 용도:** 데이터를 실제로 삭제하며 가져올 때는 `poll()`, 삭제하지 않고 값만 확인할 때는 `peek()`를 사용해 데이터 파괴를 방지한다.
3. **쌍권총 전략(Dual PQ):** 하나의 자료구조로 양쪽 끝(최대/최소)을 제어하기 힘들 때, 두 개의 큐를 동기화하여 관리하는 설계 패턴을 익혔다.

### Day 21 (2026.01.19) - 해시 & 그리디 (Hash & Greedy)

`HashMap`을 이용해 데이터의 빈도수를 세고, **종류(Key)**와 **개수(Value)**를 상황에 맞게 비교하는 훈련.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[귤 고르기](https://school.programmers.co.kr/learn/courses/30/lessons/138476)** | [Link](./Day21/Tangerine.java) | `HashMap`, `Sort` <br> 크기별 개수를 세고(`Map`), 개수가 많은 순(`Value 정렬`)으로 담아야 종류가 최소가 됨. |
| Lv.2 | **[롤케이크 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/132265)** | [Link](./Day21/Rollcake.java) | `Map vs Set` <br> 전체(`Map`)에서 하나씩 빼서 상대(`Set`)에게 줌. **0개가 된 Key를 `remove`**하여 `size()`(종류 수)를 비교하는 것이 핵심. |

### Day 20 (2026.01.16) - 동적계획법 (Dynamic Programming)

큰 문제를 작은 문제로 쪼개어 해결하고, 그 결과를 저장(**Memoization**)하여 중복 계산을 피하는 효율적인 알고리즘.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.3 | **[정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105)** | [Link](./Day20/IntegerTriangle.java) | `DP`, `Math.max` <br> 위에서부터 내려오며 자신의 **왼쪽/오른쪽 부모 중 더 큰 값**을 선택해 누적 합을 구함. |
| Lv.2 | **[땅따먹기](https://school.programmers.co.kr/learn/courses/30/lessons/12913)** | [Link](./Day20/Hopscotch.java) | `DP`, `Math.max` <br> **이전 행에서 같은 열을 제외**한 나머지 열 중 최댓값을 더해나가는 방식. `i=1`부터 시작하는 것이 핵심. |

### Day 19 (2026.01.15) - 이분 탐색 (Binary Search)

정답의 범위를 좁혀가며 최적의 해를 찾는 **Up & Down 게임** 방식의 알고리즘.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.3 | **[입국심사](https://school.programmers.co.kr/learn/courses/30/lessons/43238)** | [Link](./Day19/Immigration.java) | `Binary Search`, `Long` <br> 시간을 기준으로 **Up/Down**을 수행. 특정 시간(`mid`) 내에 처리가능한 인원수를 계산하여 범위를 좁힘. |
| Lv.3 | **[징검다리 건너기](https://school.programmers.co.kr/learn/courses/30/lessons/64062)** | [Link](./Day19/SteppingStone.java) | `Parametric Search` <br> 인원수를 기준으로 **Up/Down** 수행. `mid`명이 건널 때 연속된 0인 돌(`skip`)이 `k` 이상이면 불가능 판단. |
### Day 18 (2026.01.14) - 수학 & 구현 (Math & Logic)

복잡한 자료구조 없이, **수학적 규칙(짝수/홀수, 2로 나누기)**을 찾아내어 효율적으로 계산하는 사고력을 기름.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[예상 대진표](https://school.programmers.co.kr/learn/courses/30/lessons/12985)** | [Link](./Day18/ExpectedBracket.java) | `Math` <br> 토너먼트에서 다음 라운드 번호는 **`(n + 1) / 2`** 가 된다는 규칙을 발견하여 반복문으로 해결. |
| Lv.2 | **[점프와 순간 이동](https://school.programmers.co.kr/learn/courses/30/lessons/12980)** | [Link](./Day18/JumpTeleport.java) | `Top-down`, `Modulo(%)` <br> 0 -> N으로 가는 것보다 **N -> 0으로 거꾸로 가는 것**이 훨씬 쉬움. 짝수면 `/2`(순간이동), 홀수면 `-1`(점프). |

### Day 17 (2026.01.13) - 스택/큐 심화 (Simulation & Time)

단순한 데이터 저장을 넘어, **시간의 흐름**을 큐(Queue)로 표현하거나 **과거의 시점**을 스택(Stack)으로 추적하는 심화 기법을 익혔다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[다리를 지나는 트럭](https://school.programmers.co.kr/learn/courses/30/lessons/42583)** | [Link](./Day17/TruckBridge.java) | `Queue`, `Simulation` <br> 다리 위를 큐로 구현. 빈 공간을 **0(공기 트럭)**으로 채워 시간 흐름을 유지하고 무게를 관리함. |
| Lv.2 | **[주식가격](https://school.programmers.co.kr/learn/courses/30/lessons/42584)** | [Link](./Day17/StockPrice.java) | `Stack` <br> 가격이 아닌 **시점(Index)**을 스택에 저장. 가격이 떨어지는 순간 `pop()`하여 **`현재 - 과거`**로 버틴 시간을 계산. |

### Day 16 (2026.01.07) - 탐욕법 (Greedy)

미래를 고려하지 않고, 현재 시점에서 가장 이득이 되는 선택을 반복하여 최적의 해를 찾는 알고리즘.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[구명보트](https://school.programmers.co.kr/learn/courses/30/lessons/42885)** | [Link](./Day16/Lifeboat.java) | `Two Pointers`, `Sorting` <br> 가장 무거운 사람과 가벼운 사람을 짝짓는 것이 이득. 정렬 후 양 끝에서 조여오는 방식 사용. |
| Lv.2 | **[큰 수 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/42883)** | [Link](./Day16/BigNumber.java) | `Greedy`, `StringBuilder` <br> 앞자리에 큰 수가 와야 전체가 커짐. **"내 앞의 숫자가 나보다 작으면 지운다"**는 규칙을 반복 적용. |

### Day 15 (2026.01.06) - 완전탐색 심화 (Brute Force)

단순 반복문을 넘어, 수학적 공식을 세우거나 재귀함수(Recursion)를 이용해 모든 경우의 수를 만드는 심화 기법을 익혔다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.2 | **[카펫](https://school.programmers.co.kr/learn/courses/30/lessons/42842)** | [Link](./Day15/Carpet.java) | `Math Rule` <br> 전체 넓이의 약수를 구하고, **`(가로-2) * (세로-2) == yellow`** 공식을 통해 테두리와 알맹이의 관계를 검증함. |
| Lv.2 | **[소수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/42839)** | [Link](./Day15/PrimeNumber.java) | `Recursion`, `HashSet` <br> 종이 조각을 붙여 숫자를 만드는 순열(Permutation) 구현. **`substring`**으로 사용한 카드를 제외하며 재귀 호출하는 로직이 핵심. |

### Day 14 (2026.01.05) - 완전탐색 (Brute Force)

컴퓨터의 빠른 연산 능력을 이용해 모든 경우의 수를 확인하는 **완전탐색**의 기초를 다졌다. 요령을 피우기보다 **규칙을 찾아 반복문으로 해결**하는 것이 핵심이다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.1 | **[모의고사](https://school.programmers.co.kr/learn/courses/30/lessons/42840)** | [Link](./Day14/MockExam.java) | `Modulo(%)` <br> 반복되는 패턴(수포자의 찍기)을 처리할 때 **나머지 연산(`%`)**으로 인덱스를 무한 순환시키는 테크닉. |
| Lv.1 | **[최소직사각형](https://school.programmers.co.kr/learn/courses/30/lessons/86491)** | [Link](./Day14/MinRectangle.java) | `Idea`, `Math.max/min` <br> 명함을 회전시켜 **"큰 쪽은 가로, 작은 쪽은 세로"**로 몰아넣는 규칙을 발견하는 것이 핵심. 굳이 배열을 새로 만들 필요 없이 `max` 변수 갱신만으로 해결 가능. |

### Day 13 (2026.01.02) - 정렬 심화 (Custom Sort)

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