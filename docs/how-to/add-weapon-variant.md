# How-To: Add a Weapon Variant

## Rule

Never copy `DaydreamSpearItem` per hero. Extend a base class.

## Steps

1. Refactor `item/DaydreamSpearItem.java` → `item/KingdomSpearItem.java` with constructor `(Tier, attackDamage, attackSpeed, reach, properties)`.
2. Keep `DaydreamSpearItem` as a thin subclass (or alias) for compat: `super(ModToolMaterials.DAYDREAM, 4.5F, -2.4F, 1.5D, props)`.
3. New hero weapon = one-line registration:
   ```java
   ITEMS.register("element_01_spear", () -> new KingdomSpearItem(ModToolMaterials.ELEMENT_01, 5.0F, -2.4F, 1.5D, new Item.Properties()));
   ```
4. Swords/axes/etc. use vanilla `SwordItem`/`AxeItem` with `createAttributes(...)` — see `ModItems` Daydream tools. Only spears/tridents/polearms need the custom class.
5. Tune per-hero in `reference/materials-balance.md` (damage/speed/reach), not in code comments.

## Verify

`./gradlew compileJava runClient` → attack damage tooltip, attack speed, and reach feel correct in-game.
