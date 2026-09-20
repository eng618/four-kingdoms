# Glossary

* **DeferredRegister** — NeoForge deferred registration queue. `ModItems.ITEMS`, `ModArmorMaterials.ARMOR_MATERIALS`, `ModCreativeTabs.CREATIVE_MODE_TABS` all use it. Bound to the mod event bus in `FourKingdomsMod`.
* **ArmorMaterial** — Defense, enchantability, toughness, knockback resistance, repair ingredient, equipment-layer texture. One per hero set. See `material/ModArmorMaterials.java`.
* **Tier** — Tool stats: durability, mining speed, attack damage bonus, enchantability, repair ingredient. One per hero set. See `material/ModToolMaterials.java`.
* **Equipment layer** — `assets/four_kingdoms/models/equipment/<set>.json` + `textures/entity/equipment/humanoid/<set>.png`. Controls worn-armor rendering in 1.21.1.
* **Set bonus** — Gameplay effect for wearing N pieces of one hero set (e.g. Daydream buff, Nightmare cleanse). Implemented via server tick handler, not via the material itself.
* **Infused leather** — Crafting intermediate (`amethyst_infused_leather`, etc.). 8 exist as items; recipes pending.
* **Hero set** — Armor (4) + signature weapon (1) + tools (4) sharing one material/tier.
* **Kingdom** — Dream / Element / Wild / Forgotten. A tab + lore grouping, not a code namespace.
* **Reskin mob** — Vanilla-derived entity (`extends Monster/Animal`) with new attributes, goals, renderer texture. No new library needed.
* **GeckoLib mob** — Fully custom animated entity using GeckoLib. Requires `geckolib-neoforge` dependency + geo model/renderer/animation files.
* **Datagen** — Generated `src/generated/resources/` via `./gradlew runData`. Configured in `build.gradle` but unused so far.
* **Roster** — The 12-hero v1 list in `reference/hero-roster.md`. Placeholders (`element_01`…) until real names land.
