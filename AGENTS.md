# Four Kingdoms – agent instructions

NeoForge mod for Minecraft 1.21.1 (`mod_id=four_kingdoms`). Java 21, Gradle (wrapper), Taskfile.

## Common commands
- `task setup` – permissions, dependencies, IDE sources
- `task dev` – run client (`./gradlew runClient`)
- `task run:server` – headless server (`./gradlew runServer`)
- `task lint` / `task format` – Spotless check/apply
- `task test` – tests (`./gradlew test`)
- `task validate` – local CI-style validation (format/check/build/tests as configured)
- `task build` – build JAR
- `task data` – run data generators

## Conventions
- Use Conventional Commits (`feat:`, `fix:`, `build:`, etc.); commitlint runs in CI.
- Keep resource paths under `assets/four_kingdoms/` and `data/four_kingdoms/` aligned with `mod_id`.
- Do not commit secrets or tokens. Platform publish tokens live in env/CI secrets.

## Versioning & releases
- Release Please (`release-type: simple`, `version-file: version.txt`) manages release PRs/tags and bumps `version.txt`. `gradle.properties` keeps a baseline `mod_version` for local/dev builds.
- The `Release` workflow builds/publishes with `-Pmod_version` derived from the git tag (authoritative for tagged artifacts).
- GitHub Actions: `build.yml` (build/test), `commitlint.yml`, `release-please.yml`, `release.yml`.
- `task build:release VERSION=x.y.z` produces a tag-equivalent local release jar; `task publish` requires platform tokens and should be used intentionally.
