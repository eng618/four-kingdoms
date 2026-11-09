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
- `gradle.properties` holds the development `mod_version`. Release automation (Release Please / tag workflows) may override or bump versions per repo workflow; confirm before changing versioning behavior.
- GitHub Actions: `build.yml` (build/test), `commitlint.yml`, `release-please.yml`, `release.yml`.
