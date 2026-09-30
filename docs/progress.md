# 진행 현황

## 현재
- **Day 149** (2026.09.30) 완료 — 국민은행 코테 대비 2일차 (시험 10/3 토, 이번 주는 코테 특화 훈련)
- 오늘 알고리즘 8문제 전부 통과. SQL은 미진행(저녁에 진행 예정)

## 최근 5일 요약
- Day 149: 서버 증설 횟수, 프렌즈4블록, 최소직사각형, 소수 찾기, 피로도, 타겟 넘버, 네트워크, 게임 맵 최단거리 — 구현·시뮬레이션·완전탐색·DFS/BFS 한 번씩 재점검
- Day 148: 파일명 정렬(Lv.2), 숫자 문자열과 영단어, 모의고사, 신규 아이디 추천, 큰 수 만들기(재풀이). 스킬체크 할인 행사 50/50(해시+슬라이딩 윈도우). SQL 6문제(ORDER BY+LIMIT, IS NULL, GROUP BY, HAVING, IFNULL, LEFT JOIN+IS NULL)
- Day 147: 배열 원소 곱의 최솟값, 정수 내림차순으로 배치하기, 다트 게임
- Day 146: 문자열을 정수로 바꾸기, 달리기 경주 (스킬체크)
- Day 145: 배열에서 최솟값 제거하기, 인접한 같은 색 칸 개수 세기 (스킬체크)

## 반복되는 약점
- off-by-one: 종료 조건, "최대 N개", 이상/이하를 부등호로 옮길 때 `=` 여부 (Day148~149에 반복)
- 인덱스 경계: `length` vs `length()`, 범위 체크 순서, 좌표계(0-based) 통일
- 루프 종료 후 남은 상태 처리 (예: 큰 수 만들기의 남은 k)
- 재귀 결과 모으기: 지역 변수는 공유되지 않음 (필드 또는 반환값), 방문 표시 되돌릴 때와 아닐 때 구분
- SQL: 문제의 정렬 조건 놓치기, WHERE와 HAVING 자리

## 이번 주 남은 계획 (시험 10/3 토)
- 수(오늘): SQL JOIN·문자열·정규식·GROUP_CONCAT
- 목: 다익스트라, 해시·문자열 파싱, 계좌이체형 시뮬레이션(신고 결과 받기, 오픈채팅방), 서버 증설·프렌즈4블록 재풀이
- 금: 120분 모의고사 (알고리즘 3 + SQL 1), 오답 복습 후 일찍 취침

## 보류/대기
- 도로 블록 문제 (스킬체크, "범위가 크면 물어본 구간만 계산"): 추후 과제
- 사라지는 발판 (Lv.3): 보류
- Lv.4 신규 문제는 사용자가 먼저 신호를 줄 때까지 배치하지 않음 (Day139 지침 유지)

## 신규 지침 (Day132~139)
- **[Day130 신규 지침]** 문제 선정 직후, check_List 확인만으로 끝내지 말고 반드시 project_knowledge_search로 실제 미풀이 여부를 검증한 뒤 세트를 확정할 것.
- **[Day132 신규 지침]** PCCP류 문제는 "코딩테스트 연습" 검색으로 안 나올 수 있음 — 코스 페이지 직접 링크 안내할 것.
- **[Day134 신규 지침]** 상태 공간(visit)을 확장할 때는, 확장 직후 "초기화 / 범위체크 / 방문마킹 / 큐 삽입값"의 4곳을 순서대로 훑어 누락된 지점이 없는지 체크하는 습관을 세션 도입부에서 짚어줄 것.
- **[Day136 신규 지침]** Lv.4 이상 문제는 제약조건에 "전체 길이의 합" 같은 숨은 제한이 있는 경우가 많음 — 최악의 경우를 계산할 때 빠짐없이 검색해서 확인할 것. 새 Map/컬렉션 API가 처음 등장할 때는 사용 전에 시그니처를 먼저 명확히 짚어줄 것.
- **[Day139 신규 지침]** 사용자가 Lv.4 진입 보류를 명시적으로 요청한 이상, 코치가 판단하는 "재검토 기준 충족 여부"와 무관하게 사용자가 먼저 신호를 줄 때까지 Lv.4 신규 문제는 세트에 배치하지 않는다. 반복문/큐 등 자료구조를 활용한 시뮬레이션 문제에서는 "이 자료구조의 어떤 속성이 고정이고 어떤 속성이 변하는지"를 도입부에서 먼저 짚어주는 것이 종료조건 설계 실수를 줄이는 데 효과적일 수 있음.

## 파일 매핑

### 파일 매핑 (Day139)
- Day139/NumberStringAndWord.java — 숫자 문자열과 영단어 (Lv.1)
- Day139/TruckBridge.java — 다리를 지나는 트럭 (Lv.2, 블라인드 재도전)
- 다음 세션으로 이월: 사라지는 발판 (Lv.3)

### 파일 매핑 (Day140)
- Day140/KeypadPress.java — 키패드 누르기 (Lv.1)
- Day140/StrangeCharacter.java — 이상한 문자 만들기 (Lv.1)
- Day140/StringHandlingBasic.java — 문자열 다루기 기본 (Lv.1)

### 파일 매핑 (Day141)
- Day141/ReverseTernary.java — 3진법 뒤집기 (Lv.1)
- Day141/PYCount.java — 문자열 내 p와 y의 개수 (Lv.1)

### 파일 매핑 (Day142)
- Day142/ReverseNumberArray.java — 자연수 뒤집어 배열로 만들기 (Lv.1)
- Day142/PhysicalEducationUniform.java — 체육복 (Lv.1)
- Day142/AddMissingNumber.java — 없는 숫자 더하기 (Lv.1)

### 파일 매핑 (Day143)
- Day143/RemoveDuplicateCharacter.java — 중복된 문자 제거 (Lv.0)
- Day143/StringDescendingOrder.java — 문자열 내림차순으로 배치하기 (Lv.1)
- Day143/StockPrice.java — 주식 가격 (Lv.2, 블라인드 재도전)

### 파일 매핑 (Day144)
- Day144/Parallel.java — 평행 (Lv.0)
- Day144/PickTwoAndAdd.java — 두 개 뽑아서 더하기 (Lv.1)
- Day144/SchoolRoad.java — 등굣길 (Lv.3, 블라인드 재도전)

### 파일 매핑 (Day145)
- Day145/RemoveMinNumber.java — 배열에서 최솟값 제거하기 (Lv.1, 스킬체크)
- Day145/AdjacentSameColor.java — 인접한 같은 색 칸 개수 세기 (Lv.1, 스킬체크)

### 파일 매핑 (Day146)
- Day146/StringToInteger.java — 문자열을 정수로 바꾸기 (Lv.1, 스킬체크)
- Day146/RunningRace.java — 달리기 경주 (Lv.2, 스킬체크)

### 파일 매핑 (Day147)
- Day147/MinProductSum.java — 배열 원소 곱의 최솟값 (Lv.2, 스킬체크)
- Day147/IntegerDescendingOrder.java — 정수 내림차순으로 배치하기 (Lv.1)
- Day147/DartGame.java — 다트 게임 (Lv.1)

### 파일 매핑 (Day148)
- Day148/FileNameSort.java — [3차] 파일명 정렬 (Lv.2, Day147 미완주 항목 재도전)
- Day148/NumberStringAndEnglishWords.java — 숫자 문자열과 영단어 (Lv.1)
- Day148/MockExam.java — 모의고사 (Lv.1)
- Day148/NewIdRecommendation.java — 신규 아이디 추천 (Lv.1)
- Day148/MakeBigNumber.java — 큰 수 만들기 (Lv.2, 재풀이, 스택 그리디)

### 파일 매핑 (Day149)
- Day149/ServerExpansionCount.java — 서버 증설 횟수 (Lv.2)
- Day149/Friends4Block.java — 프렌즈4블록 (Lv.2)
- Day149/MinimumRectangle.java — 최소직사각형 (Lv.1)
- Day149/FindPrimeNumber.java — 소수 찾기 (Lv.2)
- Day149/FatigueDungeon.java — 피로도 (Lv.2)
- Day149/TargetNumber2.java — 타겟 넘버 (Lv.2)
- Day149/Network.java — 네트워크 (Lv.3)
- Day149/GameMapShortestPath.java — 게임 맵 최단거리 (Lv.2)
