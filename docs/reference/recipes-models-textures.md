# Reference: Recipes, Models, Textures

## Naming

* Registry `foo_bar` → model `models/item/foo_bar.json`, texture `textures/item/foo_bar.png`, recipe `data/four_kingdoms/recipe/foo_bar.json`, lang `item.four_kingdoms.foo_bar`.
* Armor set `daydream` → equipment model `models/equipment/daydream.json`, worn texture `textures/entity/equipment/humanoid/daydream.png` (+ `humanoid_leggings/daydream.png` variant exists — keep both in sync).

## Model parents

* Weapons/tools: `minecraft:item/handheld`.
* Armor pieces: `minecraft:item/generated`.
* Equipment: `layers.humanoid` + `layers.humanoid_leggings` pointing at `four_kingdoms:<set>`.

## Textures

* Item icons 16×16 PNG; armor layers 64×32 PNG. Source art lives in `imports/` (not shipped); export flattened PNGs only.
* `.DS_Store` files must not be committed (note: one exists under `textures/` — delete it).

## Recipes

* `minecraft:crafting_shaped`, `category: equipment`. Armor + spear for Daydream exist; Daydream tools and all 8 infused leathers have **no recipe yet** — that is Phase 1 work.
