# How-To: Build and Release

```bash
./gradlew spotlessApply check build
```

* Jar lands in `build/libs/four_kingdoms-<mod_version>.jar`.
* Smoke-test the built jar once via `runClient` before publishing (dev launcher ≠ production jar).

## Automated release (tag → GitHub + Modrinth + CurseForge)

Pushing tag `vX.Y.Z` (or Release Please doing it for you) triggers `.github/workflows/release.yml`:

1. Builds with `-Pmod_version=X.Y.Z`, attaches the jar to the GitHub Release (notes auto-generated).
2. Feeds those release notes into `GITHUB_RELEASE_NOTES` so Modrinth/CurseForge get the same changelog.
3. Runs `./gradlew publishMods`, which uploads to each platform **only if its token secret exists**, and syncs `MODRINTH.md` to the Modrinth project page body.

### Required secrets

| Secret | Purpose |
|---|---|
| `MODRINTH_TOKEN` | Modrinth PAT (see scopes below) |
| `MODRINTH_PROJECT_ID` | Project ID or slug (project page → ⋮ → Copy ID) |
| `CURSEFORGE_TOKEN` | CurseForge API token (optional — step is skipped without it) |
| `CURSEFORGE_PROJECT_ID` | Numeric CurseForge project ID (optional) |

### Modrinth PAT scopes

Generate at Modrinth → Settings → Account → Personal access tokens:

* **Create versions**, **Read versions**, **Write versions** — version uploads
* **Read projects**, **Write projects** — required for the automatic `MODRINTH.md` → project-page sync

### Testing the publish path locally (dry)

Tokens stay in CI only, but you can validate the Gradle wiring without publishing:

```bash
./gradlew publishMods --dry-run   # tasks configure cleanly, nothing uploads
```

Then edit `MODRINTH.md` for player-facing copy — it ships to the project page on the next release, no code changes needed.

