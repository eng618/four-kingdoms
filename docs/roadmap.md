# Roadmap to Completion (Master Checklist)

Tick boxes here to track to a fully functional mod: custom armor + weapons + enemies across the kingdoms.

## Phase 0 — Docs ✅ (this scaffold)

* [x] `docs/` Diátaxis tree + `index.md` + `glossary.md`
* [x] Tutorials (getting started, armor-set tour)
* [x] How-tos (hero set, set bonus, weapon, mob, test, release)
* [x] Reference (roster, registry, balance, assets, conventions)
* [x] Explanation (lore, elemental design, effect design)
* [ ] Fill real hero names/elements into `reference/hero-roster.md` (currently placeholders for 9 Element + 1 Forgotten)

## Phase 1 — Harden Daydream baseline

* [x] Recipes: Daydream pickaxe/axe/shovel/hoe (4 files)
* [x] Recipes: 8 infused leathers (shapeless: leather + material)
* [x] Fix `en_us.json` leather keys to `item.four_kingdoms.*` domain consistency (verified already correct)
* [x] Delete committed `textures/.DS_Store`; add `.gitignore` rule if missing (removed; `.gitignore` already covers it)
* [x] Verify leggings layer texture (both `humanoid/daydream.png` and `humanoid_leggings/daydream.png` exist); compile green — `runClient` manual check still open

## Phase 2 — Effect engine + Nightmare (Dream complete)

* [x] `event/SetBonus.java` + `event/ArmorSetEffectHandler.java`, registered on `NeoForge.EVENT_BUS`
* [x] Daydream bonus: 25%/piece → Speed II + Regen I, 400t, every 400t (server only)
* [x] Nightmare set (option A): materials, items, lang, models, textures (Daydream copies as placeholders), recipes, tab entry
* [x] Nightmare cleanse: 25%/piece vs wither/poison/slowness (halve, cleanse if <100t)
* [ ] Test matrix from `how-to/add-armor-set-bonus.md` passes in `runClient` (manual — needs game run)

## Phase 3 — Element Kingdom (9 heroes)

Pilot slice done in the Flare pattern (materials → items → lang → models → tinted placeholder textures → recipes → tab → bonus). Repeat per hero:

* [x] Flare (`flare_*`, Fire Resistance bonus, Element tab created)
* [ ] Roster bonus approval for crystal / speed / black / pearl / lazuli / leafy / sylvia / sunshine (proposals in `reference/materials-balance.md`)
* [ ] crystal, speed, black, pearl, lazuli, leafy, sylvia, sunshine vertical slices
* [ ] In-game check via `runClient` per slice

## Phase 4 — Forgotten (1) + Wild (placeholder)

* [ ] `forgotten_hero` full slice (same as Phase 3 pattern)
* [x] `element_kingdom` creative tab (created with Flare); still need `forgotten_kingdom` tab + `wild_kingdom` empty placeholder

## Phase 5 — Weapons polish

* [ ] `item/KingdomSpearItem.java` base class (reach param); Daydream becomes thin subclass
* [ ] Reach/damage/speed audit against `materials-balance.md`

## Phase 6 — Enemies

* [ ] Track A: 1 reskinned mob each for Dream/Element/Forgotten (entity + spawn + loot + egg)
* [ ] Track B: GeckoLib dependency + 1 pilot custom mob (migrate a Track A mob first)
* [ ] `runServer` sidedness check green

## Phase 7 — Release

* [ ] Tags, loot tables, advancements; wire `runData` if adopted
* [ ] `./gradlew spotlessApply check build` green; `runClient` + `runServer` smoke pass
* [ ] Bump `mod_version`, tag `vX.Y.Z`, attach jar + changelog

## How to use this file

* Check boxes in PRs as work lands; each box maps to a `how-to/*` guide.
* Never add a hero without its roster + balance rows first.
