# How-To: Add Armor Set Bonuses

Implements the two Dream Kingdom bonuses. Locked decision: **Nightmare = option A (shorten/cleanse, not true damage reduction).**

## Design

* New package `event/` with `ArmorSetEffectHandler` + `SetBonus` interface:

  ```java
  interface SetBonus { void apply(Player player, int piecesWorn); }
  ```

* One shared tick path + one `MobEffectEvent.Applicable` listener, so all 12 heroes reuse the same code.
* Server-side only, every 400 ticks (20s). Guarded with `!level.isClientSide && player.tickCount % 400 == 0`.

## Chance model (additive — fixed per test findings)

* Each worn piece adds 25% to a **single** roll per interval: 1pc = 25%, 2pc = 50%, 3pc = 75%, full set = 100% guaranteed.
* Helper: `ArmorSetEffectHandler.rollSucceeds(player, piecesWorn)`.

## Daydream (buff)

* One additive roll per 400t interval (25% × pieces worn).
* On success: `addEffect(MOVEMENT_SPEED, 400t, amp 1)` + `addEffect(REGENERATION, 400t, amp 0)`.
* Full set = buffs refresh every interval, effectively permanent while worn.

## Nightmare (prevent + cleanse, option A)

* **Prevent:** when Wither/Poison/Slowness would be applied, one additive roll (25% × pieces) denies it outright via `MobEffectEvent.Applicable` → `DO_NOT_APPLY`. Blocked effects deal no damage.
* **Cleanse active:** each 400t interval, one additive roll per active bad effect; on success halve remaining duration, or remove if ≤100t remain (preserving amplifier).
* Rationale: vanilla has no "potion damage reduction" attribute; block-before-start plus duration-cut delivers the spec's damage prevention without mixins. Mitigated list lives in `NIGHTMARE_MITIGATED` — extend there for future "and more" coverage.

## Test matrix

* Daydream 1pc vs 4pc over 60s: count buff uptime in log or via `/effect` inspection.
* Nightmare: apply `/effect give @s poison 30`, wear 0/1/4 pieces, confirm faster expiry with more pieces.
* Multiplayer: confirm no client desync (effects applied server-side only).

### Test findings

* ~~Daydream armor does not scale chance per piece~~ → **Fixed:** additive model, 25% × pieces, full set = 100%. Re-test: 1pc should trigger ~1 in 4 intervals; 4pc every interval.
* Nightmare textures/tools are placeholders (Daydream copies) → **Open, needs real art.** Replace files under `textures/` keeping names; no code change needed.
* ~~Nightmare should prevent wither/poison/slowness damage~~ → **Fixed:** `Applicable` denial blocks application (no damage), plus halve/cleanse for already-active effects. Re-test: have a witch/splash potion hit you at 1pc vs 4pc; 4pc should block everything.
* New 400t testing note: effects only roll when `player.tickCount % 400 == 0`, so allow up to 20s after equipping before judging a miss.

## Files to create

* `java/com/fourkingdoms/mod/event/ArmorSetEffectHandler.java`
* `java/com/fourkingdoms/mod/event/SetBonus.java`
* Register handler on `NeoForge.EVENT_BUS` in `FourKingdomsMod` constructor.
* Document tuning in `reference/materials-balance.md`.
