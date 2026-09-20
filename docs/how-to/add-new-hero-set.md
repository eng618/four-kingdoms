# How-To: Add a New Hero Set

The canonical 7-step workflow. Copy this checklist per hero (see `reference/hero-roster.md`).

## Steps

1. **Materials** — Add entries in `material/ModArmorMaterials.java` and `material/ModToolMaterials.java`:
   defense map, durability, enchantability, equip sound, toughness, knockback resistance, repair `Ingredient`.
2. **Registry** — In `registry/ModItems.java` (or per-kingdom split when it exceeds ~300 lines):
   ```java
   public static final DeferredItem<Item> ELEMENT_01_SWORD = ITEMS.register("element_01_sword",
           () -> new SwordItem(ModToolMaterials.ELEMENT_01, new Item.Properties()));
   ```
   Include: helmet/chestplate/leggings/boots + signature weapon + pickaxe/axe/shovel/hoe as applicable.
3. **Creative tab** — Add all pieces in `registry/ModCreativeTabs.java` under the kingdom tab (create tab if new kingdom).
4. **Lang** — `assets/four_kingdoms/lang/en_us.json`: `"item.four_kingdoms.<id>": "Display Name"`.
5. **Models** — `models/item/<id>.json` (`minecraft:item/handheld` for weapons/tools, `minecraft:item/generated` for armor) + `models/equipment/<set>.json` for the worn layer.
6. **Textures** — `textures/item/<id>.png` (16×16) + `textures/entity/equipment/humanoid/<set>.png` (64×32). Export source art from `imports/`; do not commit PSDs.
7. **Recipes** — `data/four_kingdoms/recipe/<id>.json` (`minecraft:crafting_shaped`). One file per craftable item.

## Verify

```bash
./gradlew spotlessApply compileJava runClient
```

Check: tab lists items, models render, recipes craft, armor equips with correct layer texture.
