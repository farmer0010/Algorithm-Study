# 업데이트 워크플로우

이 문서는 `docs/progress.md`를 이용해 훈련 세션을 이어가는 방법을 설명합니다.

## 파일 역할

| 파일 | 역할 |
|---|---|
| `docs/progress.md` | 학습 진행 상황, Day별 기록, 취약 포인트 목록. |

## 세션 종료 시 절차

1. 훈련이 끝나면 그날의 갱신 내용(Day 진행 상황, 새로 발견한 취약 포인트 등)을 정리한다.
2. `docs/progress.md`를 갱신 내용으로 수정한다.
3. 변경 사항을 git commit한다.
   ```
   git add docs/progress.md
   git commit -m "Day N 진행 상황 업데이트"
   ```
4. (claude.ai 프로젝트를 함께 쓰는 경우) 프로젝트 화면의 GitHub 연결 부분에서 **Sync** 버튼을 눌러 최신 커밋을 반영한다.

## 참고

- GitHub 연동은 실시간 자동 동기화가 아니라 수동 Sync입니다. 커밋 후 Sync 버튼을 눌러야 최신 내용이 프로젝트 지식에 반영됩니다.
