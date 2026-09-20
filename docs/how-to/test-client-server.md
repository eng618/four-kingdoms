# How-To: Test (Client + Server)

```bash
./gradlew compileJava          # fast compile check
./gradlew spotlessCheck        # lint (or spotlessApply to fix)
./gradlew runClient            # manual in-game test, creative tab
./gradlew runServer            # dedicated server smoke test (nogui)
```

## Manual checklist per change

* [ ] Items appear in correct kingdom tab with names (lang) and icons (textures).
* [ ] Armor equips, layer texture correct (leggings use `humanoid_leggings` layer).
* [ ] Recipes craft from vanilla ingredients.
* [ ] Set bonuses fire on the documented interval (see `add-armor-set-bonus.md` matrix).
* [ ] Mobs spawn, use ability, drop loot; server log has no `ClassNotFound` / sidedness errors.

## Before every commit

`./gradlew spotlessApply check` must be green.
