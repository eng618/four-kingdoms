# How-To: Add Armor Set Bonuses

Implements the two Dream Kingdom bonuses. Locked decision: **Nightmare = option A (shorten/cleanse, not true damage reduction).**

## Design

* New package `event/` with `ArmorSetEffectHandler` + `SetBonus` interface:

  ```java
  interface SetBonus { void onIntervalTick(LivingEntity entity, int piecesWorn); }
  ```

* `Map<Holder<ArmorMaterial>, SetBonus>` so all 12 heroes reuse one tick path.
* Server-side tick only, every 400 ticks (20s). Never run on client. Guard with `!level.isClientSide && entity.tickCount % 400 == 0`.

## Daydream (buff)

* For each Daydream armor piece worn, roll 25% independently.
* On success: `addEffect(MOVEMENT_SPEED, 400t, amp 1)` + `addEffect(REGENERATION, 400t, amp 0)`.
* Multiple successes in one interval = refresh duration (do not stack amplifiers).

## Nightmare (cleanse, option A)

* Triggers only if the wearer has `WITHER`, `POISON`, or `SLOWNESS`.
* For each Nightmare piece worn, roll 25% independently per active bad effect.
* On success: if remaining duration < 100t → `removeEffect`; else reduce duration by 50% (remove + re-add with shorter duration, preserving amplifier).
* Rationale: vanilla has no "potion damage reduction" attribute; duration-cut approximates the 25%/piece spec without mixins.

## Test matrix

* Daydream 1pc vs 4pc over 60s: count buff uptime in log or via `/effect` inspection.
* Nightmare: apply `/effect give @s poison 30`, wear 0/1/4 pieces, confirm faster expiry with more pieces.
* Multiplayer: confirm no client desync (effects applied server-side only).

### Test findings

* daydreams armor does not have 25% chance increase for each piece in allowing the effect to take place

* The textures for Nightmare's set need to be changed, as well as tools
* Nightmare's Armor set is supposed to have a 25% (For each piece) to prevent all withering damage, poison damage, slowness effect, and more

## Files to create

* `java/com/fourkingdoms/mod/event/ArmorSetEffectHandler.java`
* `java/com/fourkingdoms/mod/event/SetBonus.java`
* Register handler on `NeoForge.EVENT_BUS` in `FourKingdomsMod` constructor.
* Document tuning in `reference/materials-balance.md`.
