---
name: diary
description: Create or extend date-and-topic Korean study GitHub Issues with the user's meaningful work prompts, update a README learning index, and write layered, beginner-friendly, subject-tagged Notion CodingStudy reviews that teach verified concepts through a core summary, connected flow, plain-language definitions, reasons, inputs and outputs, examples, execution walkthroughs, and misconception corrections. Reuse an existing same-date Issue with the same subject label instead of creating a duplicate. Use when the user invokes `$diary`, asks for a study diary or learning retrospective, wants learning organized into labelled Issues and learning maps, or asks to add study records to MyDiary or CodingStudy.
---

# Diary

Turn the user's learning into durable, topic-focused GitHub Issues with their meaningful work prompts, a README learning index, and detailed subject-tagged review documents in the Notion CodingStudy calendar. Treat the conversation as the primary evidence of what the user actually studied.

## Source of Truth

1. Read the current conversation and any text after `$diary` first. Use it as the authoritative learning evidence.
2. Use explicit user notes, prompts, commands, exercises, and repository changes only to support or clarify that evidence. Do not create a `수정한 파일` section and do not treat a changed file as proof of learning by itself.
3. Never present an inferred or advanced topic as something the user completed. Label it as additional learning material.
4. If no study topic is supported by the conversation or the user's notes, ask for study notes rather than inventing an Issue.

## Workflow

1. Determine the local date, preferring Asia/Seoul when it is available.
2. Read the conversation, `$diary` trailing text, and any user-provided study notes. Collect concrete evidence such as the concept discussed, a question asked, an exercise attempted, a conclusion reached, and the meaningful prompts that directed the work.
3. Optionally inspect the current repository with `git status`, `git log`, and a targeted diff when it helps verify an exercise. Do not include a file-change inventory in the Issue body.
4. Split the learning into independent, stable subjects. Produce exactly one Issue record per subject in the current diary run, either by updating the matching daily Issue or creating one when absent.
   - For example, Java + Spring + HTML produces three Issues, not one combined Issue.
   - Keep dependent detail in its parent subject: Spring DI and Spring IoC belong in `spring`, not separate `di` and `ioc` Issues.
   - Use a specific subject only when it is genuinely independent and likely to recur, such as `jpa`, `thymeleaf`, or `sql`.
5. For each subject, choose exactly one lower-case GitHub label (for example `java`, `spring`, `html`, `jpa`, or `testing`). List repository labels first; reuse a matching label or create the missing label with a short Korean description.
6. Before writing, inspect all open and closed Issues with the exact subject label. If an Issue already represents the same Asia/Seoul date and label, update that Issue instead of creating another one. If multiple matches already exist, use the most recently updated Issue as the canonical daily record, report the duplicates, and do not create or close an Issue automatically.
7. Give each Issue a title that exposes both the subject and the overall learning outcome:

   ```text
   [Spring] 2026-07-25 — IoC와 DI로 객체 의존성 이해하기
   ```

   - Use the human-readable subject in the bracket and the exact label in GitHub metadata.
   - Replace the example's date and outcome with the current subject's actual content.
   - Avoid vague titles such as `Spring 공부` or a title that combines unrelated subjects.
8. Write a Korean Issue body using the template below. Keep it concise and factual. Add one `심화 확장` section with useful next-level context that builds naturally on the topic.
   - Draw advanced material from stable knowledge or authoritative documentation when current behavior, versions, or library APIs matter.
   - Explain why the advanced material matters, but clearly mark it as a next step rather than evidence of completed learning.
9. Publish each subject with its one label. Update the canonical same-date Issue when one exists; create a new Issue only when none exists. When updating, preserve earlier verified content and prompts, merge new evidence into the matching sections, remove exact or near-duplicate bullets, and widen the title outcome only when the combined learning requires it. If GitHub publication is unavailable, return every exact title, label, and body as a draft; do not claim an Issue was created or updated.
10. After publication, inspect earlier open and closed learning Issues with each subject label. Build and return a Mermaid learning map that connects the current daily Issue to verified prior Issue concepts. If no earlier Issue exists, show the current Issue as the starting node.
11. After every successfully created or updated Issue, add or synchronize its link in the MyDiary repository's `README.md` learning index as described below. Do not update it for drafts or failed publication.
12. After every successfully created or updated Issue, add or update a matching page in the Notion CodingStudy calendar, classify it with the exact study-subject tag, and write a detailed, review-focused learning document as described below. Do not copy the Issue workflow template verbatim. A Notion failure must not undo or conceal a successful GitHub publication; report the two outcomes separately.

## Issue Body Template

```md
## 오늘의 주제
- {subject}

## 오늘 공부한 내용
- {conversation and note evidence, organized as concepts or outcomes}

## 대화에서 확인한 학습 근거
- {brief paraphrase of a user question, note, exercise, or conclusion}

## 사용한 프롬프트
- {the user's meaningful prompt that requested the learning or work}

## 핵심 정리
- {the most important concept, distinction, or pitfall}

## 심화 확장
- {advanced next step}: {why it follows from today's topic and what to study next}

## 다음 학습
- {one or two concrete next actions}
```

- Include `## 사용한 프롬프트` with the user's direct, meaningful prompts from this learning run. Preserve the Korean wording when practical; for a long prompt, shorten only background detail while preserving the requested action.
- Include the `$diary` prompt when it contains learning notes or an explicit instruction.
- Do not include assistant messages, tool commands, internal reasoning, or unrelated conversational remarks as prompts.
- Do not add `## 수정한 파일` or a raw diff.
- Do not include unrelated repository work simply because it happened on the same date.
- Use actual user wording only when a short quote preserves an important distinction; otherwise paraphrase it.

## GitHub Issue Handling

1. Confirm that `gh` is available, authenticated, and points to the intended repository. If it cannot be confirmed, provide drafts instead of publishing.
2. List existing labels before creating any. Create only the missing stable subject labels.
3. Use exactly one subject label. Do not attach incidental labels such as `diary` or `study` unless the user explicitly requests them.
4. Before publication, query open and closed Issues with the exact label and compare the date in each title with the current Asia/Seoul date.
5. If a same-date, same-label Issue exists, fetch its full title and body and update it in place:
   - Preserve all earlier verified learning content and meaningful prompts.
   - Merge new material into the existing template sections instead of appending a second full template.
   - Deduplicate repeated concepts, evidence, prompts, and next actions.
   - Keep the bracketed subject and date stable; revise only the outcome phrase when needed to represent the combined record.
   - Never overwrite user-authored material that is unrelated to the synchronized diary sections.
6. If multiple same-date, same-label Issues exist, select the most recently updated one as the canonical target, report the other matching Issue numbers, and do not create, close, or merge them automatically.
7. Create a new Issue only when no same-date, same-label Issue exists.
8. Report whether each Issue was created or updated, followed by its number, URL, title, and label.

## README Issue Index

After successful Issue creation or update, add or synchronize its GitHub Issue link in the README learning index.

1. Keep the repository's existing documents and unrelated README sections intact.
2. Update only the content between these markers in `README.md`; create the marker block under `## 학습 Issue 목록` when it does not exist.

   ```md
   <!-- diary-index:start -->
   <!-- diary-index:end -->
   ```

3. Add one Markdown bullet under the matching human-readable subject heading: `- [#{issue number} — {Issue title without bracketed subject and date}](Issue URL)`. If the URL already exists but the Issue title changed, update that bullet's text in place.
4. Create a subject heading only when it does not exist. Keep new entries at the top of that subject's list.
5. Make the README update idempotent. If the Issue URL is already present in the marker block, do not add a duplicate; synchronize only stale link text when necessary.
6. Keep only Issue links in this marker block. Do not add summaries, Obsidian wiki links, Mermaid diagrams, prompts, or repository change inventories unless the user specifically asks for them.
7. If the repository is unavailable or the Issue was only drafted, leave `README.md` unchanged and explain why.

## Notion CodingStudy Calendar

After each successful Issue creation or update, create or update one matching calendar page in the connected Notion workspace.

1. Target the `CodingStudy` database under the `Coding` page:
   - Database ID: `39ae65da-cd3d-8072-87eb-dad6ef5a8fd2`
   - Data source ID: `collection://39ae65da-cd3d-808d-8c54-000b321a131a`
   - Calendar view: `캘린더(날짜) 보기`
2. Fetch the database before writing and confirm that it is still named `CodingStudy`, its parent is `Coding`, and the required properties still exist. Do not create a replacement database or alter its schema when validation fails.
3. Before creating a page, query or search the data source for the same `원문 링크`. If a page already has that Issue URL, update missing or stale mapped properties and synchronize the study-note body instead of creating a duplicate.
4. Map the published Issue to these properties:
   - `이름`: the GitHub Issue title with the date segment removed. For example, map `[Spring] 2026-08-04 — IoC와 DI로 객체 의존성 이해하기` to `[Spring] IoC와 DI로 객체 의존성 이해하기`.
   - `date:날짜:start`: the diary run's Asia/Seoul date in `YYYY-MM-DD`
   - `date:날짜:is_datetime`: `0`
   - `요약`: one concise Korean sentence stating the subject's main learning outcome
   - `원문 링크`: the GitHub Issue URL
   - `태그`: exactly one human-readable study-subject option derived from the bracketed Issue subject, such as `["SQL"]`, `["CS"]`, `["Java"]`, `["Spring"]`, `["JPA"]`, or `["AI"]`
   - Page icon: set an emoji separately from the database properties when creating a page. Use the stable subject mapping `AI → 🤖`, `Spring → 🌱`, `Java → ☕`, `Python → 🐍`, `CS → 🧠`, `Testing → 🧪`, `HTML/CSS/JavaScript/Web → 🌐`, and `SQL/JPA/Database → 🗄️`; use `📚` for an unmapped study subject. When updating, preserve a user-chosen icon and fill the icon only when it is absent or clearly AI-managed.
5. Keep the date only in the `날짜` property so the page appears on the correct calendar date. Never repeat the date in the Notion page title.
6. Use only the subject in `태그`. Never add generic workflow or document-type values such as `개념정리`, `회고`, `학습`, or `diary`, and do not set or synchronize `분석 종류` as part of the diary workflow.
7. Ensure the subject tag exists before creating or updating the page:
   - Match existing tag options case-insensitively and reuse their exact stored spelling when the subject is already present.
   - Otherwise add the bracketed human-readable subject as a new `태그` multi-select option. Preserve every existing option and its color; never drop, rename, or repurpose unrelated options while adding the subject.
   - If the schema tool requires redefining the complete multi-select option list, reconstruct all current options unchanged and append only the new subject option. If safe preservation cannot be guaranteed, do not modify the schema or page; report the Notion result as a draft with the required tag.
   - Existing diary pages found by `원문 링크` must replace stale generic or multi-value `태그` values with exactly the current subject tag, while leaving `분석 종류` unchanged.
8. Write a dedicated Korean teaching document instead of copying the GitHub Issue body verbatim. Expand only verified studied material from the conversation and Issue. Organize it in layers so a later reader can first recover the core quickly and then understand the details without the original conversation:

   ````md
   <callout icon="💡" color="blue_bg">
       **오늘의 핵심**
       - {이 문서에서 반드시 기억할 핵심 2~5개}
   </callout>

   <table_of_contents color="gray"/>

   ## 학습 개요
   {무엇을 공부했고, 어떤 질문에서 출발했으며, 개념들이 어떻게 연결되는지 쉬운 말로 설명}

   ## 전체 흐름
   {세 단계 이상의 실행·인과 흐름이면 Mermaid나 번호 목록으로 시작점부터 결과까지 표현}

   ---

   ## 1. {큰 개념 또는 학습 단계}

   ### {개념 이름}

   #### 한 문장 정의
   {용어를 처음 보는 사람도 이해할 수 있는 정의}

   #### 왜 필요한가
   {어떤 문제를 해결하며, 이 개념이 없으면 무엇이 어려운지 설명}

   #### 입력·상태·출력
   {무엇이 들어오고, 내부 상태가 어떻게 바뀌며, 무엇이 반환되거나 관찰되는지 설명}

   #### 실행 순서
   1. {첫 단계}
   2. {다음 단계}
   3. {결과가 만들어지는 단계}

   #### 코드로 확인하기
   ```{language}
   {사용자가 다룬 내용을 보여 주는 최소한의 실행 가능한 코드}
   ```

   {중요한 줄을 실행 순서대로 따라가며 변수의 타입·형태, 호출되는 객체, 상태 변화, 반환값을 설명}

   #### 결과 해석
   {예상 출력이나 오류를 보여 주고 왜 그 결과가 나오는지 설명}

   <callout icon="⚠️" color="yellow_bg">
       **헷갈린 지점 바로잡기**
       {사용자의 표현에서 보인 오해나 문법 실수를 정확한 개념과 함께 교정}
   </callout>

   ## 예시와 적용
   {사용자가 다룬 코드, 명령, 요청/응답, 연습 또는 오류를 하나의 완성된 상황으로 구성하고 처음부터 결과까지 설명}

   ## 헷갈리기 쉬운 점
   {대화에서 구분한 유사 개념, 자주 섞이는 용어, 오해, 주의점을 표나 짧은 사례로 비교}

   ## 핵심 복습
   - {나중에 다시 읽었을 때 기억해야 할 핵심}

   ## 추가로 알아둘 점
   - {학습 범위 밖의 내용은 오늘 배운 내용과 분리하여 다음 단계로만 제시}
   ````

   - Treat the template as a teaching order, not a requirement to create empty headings. Repeat the numbered concept section for each materially different concept, and omit `입력·상태·출력`, `코드로 확인하기`, `결과 해석`, or `추가로 알아둘 점` when the verified learning does not support it.
   - Begin with the short `오늘의 핵심` callout, then move from overview to detail. Make the first one or two screenfuls reveal the topic, the central distinction, and the overall flow before presenting long explanations.
   - Use this visual grammar consistently. It is based on the reference CodingStudy review and gives each icon one job:
     - `💡` with `blue_bg`: the opening core summary or a central insight.
     - `🧭` with `blue_bg`: a conceptual boundary or directional distinction, such as which denominator or execution path to follow.
     - `🎯` with `green_bg`: the concrete goal, desired final state, or success condition of an exercise.
     - `🧠` with `green_bg` or `blue_bg`: a memorable mental model or the one distinction that should remain after review.
     - `⚠️` with `yellow_bg`: a recoverable caution, API usage mistake, or medium-severity misconception.
     - `✍️` with `yellow_bg`: a spelling, variable-name, or terminology correction.
     - `🔎` with `yellow_bg`: an interpretation limit, especially when a graph or metric does not prove as much as it appears to.
     - `📌` with `yellow_bg`: the verified scope boundary or a clearly separated next step.
     - `🚨` with `red_bg`: a severe pitfall that can invalidate learning results or production behavior, such as data leakage, broken input-label pairing, uncontrolled resource exhaustion, or an unsafe assumption.
     - Do not use an icon merely for decoration. Keep one callout focused on one message, usually one short paragraph or a 2–5 item list, and do not repeat the same warning in prose and another callout.
   - Use exact Notion block forms rather than approximate Markdown. In generated Notion Markdown, indent every callout child with one tab as required by the enhanced Markdown format:
     - Put `<table_of_contents color="gray"/>` after the opening callout when the page has at least four meaningful `##` sections; omit it for a short page.
     - Use `##` for the overview, flow, numbered major stages, comparisons, and final review; use `###` for a concept inside a stage; use `####` for repeatable questions such as `한 문장 정의`, `왜 필요한가`, `실행 순서`, and `결과 해석`. Separate major numbered stages with `---`.
     - Use fenced `mermaid` for a flow with at least three meaningful nodes, a language-labelled code fence for executable source, and `plain text` for shapes, request traces, or ASCII diagrams that are not executable.
     - Use Notion table XML with `<table fit-page-width="true" header-row="true">` and a `gray_bg` header row when two or more concepts are compared across the same two or more fields. Keep every cell to rich text; do not put code blocks or lists inside cells.
     - Use `<details color="gray_bg">` only for useful peripheral detail, such as an exact loss calculation or optional visualization note. Never hide the definition, main execution flow, expected result, or key correction in a toggle.
   - Explain each concept in this order when applicable: one-sentence definition → reason it is needed → input/state/output → execution sequence → concrete example → result → misconception correction → connection to the next concept. Do not merely expand Issue bullets with filler or produce a catalog of definitions.
   - Scale detail to the verified learning rather than aiming for a fixed total page length. Use these ranges only as planning guidance and never pad text to meet them:
     - A small distinction or single term normally needs 3–5 explanatory blocks and roughly 300–700 Korean characters: definition, reason, one example or comparison, and a correction when relevant.
     - A standard code or process concept normally needs 5–9 explanatory blocks and roughly 700–1,400 Korean characters excluding code: definition, need, inputs/state/outputs, ordered execution, example, result, and pitfall.
     - An end-to-end workflow normally needs roughly 1,200–2,500 Korean characters excluding code, plus the smallest useful flow diagram, trace, table, or executable example.
     - Treat a broad session like the reference page as several major concept groups, not one oversized explanation. Group related concepts under numbered stages and use the table of contents, dividers, and final comparison to keep it navigable.
     - Stop expanding a concept when a reader can define it in their own words, explain why it exists, follow or predict the next execution step, interpret the result, and distinguish the main misconception without the original conversation.
   - Introduce a technical term in plain Korean before repeatedly using it. Prefer a concrete sentence such as “쓰레드 풀은 미리 만든 쓰레드를 보관하고 빌려주는 공간이다” before describing configuration or tuning details.
   - Use `전체 흐름` only when it improves understanding. Prefer Mermaid for three or more meaningful sequential or causal steps; use a short numbered flow or omit the section for a simple standalone fact.
   - When the verified learning contains programming code, include at least one fenced code block for every materially different major concept group. Keep trivial variations together instead of creating repetitive snippets.
   - Introduce every code block with the idea or question it demonstrates. After the block, walk through important lines in execution order and state the expected result or error. Explain relevant variable types, collection or tensor shapes, method receivers, return values, and persistent state changes such as `fit`, `save`, or bean registration. Never leave a code block unexplained and never restate syntax without explaining its effect.
   - Prefer minimal, executable examples based on the user's own exercise. Correct syntax, terminology, and naming mistakes while preserving the learning intent; explicitly identify the original misconception and explain why the correction works.
   - Use the language identifier on fenced blocks, such as `python`, `java`, `sql`, `javascript`, or `bash`. Include sample output only when it materially helps understanding, and distinguish output from source code.
   - Connect code to the conceptual model. For example, do not only show `response.json()`; explain that the method parses the response body and creates Python `list` and `dict` objects that subsequent indexing operates on.
   - For a conceptual topic without meaningful code, replace the code subsection with a concrete scenario, HTTP request/response trace, object or thread ownership flow, state transition, comparison table, or command example. Do not invent irrelevant code merely to satisfy the template.
   - Use comparison tables when several concepts repeat the same fields, such as `생성 위치`, `실행 주체`, `입력`, `출력`, or `장단점`. Keep narrative prose for causes, trade-offs, and transitions that a table cannot explain well.
   - Use callouts selectively and consistently: `💡` for the central insight, `⚠️` for a correction or caution, `🚨` for a dangerous failure mode, `🧠` for a memorable distinction, and `🔎` for interpretation. Do not turn every paragraph into a callout.
   - Preserve the user's question or informal wording when it reveals the learning path, but place it under a clear `헷갈린 지점` and answer it with accurate terminology. Do not repeat a misconception as if it were correct.
   - Make detail earn its place. Every paragraph should help answer at least one of: what it is, why it is needed, what enters or changes, how it runs, what comes out, why the result occurs, or what is commonly misunderstood.
   - Keep the final `핵심 복습` short. Put the teaching detail in the prose, code, and walkthrough sections rather than hiding the explanation in a long bullet list.
   - Include only material supported by the conversation, user notes, exercises, or published Issue. Do not turn inferred advanced material into completed learning.
   - Omit workflow sections such as `대화에서 확인한 학습 근거`, `사용한 프롬프트`, `심화 확장`, and `다음 학습` unless the user explicitly asks for them in Notion.
   - Preserve useful headings, lists, and code blocks with supported Notion Markdown. For code-based study, a page that contains only prose, only code, or a list of concepts is incomplete unless the user explicitly requests that format.
   - Keep `원문 링크` as a separate provenance property; never use the URL as the page body or create a link-only body.
   - Before updating an existing page, fetch its body. Synchronize the review sections without duplicating them and never delete user-authored blocks. For a legacy page containing an exact AI-synchronized Issue copy, replace only that synchronized copy when it can be identified confidently; otherwise preserve it and add or update one `복습 정리` section.
   - Leave the page body empty or summary-only only when the user explicitly requests it. The GitHub Issue is the source record and Notion is the detailed review document.
   - Before publishing, verify that: the opening summary matches the actual study; the overall flow has a clear start and result; every code block is introduced and explained; relevant inputs, outputs, types, shapes, and state changes are named; misconceptions are corrected; no jargon is left unexplained; and advanced material is clearly separated from completed learning.
9. If Notion is unavailable or disconnected, do not claim the page was created. Preserve the GitHub result and provide the exact date-free Notion title, subject tag, and properties as a Notion draft.
10. Report the created or updated Notion page URL and applied subject tag for every published subject.

## Learning Map

After publishing all current Issue records, query prior open and closed Issues for each subject label. Read their titles and relevant learning sections to infer only well-supported prerequisite or follow-up relationships.

Return one Mermaid `flowchart TD` per subject in the final response:

```mermaid
flowchart TD
  A["Spring 기초: 객체와 의존성"] --> B["IoC와 DI"]
  B --> C["Issue #42: DI로 객체 의존성 이해하기"]
```

- Use nodes and directed edges to show the hierarchy: verified prior Issue concept → current Issue → next concept.
- Put issue numbers in nodes when available. Keep node labels short and use the Issue URL in the surrounding Markdown list, because GitHub Mermaid diagrams should not rely on interactive links.
- Include only relationships supported by Issue content or the user's current notes. Do not add generic prerequisite nodes merely because they seem likely. If the relationship is an inference, state that below the diagram.
- Keep separate subjects in separate diagrams; never draw artificial edges between `java`, `spring`, and `html` merely because they were studied on the same day.

## Command Handling

- Treat bare `$diary` as: derive subjects from the conversation, create or update the same-date Issue for each subject with the meaningful user prompts, add or synchronize its GitHub link in the README Issue index, write a detailed subject-tagged review document in a matching Notion CodingStudy page, then return the labelled learning maps.
- Treat `$diary <text>` as: use `<text>` as additional primary evidence and combine it with the conversation.
- If the user asks for drafts, preview the topic split, Issue drafts, and maps without publishing. When earlier Issues cannot be read, start each map with the current draft node and connect only to an explicitly stated next concept.
