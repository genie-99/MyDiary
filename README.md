# MyDiary

Codex `diary` 스킬을 공유하기 위한 저장소입니다.

## 포함된 스킬

- `diary/`: 로컬 Codex 스킬 폴더를 그대로 복사한 공유용 스킬
- `diary/SKILL.md`: 스킬 실행 규칙과 GitHub Issue 작성 워크플로
- `diary/agents/openai.yaml`: Codex UI 표시 이름, 설명, 기본 프롬프트

## 설치 방법

이 저장소를 받은 뒤 `diary` 폴더를 Codex 스킬 경로로 복사합니다.

```powershell
Copy-Item -Recurse .\diary $env:USERPROFILE\.codex\skills\
```

이미 같은 이름의 스킬이 있다면 기존 폴더를 백업하거나 삭제한 뒤 복사합니다.

## 사용 방법

Codex에서 다음처럼 요청합니다.

```text
$diary 오늘 공부한 내용을 정리해서 GitHub Issue로 만들어줘
```

스킬은 현재 저장소의 GitHub Issues를 확인해 다음 Diary 번호를 계산하고, 오늘 학습 내용과 프롬프트 기록을 한국어 Issue로 작성합니다.

## 생성 프롬프트 기록

원본 스킬을 처음 만들 때 사용한 정확한 프롬프트는 `diary` 스킬 파일 안에 저장되어 있지 않아 확인할 수 없습니다. 이 저장소에는 확인 가능한 프롬프트 기록을 함께 남깁니다.

### 저장소 공유 요청 프롬프트

```text
내가 diary라는 스킬을 만들었는데 이 스킬을 MYDIARY 폴더에 그대로 추가해서 github에 공유하고 싶어 그리고 어떤 프롬프트로 만들었는지도 함께 README.md에 적어줘
```

### 스킬 기본 실행 프롬프트

```text
Use $diary ?ㅻ뒛 怨듬????댁슜???곸뼱??daily study diary issue瑜?留뚮뱾?댁쨾.
```
