# Reference: Materials & Balance

## Daydream (implemented, baseline for all heroes)

| Slot | Value |
| --- | --- |
| Armor defense (H/C/L/B) | 3 / 8 / 6 / 3 |
| Enchantability | 18 |
| Toughness / KB resist | 2.0 / 0.05 |
| Tool durability / speed / dmg | 1750 / 8.5 / +3.5 |
| Repair | amethyst_shard + diamond |
| Spear | 4.5 dmg, -2.4 speed, +1.5 reach |

## Nightmare (Phase 2 — implemented, placeholder art)

| Slot | Value |
| --- | --- |
| Armor defense (H/C/L/B) | 3 / 8 / 6 / 3 |
| Enchantability | 15 |
| Toughness / KB resist | 2.5 / 0.1 |
| Tool durability / speed / dmg | 1800 / 8.0 / +4.0 |
| Repair | echo_shard + netherite_scrap |
| Sword | 3.0 dmg, -2.4 speed (vanilla `SwordItem.createAttributes`) |
| Set bonus | Option A: 25%/piece per active wither/poison/slowness → halve duration, cleanse if ≤100t left. Interval 400t, server only. |
| Art status | Textures/models are Daydream copies renamed — replace with real Nightmare art when ready (`imports/` → `textures/`, keep file names). |

## Tuning guidance for new sets

* Keep total defense within 15–22 for parity with diamond/netherite tiers; vary toughness (0–3) and KB resist (0–0.1) by fantasy (heavy Element earth > light Dream).
* Tool durability 1500–2200; mining speed 7–9; never exceed netherite damage without a drawback (speed penalty or effect-gated).
* Set bonuses carry identity more cheaply than raw stats — prefer a distinctive tick effect over +2 armor.
* Record every new set's row here before coding it; balance review happens against this table, not tooltips.

## Pending rows

~~Nightmare~~ done. Flare done (below). Remaining Element + Forgotten — fill per hero before coding (Phase 3–4).

## Flare (Phase 3 pilot — implemented, tinted placeholder art)

| Slot | Value |
|---|---|
| Armor defense (H/C/L/B) | 3 / 7 / 5 / 3 (18 total, offense-skewed) |
| Enchantability | 15 |
| Toughness / KB resist | 1.5 / 0.0 |
| Tool durability / speed / dmg | 1600 / 8.0 / +4.0 |
| Repair | blaze_rod + iron_ingot |
| Sword | 3.0 dmg, -2.4 speed (vanilla `SwordItem.createAttributes`) |
| Set bonus | Additive roll → Fire Resistance I, 400t, every 400t (server only) |
| Art status | Daydream art hue-shifted to blaze orange via script — replace with real Flare art when ready |

## Proposed Element bonuses (awaiting approval — not implemented)

Same additive roll (25% × pieces, 400t interval) unless noted. Counterpart should mirror the hero's element:

| Hero | Proposal |
|---|---|
| crystal (ocean/trident) | Water Breathing + Dolphin's Grace, 400t |
| speed (storm/longsword) | Speed I (or II) + Haste I, 400t |
| black (shadow/blade) | Invisibility pulse 200t + Night Vision, 400t interval |
| pearl (ender/scythe) | Slow Falling + reduced ender-pearl self-damage (custom: deny fall damage ticks on roll) |
| lazuli (frost/sickle) | Slowness aura on attackers (Thorns-style via HurtEvent) or Frost Walker-style step bonus — TBD, needs design pick |
| leafy (nature/spear) | Regeneration I + Saturation tick, 400t |
| sylvia (royal/sword) | Hero of the Village-style discount is out of scope; propose Absorption II (4 hearts), 400t |
| sunshine (light/sword) | Night Vision + Glowing cleanse (remove Darkness/Blindness on roll, mirroring Nightmare) |

Confirm or revise these and I will batch the remaining 8 slices in the same Flare pattern.
