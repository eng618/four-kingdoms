# How-To: Build and Release

```bash
./gradlew spotlessApply check build
```

* Jar lands in `build/libs/four_kingdoms-<mod_version>.jar`.
* Bump `mod_version` in `gradle.properties` per release; keep `neo_version`/`minecraft_version` pinned.
* Smoke-test the built jar once via `runClient` before publishing (dev launcher ≠ production jar).
* Tag the release in git (`v<version>`) and attach the jar + changelog (not covered by automation yet — no CI workflow exists).
