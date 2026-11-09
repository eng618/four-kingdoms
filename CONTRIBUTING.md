# Contributing

## Prerequisites
- JDK 21 (see `.tool-versions`)
- [Task](https://taskfile.dev) (see `.tool-versions`) or run Gradle wrapper commands directly
- Git

## Setup
```bash
task setup
```

## Development workflow
1. Create a branch from `main`.
2. Make changes following existing code/resource conventions.
3. Format and validate locally:
   ```bash
   task format
   task validate
   ```
4. For gameplay changes, smoke-test with `task dev` (and `task run:server` when relevant).
5. Commit using [Conventional Commits](https://www.conventionalcommits.org/).

## Pull requests
- Keep PRs focused.
- Ensure CI checks pass (`Build & Test`, `Commitlint`).
- Update docs/assets/recipes when adding or renaming registry entries.
