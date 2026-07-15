---
name: diary
description: Create a daily study diary as a GitHub Issue when the user invokes `$diary`, asks for a diary entry, daily study record, learning log, or wants today's study and prompt history summarized into an Issue. Also use when the user writes study notes after `$diary`; treat that trailing text as primary source material. Use for workflows that inspect existing GitHub Issues, determine the next Diary number, and publish an Issue titled `[Diary #N] YYYY-MM-DD 학습기록`.
---

# Diary

## Goal

Create one GitHub Issue that records today's learning in Korean. Base the entry on the current conversation, executed commands, edited files, repository context, any user-provided notes, and especially any study content written after `$diary` in the user's prompt.

## Workflow

1. Identify user-provided diary content.
   - If the prompt contains text after `$diary`, treat that trailing text as the primary source for `오늘 공부한 내용`.
   - Clean up the trailing text into readable bullets without changing the meaning.
   - Combine it with conversation context, commands, files, and repository work when relevant.
   - Do not ignore the trailing text even if the rest of the conversation contains other work.

2. Identify the repository that should receive the Issue.
   - Prefer the current workspace repository.
   - If the remote is unclear, inspect `git remote -v`.
   - If no GitHub repository can be determined, ask the user for the target repo before creating the Issue.

3. Check existing GitHub Issues to determine the Diary number.
   - Query open and closed Issues.
   - Find titles matching `[Diary #숫자]`, `[Diary #N]`, `Diary #숫자`, or similar Diary-number patterns.
   - Use the highest existing Diary number plus one.
   - If no prior Diary Issue exists, use `1`.

4. Build the title.
   - Format: `[Diary #N] YYYY-MM-DD 학습기록`
   - Use the user's local date when known. In this environment, prefer Asia/Seoul dates if available.

5. Build the Issue body in Korean.
   - Include `## 오늘 공부한 내용`.
   - Include `## 사용한 프롬프트`.
   - Include `## 작업/실습 기록`.
   - Include `## 배운 점`.
   - Include `## 다음에 해볼 것`.
   - Keep the content factual. Do not invent study items, prompts, commands, files, or outcomes.
   - If information is missing, write a short note such as `확인된 내용 없음` rather than guessing.

6. Capture prompts accurately.
   - List the user's meaningful prompts from today's conversation.
   - Include the `$diary ...` prompt itself when it contains study notes.
   - Preserve Korean wording when possible.
   - Summarize long prompts only when needed for readability.
   - Distinguish direct user prompts from inferred implementation steps.

7. Create the GitHub Issue.
   - Prefer `gh issue create` when the GitHub CLI is authenticated and available.
   - Otherwise use an available GitHub MCP/tooling integration if present.
   - If no GitHub write path is available, provide the exact title and body for the user and explain that Issue creation could not be completed.

8. Report the result.
   - Return the created Issue number and URL when available.
   - Mention the Diary number used.
   - Keep the final response concise.

## Issue Body Template

```markdown
## 오늘 공부한 내용
- 

## 사용한 프롬프트
- 

## 작업/실습 기록
- 

## 배운 점
- 

## 다음에 해볼 것
- 
```