# MyDiary

Codex `diary` 스킬과 GitHub Issue 기반 학습 기록 저장소입니다.

## 포함된 스킬

- `diary/`: 로컬 Codex 스킬 폴더를 공유하기 위해 복사한 스킬
- `diary/SKILL.md`: 스킬 실행 규칙과 GitHub Issue 작성 워크플로
- `diary/agents/openai.yaml`: Codex UI 표시 이름, 설명, 기본 프롬프트

## 설치 방법

이 저장소를 받은 뒤 `diary` 폴더를 Codex 스킬 경로로 복사합니다.

```powershell
Copy-Item -Recurse .\diary $env:USERPROFILE\.codex\skills\
```

이미 같은 이름의 스킬이 있다면 기존 폴더를 백업하거나 삭제한 뒤 복사합니다.

## 사용 방법

### 실행 시점

공부하는 동안에는 평소처럼 질문하고 코드를 실습합니다. 이 과정만으로 `diary`가 자동 발행되지는 않습니다. 학습을 마친 뒤 현재 대화를 기록하고 싶을 때 별도의 메시지로 `$diary`를 호출합니다.

```text
$diary
```

`$diary`를 붙이지 않더라도 “오늘 공부한 내용을 MyDiary에 기록해줘”처럼 학습 기록 발행을 명확하게 요청하면 실행될 수 있습니다. 반면 단순한 개념 질문, 설명 요청, 코드 검토는 학습 기록 발행 요청으로 취급하지 않습니다.

### 학습 메모를 함께 전달하기

현재 대화에 없는 메모를 추가하려면 `$diary` 뒤에 내용을 이어서 작성합니다.

```text
$diary 오늘은 자동회귀 생성, EOS와 최대 토큰 수, Greedy·Sampling 디코딩의 차이를 공부했다.
```

긴 학습 노트도 그대로 붙여 넣을 수 있습니다. 스킬은 현재 대화와 `$diary` 뒤의 메모를 가장 중요한 학습 근거로 사용합니다.

### 관련 저장소를 참고시키기

실습한 저장소가 있다면 확인할 경로를 함께 지정할 수 있습니다.

```text
$diary 오늘 학습 내용과 C:\SSAFY\workspace의 관련 코드를 참고해서 기록해줘.
```

저장소의 코드와 변경 내역은 대화에서 확인한 실습을 보충하는 자료로만 사용됩니다. 파일이 수정됐다는 사실만으로 학습했다고 판단하거나 Issue에 파일 변경 목록을 자동으로 작성하지 않습니다.

### 발행 전 초안만 확인하기

GitHub와 Notion을 바로 수정하지 않고 결과를 먼저 보고 싶다면 초안임을 명시합니다.

```text
$diary 오늘 학습 기록은 발행하지 말고 Issue와 Notion 구성의 초안만 보여줘.
```

### 실행 결과

`$diary`를 실행하면 다음 작업을 수행합니다.

1. 대화와 추가 메모에서 실제로 공부한 주제를 찾습니다.
2. 서로 독립적인 주제마다 정확히 하나의 GitHub Issue 기록을 만듭니다.
3. 같은 날짜와 같은 주제 라벨의 Issue가 있으면 새 Issue를 만들지 않고 기존 Issue에 내용을 병합합니다.
4. 게시된 Issue 링크를 이 README의 학습 Issue 목록에 동기화합니다.
5. Notion `CodingStudy` 캘린더에 같은 Issue를 가리키는 상세 복습 문서를 생성하거나 갱신합니다.
6. 같은 주제의 이전 Issue와 현재 학습을 연결한 Mermaid 학습 지도를 반환합니다.

예를 들어 같은 날 `Java`와 `Spring`을 공부했다면 주제별 Issue가 하나씩 만들어집니다. 같은 날 `AI` 내용을 추가로 공부하고 다시 `$diary`를 호출하면 그날의 기존 `ai` Issue와 Notion 페이지가 확장됩니다.

학습 근거가 대화나 메모에 없으면 내용을 추측해 발행하지 않고 학습 노트를 요청합니다. GitHub 또는 Notion 연결을 사용할 수 없는 경우에는 성공했다고 표시하지 않고 게시 가능한 초안을 제공합니다.

## 학습 Issue 목록

GitHub Issue의 상세 학습 기록을 주제별 링크로 모아 둡니다.

<!-- diary-index:start -->
### Python

- [#65 — DataFrame 필터링에서 결측치·IQR 이상치 처리까지 연결하기](https://github.com/genie-99/MyDiary/issues/65)
- [#60 — 데이터 전처리에서 Matplotlib·Seaborn EDA와 통계 시각화까지 연결하기](https://github.com/genie-99/MyDiary/issues/60)
- [#58 — 기초 문법·HTTP API·NumPy에서 pandas 데이터 분석까지 연결하기](https://github.com/genie-99/MyDiary/issues/58)

### SQL

- [#67 — GROUP BY와 HAVING으로 주문 통계 그룹화하기](https://github.com/genie-99/MyDiary/issues/67)
- [#64 — SELECT 표현식·함수와 집계로 주문 통계 계산하기](https://github.com/genie-99/MyDiary/issues/64)
- [#55 — 조건 조회·정렬·페이징과 NULL 처리 익히기](https://github.com/genie-99/MyDiary/issues/55)
- [#54 — 관계 설계와 안전한 데이터 변경 이해하기](https://github.com/genie-99/MyDiary/issues/54)
- [#53 — CRUD·데이터 타입·무결성 제약조건 이해하기](https://github.com/genie-99/MyDiary/issues/53)

### 빅분기

- [#114 — EDA로 척도·상관·분포에서 고급 데이터 탐색까지 연결하기](https://github.com/genie-99/MyDiary/issues/114)
- [#107 — 데이터 정제에서 변수 선택·차원 축소와 불균형 대응까지 연결하기](https://github.com/genie-99/MyDiary/issues/107)
- [#85 — 데이터 수집·변환에서 분산 저장과 NoSQL 선택까지 연결하기](https://github.com/genie-99/MyDiary/issues/85)
- [#82 — 분석 기획·방법론에서 데이터 확보와 프로젝트 관리까지 연결하기](https://github.com/genie-99/MyDiary/issues/82)
- [#75 — 데이터 이해에서 플랫폼·AI·개인정보 보호까지 연결하기](https://github.com/genie-99/MyDiary/issues/75)

### IntelliJ

- [#40 — 일반 자동완성과 AI 인라인 코드 제안 구분하기](https://github.com/genie-99/MyDiary/issues/40)
- [#31 — 실무 코드 탐색·리팩터링·디버깅 단축키 익히기](https://github.com/genie-99/MyDiary/issues/31)

### Algorithm

- [#117 — DP의 상태·점화식 이해와 두 문제로 구현하기](https://github.com/genie-99/MyDiary/issues/117)
- [#99 — 다익스트라와 우선순위 큐로 최단 경로 계산하기](https://github.com/genie-99/MyDiary/issues/99)
- [#96 — 격자 DFS로 치즈 연결 요소 세기와 인덱스 오류 바로잡기](https://github.com/genie-99/MyDiary/issues/96)
- [#61 — 달팽이 배열의 방향 전환·경계 조건과 반복문 오류 바로잡기](https://github.com/genie-99/MyDiary/issues/61)
- [#52 — 수식 이진 트리 재귀 계산과 Node 표현 이해하기](https://github.com/genie-99/MyDiary/issues/52)
- [#45 — 최대 힙과 PriorityQueue 우선순위 연산 이해하기](https://github.com/genie-99/MyDiary/issues/45)
- [#24 — 완전 이진 트리 배열 표현과 중위 순회로 화분 번호 배치하기](https://github.com/genie-99/MyDiary/issues/24)
- [#23 — 인접 리스트와 DFS로 트리 자손 수 세기](https://github.com/genie-99/MyDiary/issues/23)
- [#16 — HashSet으로 중복 제거 문제 해결하기](https://github.com/genie-99/MyDiary/issues/16)
- [#15 — DFS 완전탐색과 DP 전환 기준 익히기](https://github.com/genie-99/MyDiary/issues/15)
- [#4 — DFS 백트래킹으로 숫자 교환 최대값 탐색하기](https://github.com/genie-99/MyDiary/issues/4)

### Java

- [#93 — synchronized부터 LockSupport·ReentrantLock까지 락과 대기 제어 이해하기](https://github.com/genie-99/MyDiary/issues/93)
- [#91 — interrupt·volatile·synchronized로 스레드 제어와 공유 상태 이해하기](https://github.com/genie-99/MyDiary/issues/91)
- [#90 — join·interrupt·동시성 큐로 스레드 제어 흐름 이해하기](https://github.com/genie-99/MyDiary/issues/90)
- [#89 — Thread 상태 전이와 Runnable 예외 계약·작업 완료 대기 문제 이해하기](https://github.com/genie-99/MyDiary/issues/89)
- [#87 — Thread 생성·실행부터 기본 정보와 생명주기 상태까지 이해하기](https://github.com/genie-99/MyDiary/issues/87)
- [#86 — Reflection·Annotation의 등장 배경부터 런타임 검증·라우팅까지 이해하기](https://github.com/genie-99/MyDiary/issues/86)
- [#84 — JVM 메모리와 스레드 생성·실행·종료 흐름 추적하기](https://github.com/genie-99/MyDiary/issues/84)
- [#81 — 멀티태스킹에서 프로세스·스레드와 작업 유형까지 연결하기](https://github.com/genie-99/MyDiary/issues/81)
- [#73 — Stream 파이프라인과 함수형 데이터 처리 이해하기](https://github.com/genie-99/MyDiary/issues/73)
- [#50 — 인터페이스 다형성과 OCP로 구현 교체 이해하기](https://github.com/genie-99/MyDiary/issues/50)
- [#48 — JDBC·JdbcTemplate·MyBatis의 SQL 실행 역할 구분하기](https://github.com/genie-99/MyDiary/issues/48)
- [#46 — Scanner·BufferedReader·StringTokenizer 입력 처리 구분하기](https://github.com/genie-99/MyDiary/issues/46)
- [#44 — 시험 오답으로 문법·OOP·컬렉션 핵심 바로잡기](https://github.com/genie-99/MyDiary/issues/44)
- [#39 — Annotation과 Meta Annotation 구조 이해하기](https://github.com/genie-99/MyDiary/issues/39)
- [#37 — JSON과 Gson으로 객체 변환 흐름 이해하기](https://github.com/genie-99/MyDiary/issues/37)
- [#36 — LinkedList 구조와 Map 순회 뷰 이해하기](https://github.com/genie-99/MyDiary/issues/36)
- [#27 — Optional·람다식·Stream의 함수형 인터페이스 흐름 이해하기](https://github.com/genie-99/MyDiary/issues/27)
- [#20 — JVM Runtime Data Areas로 메모리 구조 이해하기](https://github.com/genie-99/MyDiary/issues/20)
- [#14 — 제네릭으로 타입 안전성과 재사용성 높이기](https://github.com/genie-99/MyDiary/issues/14)
- [#13 — enum으로 타입 안전한 상수 표현하기](https://github.com/genie-99/MyDiary/issues/13)
- [#12 — Object·equals·hashCode로 객체 동등성 이해하기](https://github.com/genie-99/MyDiary/issues/12)
- [#11 — checked·unchecked 예외와 커스텀 예외 구분하기](https://github.com/genie-99/MyDiary/issues/11)
- [#10 — try/catch와 파일 I/O 예외 처리 이해하기](https://github.com/genie-99/MyDiary/issues/10)
- [#9 — 업캐스팅과 오버라이딩으로 다형성 이해하기](https://github.com/genie-99/MyDiary/issues/9)
- [#8 — 인터페이스 규약과 다중 구현으로 다형성 설계하기](https://github.com/genie-99/MyDiary/issues/8)
- [#6 — 상속과 생성자 체인으로 객체 초기화 이해하기](https://github.com/genie-99/MyDiary/issues/6)

### CS

- [#110 — 파일 디스크립터부터 inode·블록 할당·마운트까지 연결하기](https://github.com/genie-99/MyDiary/issues/110)
- [#101 — 논리 주소 변환부터 요구 페이징·페이지 교체까지 연결하기](https://github.com/genie-99/MyDiary/issues/101)
- [#92 — CPU 버스트와 스케줄링 알고리즘·Linux 정책 연결하기](https://github.com/genie-99/MyDiary/issues/92)
- [#74 — 컴퓨터 구조에서 프로세스 동기화·교착상태까지 연결하기](https://github.com/genie-99/MyDiary/issues/74)
- [#72 — 네트워크 기초에서 HTTP 데이터 전송·API 설계까지 연결하기](https://github.com/genie-99/MyDiary/issues/72)
- [#63 — 스택 포인터와 동기·비동기 인터럽트 처리 흐름 바로잡기](https://github.com/genie-99/MyDiary/issues/63)
- [#57 — 데이터·명령어부터 CPU 핵심 부품과 저장장치 계층까지 이해하기](https://github.com/genie-99/MyDiary/issues/57)
- [#56 — 기술면접을 위한 CS 전체 학습 지도 세우기](https://github.com/genie-99/MyDiary/issues/56)
- [#51 — 포인터와 Java 참조의 메모리 접근 차이 이해하기](https://github.com/genie-99/MyDiary/issues/51)

### HTTP

- [#80 — 캐시 재사용·검증과 프록시 캐시 제어 이해하기](https://github.com/genie-99/MyDiary/issues/80)
- [#78 — 헤더·콘텐츠 협상·전송 방식과 쿠키 이해하기](https://github.com/genie-99/MyDiary/issues/78)
- [#76 — 상태 코드와 리다이렉션·PRG 흐름 이해하기](https://github.com/genie-99/MyDiary/issues/76)

### JPA

- [#49 — ORM·Hibernate·Spring Data JPA 프록시 흐름 이해하기](https://github.com/genie-99/MyDiary/issues/49)
- [#42 — ORM·JPA와 웹·Repository의 역할 구분하기](https://github.com/genie-99/MyDiary/issues/42)

### Spring · Gradle · Frontend · Git

- [#118 — 생성자 주입과 Lombok으로 필수 의존성 안전하게 고정하기](https://github.com/genie-99/MyDiary/issues/118)
- [#113 — 네 가지 자동 주입과 선택 옵션 동작 검증하기](https://github.com/genie-99/MyDiary/issues/113)
- [#109 — 컴포넌트 스캔·자동 주입과 Bean 충돌 이해하기](https://github.com/genie-99/MyDiary/issues/109)
- [#106 — BeanDefinition·싱글톤과 @Configuration CGLIB 동작 연결하기](https://github.com/genie-99/MyDiary/issues/106)
- [#105 — Bean 조회·컨테이너 계층과 Java·XML 설정 메타데이터 연결하기](https://github.com/genie-99/MyDiary/issues/105)
- [#104 — AppConfig로 SRP·DIP·OCP와 IoC·DI·Spring 컨테이너 연결하기](https://github.com/genie-99/MyDiary/issues/104)
- [#100 — 회원 가입부터 주문 생성·출력까지 객체 협력과 구현 의존 추적하기](https://github.com/genie-99/MyDiary/issues/100)
- [#97 — EJB에서 다형성·SOLID·POJO·IoC/DI와 Spring Boot까지 연결하기](https://github.com/genie-99/MyDiary/issues/97)
- [#71 — 서버·Tomcat·JAR/WAR에서 HTTP 학습 방향 잡기](https://github.com/genie-99/MyDiary/issues/71)
- [#70 — JDK·Gradle JVM과 Java Toolchain 역할 구분하기](https://github.com/genie-99/MyDiary/issues/70)
- [#69 — 서블릿 스레드부터 MVC·SSR·WebFlux까지 연결하기](https://github.com/genie-99/MyDiary/issues/69)
- [#47 — MVC 요청 매핑과 트랜잭션 설정 흐름 이해하기](https://github.com/genie-99/MyDiary/issues/47)
- [#41 — Bean 등록·컴포넌트 스캔·생성자 DI 연결하기](https://github.com/genie-99/MyDiary/issues/41)
- [#38 — 라이브러리·JAR·의존성 관리 흐름 이해하기](https://github.com/genie-99/MyDiary/issues/38)
- [#26 — 회원 도메인·계층 분리·인터페이스 기반 DI 이해하기](https://github.com/genie-99/MyDiary/issues/26)
- [#25 — XML·JSON과 @ResponseBody 메시지 변환 흐름 이해하기](https://github.com/genie-99/MyDiary/issues/25)
- [#22 — 빌드 도구·의존성·Gradle Wrapper 이해하기](https://github.com/genie-99/MyDiary/issues/22)
- [#21 — Spring Boot 프로젝트 구조와 내장 Tomcat 이해하기](https://github.com/genie-99/MyDiary/issues/21)
- [#19 — Leaflet 기반 서울 관광 지도 구조 분석하기](https://github.com/genie-99/MyDiary/issues/19)
- [#18 — fetch·pull·push와 GitHub CLI 인증 흐름 익히기](https://github.com/genie-99/MyDiary/issues/18)
- [#5 — Spring MVC와 Thymeleaf 요청·화면 흐름 이해하기](https://github.com/genie-99/MyDiary/issues/5)

### Design Patterns

- [#7 — Strategy와 Template Method로 역할 분리하기](https://github.com/genie-99/MyDiary/issues/7)

### AI · Codex

- [#115 — 온디바이스 AI 하드웨어·정수 양자화·현실 적응과 LoRA 실습 연결하기](https://github.com/genie-99/MyDiary/issues/115)
- [#116 — 수 체계에서 GPU 저정밀 연산과 모델 경량화·양자화·PEFT까지](https://github.com/genie-99/MyDiary/issues/116)
- [#111 — LangGraph Planner-Worker·Reflection 전체 코드 구현](https://github.com/genie-99/MyDiary/issues/111)
- [#108 — Agent 4대 구성요소에서 Direct·ReAct Graph와 가드레일까지 연결하기](https://github.com/genie-99/MyDiary/issues/108)
- [#103 — LLM·RAG에서 Agent 추론·협업·Deep Research까지 연결하기](https://github.com/genie-99/MyDiary/issues/103)
- [#102 — IR·RAG에서 LLM Agent의 환경·계획·Tool·MCP·LangChain까지 연결하기](https://github.com/genie-99/MyDiary/issues/102)
- [#98 — RNN 한계에서 Transformer 기반 멀티모달 실습까지 연결하기](https://github.com/genie-99/MyDiary/issues/98)
- [#95 — PyTorch·ResNet에서 VLM·온디바이스·생성형 비전까지 연결하기](https://github.com/genie-99/MyDiary/issues/95)
- [#88 — CNN 계열에서 RNN·Attention·ViT까지 데이터 구조와 모델 변천 이해하기](https://github.com/genie-99/MyDiary/issues/88)
- [#83 — TorchVision 데이터 증강·합성 데이터와 LLM Judge 품질 필터링](https://github.com/genie-99/MyDiary/issues/83)
- [#79 — 토큰화부터 파운데이션 모델의 생성·평가·합성 데이터·안전까지 연결하기](https://github.com/genie-99/MyDiary/issues/79)
- [#77 — 워드 임베딩·RNN에서 Transformer와 사전학습 모델까지 연결하기](https://github.com/genie-99/MyDiary/issues/77)
- [#68 — sklearn 검증에서 MNIST 신경망 학습·저장·추론까지 연결하기](https://github.com/genie-99/MyDiary/issues/68)
- [#66 — 회귀·신경망에서 경사하강·역전파까지 연결하기](https://github.com/genie-99/MyDiary/issues/66)
- [#62 — 지도학습 평가에서 교차검증·비지도 군집화까지 연결하기](https://github.com/genie-99/MyDiary/issues/62)
- [#59 — Context·RAG·Agent에서 Responses API까지 연결하기](https://github.com/genie-99/MyDiary/issues/59)
- [#17 — LLM·RAG·Agentic AI 작동 구조 이해하기](https://github.com/genie-99/MyDiary/issues/17)
- [#3 — 공유 가능한 $diary 스킬과 Issue 워크플로 만들기](https://github.com/genie-99/MyDiary/issues/3)
- [#2 — 학습 기록을 남기는 $diary 스킬 설계하기](https://github.com/genie-99/MyDiary/issues/2)
- [#1 — Agentic AI 프로젝트 아이디어를 학습 과제로 구체화하기](https://github.com/genie-99/MyDiary/issues/1)
<!-- diary-index:end -->

## 생성 프롬프트 기록

원본 스킬을 처음 만들 때 사용한 정확한 프롬프트는 `diary` 스킬 파일 안에 저장되어 있지 않아 확인할 수 없습니다. 이 저장소에는 확인 가능한 프롬프트 기록을 함께 남깁니다.

### 저장소 공유 요청 프롬프트

```text
내가 diary라는 스킬을 만들었는데 이 스킬을 MYDIARY 폴더에 그대로 추가해서 github에 공유하고 싶어 그리고 어떤 프롬프트로 만들었는지도 함께 README.md에 적어줘
```

### 스킬 개선 요청 프롬프트

```text
맞다 C 파일에서 SSAFY폴더를 참고해서 수정사항이 있으면 참고해달라는 내용을 skill에 추가해주고 프롬프트도 같이 넣어달라고 수정해줘
```

### 같은 날짜 Issue 추가 작성 요청 프롬프트

```text
만약 github issue확인했을때 날짜가 같으면 같은 날짜에 있는 내용에 추가해서 작성해줘
```

### 스킬 기본 실행 프롬프트

```text
Use $diary 오늘 학습 내용과 C:\SSAFY workspace의 관련 수정사항을 확인해서 daily study diary issue를 만들어줘.
```
