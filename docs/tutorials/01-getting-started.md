# Tutorial 1 — Getting Started

Goal: run the mod in the Minecraft client and see the Daydream set. ~15 minutes.

## 1. Prerequisites

* JDK 21: `java -version` must print `21.x`.
* No manual Gradle install — use `./gradlew` wrapper.

## 2. First run

```bash
./gradlew --refresh-dependencies
./gradlew compileJava
./gradlew runClient
```

A dev Minecraft client launches with the mod loaded. Check the log for:

```text
Initializing Four Kingdoms Mod - Dream Kingdom & Daydream Set!
```

## 3. Find the items

1. Open Creative inventory → tab **Four Kingdoms: Dream Kingdom**.
2. Confirm: Daydream's Spear, Helmet, Chestplate, Leggings, Boots, Pickaxe, Axe, Shovel, Hoe, plus 8 infused leathers.
3. Equip the armor, swing the spear — reach should feel ~1.5 blocks longer.

## 4. If it fails

* `toolchain` errors → wrong JDK; point `JAVA_HOME` at JDK 21.
* Missing tab → check `FourKingdomsMod` registered `ModItems`, `ModArmorMaterials`, `ModCreativeTabs` on the event bus.
* Missing textures → confirm files under `src/main/resources/assets/four_kingdoms/`.

Next: [02-first-armor-set-tour](02-first-armor-set-tour.md)
