# Tutorial 2 — First Armor Set Tour

Goal: understand what one hero set consists of, using Daydream as the example.

## What to look at (in order)

1. **Materials** — `material/ModArmorMaterials.java` (defense 3/8/6/3, toughness 2.0) and `material/ModToolMaterials.java` (1750 uses, 8.5 speed).
2. **Registry** — `registry/ModItems.java`: 1 spear + 4 armor + 4 tools + infused leathers.
3. **Weapon class** — `item/DaydreamSpearItem.java`: `ATTACK_DAMAGE + ENTITY_INTERACTION_RANGE (+1.5)`.
4. **Assets** — `models/item/daydream_*.json`, `models/equipment/daydream.json`, `textures/...`, `lang/en_us.json`.
5. **Recipes** — `data/four_kingdoms/recipe/daydream_*.json` (armor + spear exist; tools + leathers pending).
6. **Tab** — `registry/ModCreativeTabs.java` lists everything under Dream Kingdom.

## Exercise

Craft (or give yourself) the full Daydream set and note what is **missing**: no set-bonus effects trigger yet, Nightmare does not exist, no enemies. Those are Phases 2–6 in [roadmap](../roadmap.md).

Next: [How-To: Add a new hero set](../how-to/add-new-hero-set.md)
