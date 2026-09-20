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

## Element heroes (Phase 3 — all implemented, tinted placeholder art)

All use the additive roll (25% × pieces, 400t interval, server only) unless noted. Art for all 8 is hue-shifted Daydream placeholders — replace with real art when ready.

| Hero | Defense H/C/L/B | Ench | Tough / KB | Tools dur/spd/dmg | Repair | Weapon | Set bonus |
|---|---|---|---|---|---|---|---|
| flare | 3/7/5/3 | 15 | 1.5 / 0.0 | 1600/8.0/+4.0 | blaze_rod + iron_ingot | sword 3.0/-2.4 | Fire Resistance 400t |
| crystal | 3/8/6/3 | 16 | 2.0 / 0.05 | 1700/8.5/+3.5 | heart_of_the_sea + diamond | trident 5.0/-2.8, reach 1.5 (melee; throwable = future upgrade) | Water Breathing + Dolphin's Grace 400t |
| speed | 2/6/5/2 | 20 | 0.5 / 0.0 | 1500/9.0/+3.0 | copper_ingot + iron_ingot | longsword 3.0/-2.2 | Speed I + Haste I 400t |
| black | 4/8/6/4 | 12 | 3.0 / 0.1 | 2200/7.5/+4.5 | netherite_scrap | blade 4.0/-2.6 | Invisibility 200t + Night Vision 400t |
| pearl | 3/7/5/3 | 18 | 1.0 / 0.0 | 1600/8.0/+3.5 | ender_pearl + diamond | scythe 3.0/-2.4 (sword-class) | Slow Falling 400t + ender-pearl landing damage negated on roll (`EntityTeleportEvent.EnderPearl`) |
| lazuli | 3/8/6/3 | 14 | 2.0 / 0.05 | 1750/8.0/+3.5 | packed_ice + diamond | sickle 3.0/-2.4 (sword-class) | Thorns-style: attackers get Slowness II 100t on roll (`LivingDamageEvent.Pre`; no interval buff) |
| leafy | 2/7/5/3 | 16 | 1.0 / 0.0 | 1500/8.0/+3.0 | jungle_leaves + diamond | spear 4.5/-2.4, reach 1.5 | Regeneration I 400t + Saturation 200t |
| sylvia | 4/8/6/3 | 18 | 2.0 / 0.1 | 2000/8.0/+4.0 | iron + diamond + gold (recipes use iron/diamond; gold reserved for future gilded recipe pass) | sword 4.0/-2.4 | Absorption II (4 hearts) 400t |
| sunshine | 3/7/6/3 | 16 | 1.0 / 0.05 | 1700/8.5/+3.5 | iron_ingot | sword 3.0/-2.4 | Night Vision 400t + cleanse Darkness/Blindness on roll |

## Pending rows

forgotten_hero — fill before coding (Phase 4).

## Shared tech notes (Phase 3)

* `item/KingdomSpearItem.java` is the polearm base (damage/speed/reach params); `DaydreamSpearItem` is now a thin subclass. Crystal's trident and Leafy's spear use the base directly.
* Scythe/sickle/longsword/blade are sword-class items (`SwordItem`) with distinct stats — custom sweep/throw behaviors are Phase 5 upgrades, not silent omissions.
* Interval bonuses dispatch via `INTERVAL_BONUSES` map in `ArmorSetEffectHandler`; Lazuli lives only in the damage hook.
