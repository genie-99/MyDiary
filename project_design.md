# 프로젝트 설계: Agentic AI 기반 주식 포트폴리오 트래커 (Stock Portfolio Tracker)

이 문서는 Agentic AI를 활용해 구현할 주식 포트폴리오 분석 및 추적 도구의 설계서입니다.

## 1. 프로젝트 개요
사용자가 입력한 주식 포트폴리오 정보를 바탕으로 AI 에이전트가 현재 자산 현황을 분석하고 개선 포인트를 제안하는 시스템입니다.

## 2. 시스템 아키텍처 (Mermaid)

```mermaid
flowchart TD
    User([사용자]) -->|1. 포트폴리오 정보 입력 (JSON/CSV)| Agent[AI Portfolio Agent]
    Agent -->|2. 실시간 주가 API 요청| StockAPI[(주식 정보 API)]
    StockAPI -->|3. 가격 및 시세 리턴| Agent
    Agent -->|4. 자산 배분 상태 & 개선 제안 생성| Analyzer[LLM Analyzer]
    Analyzer -->|5. 투자 보고서 피드백 리턴| Agent
    Agent -->|6. 최종 보고서 및 시각화| User
```

## 3. 구현 단계 (Steps)
1. **환경 설정**: Python 또는 Node.js 환경에서 필요한 패키지(`yfinance`, `pandas`, LLM SDK 등) 설정
2. **포트폴리오 입력 파서**: 사용자의 자산 정보(종목명, 수량, 평균 매입가) 파싱 엔진 개발
3. **시장 데이터 수집**: 외부 API를 연동하여 실시간 주식 데이터 획득
4. **AI 분석 프롬프트 작성**: 포트폴리오 다각화 지표, 자산 비중 불균형 상태 등을 분석할 LLM 프롬프트 디자인
5. **보고서 생성**: 마크다운 형식으로 분석 리포트 출력
