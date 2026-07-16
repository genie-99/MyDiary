---
name: diary
description: Create or update a daily study diary as a GitHub Issue when the user invokes `$diary`, asks for a diary entry, daily study record, learning log, or wants today's study and prompt history summarized into an Issue. Also use when the user writes study notes after `$diary`; treat that trailing text as primary source material. Use for workflows that inspect existing GitHub Issues, reuse and append to a same-date Diary Issue when one exists, determine the next Diary number only when creating a new date, inspect relevant workspace changes including `C:\SSAFY` when requested, and publish or update an Issue titled `[Diary #N] YYYY-MM-DD 학습기록`.
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
   - If no GitHub repository can be determined, ask the user for the target repo before creating or updating the Issue.

3. Inspect related workspace changes when requested.
   - If the user asks to include changed files, today's work, SSAFY projects, or a project outside the current repo, inspect relevant repositories under `C:\SSAFY`, especially `C:\SSAFY\workspace`.
   - Use repository evidence such as `git status`, `git log`, `git diff --stat`, and targeted `git show` output to identify confirmed changes.
   - Include only verified file changes and outcomes in the diary. If a referenced folder or repository cannot be read or has no changes, state that clearly.
   - When the user names a project such as `SSAFY-Seoulog`, prefer that project path under `C:\SSAFY\workspace` if it exists.

4. Check existing GitHub Issues to determine whether to update or create a Diary Issue.
   - Query open and closed Issues.
   - First find any Diary Issue whose title contains the current date in `YYYY-MM-DD` format.
   - If a same-date Diary Issue exists, reuse that Issue and append the new diary content to its existing body instead of creating another Issue.
   - When appending, keep the existing body intact and add a clearly separated new section such as `---` followed by `## 추가 기록 HH:mm` or another concise timestamped heading.
   - If no same-date Diary Issue exists, find titles matching `[Diary #숫자]`, `[Diary #N]`, `Diary #숫자`, or similar Diary-number patterns.
   - Use the highest existing Diary number plus one only for a newly created Diary Issue.
   - If no prior Diary Issue exists, use `1`.

5. Build or reuse the title.
   - For a same-date existing Diary Issue, keep the existing Issue title and Diary number.
   - For a new Diary Issue, format the title as `[Diary #N] YYYY-MM-DD 학습기록`.
   - Use the user's local date when known. In this environment, prefer Asia/Seoul dates if available.

6. Build the Issue body in Korean.
   - Include `## 오늘 공부한 내용`.
   - Include `## 사용한 프롬프트`.
   - Include `## 작업/실습 기록`.
   - Include `## 배운 점`.
   - Include `## 다음에 해볼 것`.
   - Add project-specific sections when they clarify the record, such as `## SSAFY-Seoulog 수정 확인`.
   - Use Mermaid diagrams when the user asks for diagrams, flow summaries, architecture summaries, or `mermaid`.
   - Keep the content factual. Do not invent study items, prompts, commands, files, or outcomes.
   - If information is missing, write a short note such as `확인된 내용 없음` rather than guessing.

7. Capture prompts accurately.
   - List the user's meaningful prompts from today's conversation.
   - Include the `$diary ...` prompt itself when it contains study notes.
   - Preserve Korean wording when possible.
   - Summarize long prompts only when needed for readability.
   - Distinguish direct user prompts from inferred implementation steps.

8. Create or update the GitHub Issue.
   - If a same-date Diary Issue exists, fetch its current body and update it with the appended diary content. Prefer `gh issue view --json body` followed by `gh issue edit --body-file` when GitHub CLI is authenticated and available.
   - If no same-date Diary Issue exists, prefer `gh issue create` when the GitHub CLI is authenticated and available.
   - Otherwise use an available GitHub MCP/tooling integration if present.
   - If no GitHub write path is available, provide the exact title and body for the user and explain that Issue creation or update could not be completed.

9. Report the result.
   - Return the created or updated Issue number and URL when available.
   - Mention whether the diary was appended to an existing same-date Issue or created as a new Issue.
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