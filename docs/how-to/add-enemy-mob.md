# How-To: Add an Enemy Mob

Two tracks (locked decision: do both, reskins first).

## Track A — Reskinned vanilla + new ability (no new dependency)

1. Entity class: `entity/DreamWispEntity extends Monster` (example). Override `registerGoals()` to add ability (e.g. ranged slowness projectile, cleanse aura).
2. Register: `DeferredRegister<EntityType<?>> ENTITY_TYPES` in `registry/ModEntities.java`; attributes via `EntityAttributeCreationEvent`; renderer via `EntityRenderersEvent.RegisterRenderers` with existing vanilla model + new texture.
3. Spawn: `BiomeModifiers` JSON in `data/four_kingdoms/neoforge/biome_modifier/` + `tags`.
4. Loot: `data/four_kingdoms/loot_table/entities/<mob>.json` dropping infused leather / shards.
5. Lang + tab (spawn egg): `en_us.json` + `ModItems` egg or `displayItems`.

Minimum v1: 1 mob per inhabited kingdom (Dream, Element, Forgotten).

## Track B — Custom GeckoLib model

1. Add dependency in `build.gradle`: `software.bernie.geckolib:geckolib-neoforge-1.21.1:<version>` (pin version, verify on CurseForge/Maven).
2. Packages: `entity/`, `client/renderer/`, `client/model/` with `GeoEntity`, `GeoModel`, `GeoEntityRenderer`, animation JSON in `assets/four_kingdoms/geckolib/`.
3. Migrate exactly one Track A mob first to prove the pipeline before new rigs.
4. Note the extra ~2 MB jar weight and animation JSON maintenance cost.

## Verify

`runClient`: egg spawns, AI runs, ability fires, loot drops. `runServer`: no client-only class crash (renderer code behind `Dist.CLIENT`).
