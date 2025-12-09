# 🔥 Java Algorithm Study

매일 꾸준히 알고리즘 문제를 풀고 기록합니다.

## 📚 학습 목표
- **언어:** Java 11+
- **목표:** 하루 1문제 이상 풀기 & 효율적인 자료구조 고민하기
- **기간:** 2023.12.XX ~ (진행중)

---

## 📅 Daily Log

### Day 1 (2023.12.08) - 자료구조 기초 (List, Set)

오늘은 **ArrayList**와 **HashSet**의 차이점을 이해하고, 상황에 맞게 골라 쓰는 연습을 했다.

| 난이도 | 문제 이름 | 풀이 코드 | 키워드 / 핵심 정리 |
|:---:|:---|:---:|:---|
| Lv.1 | **[같은 숫자는 싫어](https://school.programmers.co.kr/learn/courses/30/lessons/12906)** | [Link](./Programmers/Level1/HateSameNumber.java) | `ArrayList` <br> `contains()`는 O(n)이라 느림. 직전 값(`get(size-1)`)과 비교하여 O(1)로 처리. |
| Lv.1 | **[폰켓몬](https://school.programmers.co.kr/learn/courses/30/lessons/1845)** | [Link](./Programmers/Level1/Ponketmon.java) | `HashSet` <br> 중복 제거가 핵심. `Math.min(max, typeCount)` 로직 활용. |
| Lv.1 | **[제일 작은 수 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12935)** | [Link](./Programmers/Level1/RemoveSmallestNumber.java) | `Collections.min()` <br> `remove(int index)`와 `remove(Object value)` 혼동 주의. |
| Lv.1 | **[두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644)** | [Link](./Programmers/Level1/PickTwoAndAdd.java) | `HashSet` → `List` <br> 이중 for문(`j=i+1`), `Set`으로 중복 제거 후 `List.sort()` 정렬. |

#### 💡 Today I Learned (TIL)
1. **ArrayList 제거의 함정:** 숫자를 제거할 때 `remove(10)`을 하면 10번째 인덱스가 지워짐. 값을 지우려면 `remove(list.indexOf(10))` 처럼 인덱스를 찾아야 함.
2. **Set의 위력:** 중복을 제거해야 할 때는 고민하지 말고 `HashSet`을 쓰자.
3. **배열 반환 패턴:** `ArrayList`로 로직을 수행하고 마지막에 `new int[list.size()]`로 변환해서 리턴하는 패턴에 익숙해짐.

---
