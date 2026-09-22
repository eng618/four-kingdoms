# 👑 Four Kingdoms Minecraft Mod

[![Build & Test](https://github.com/eng618/four-kingdoms/actions/workflows/build.yml/badge.svg)](https://github.com/eng618/four-kingdoms/actions/workflows/build.yml)
[![Release](https://github.com/eng618/four-kingdoms/actions/workflows/release.yml/badge.svg)](https://github.com/eng618/four-kingdoms/actions/workflows/release.yml)

A rich **Minecraft 1.21.1 NeoForge** mod introducing four distinct lore-rich kingdoms, custom armor sets, weapons, tools, and iconic hero gear.

---

## 🏰 The Four Kingdoms Universe

1. **✨ Dream Kingdom**: A realm of hope, light, and ethereal crystal power.
   - **Hero Highlight:** **Daydream**
   - **Theme & Colors:** Luminous whites, soft light grays, and amethyst violet highlights.
   - **Materials:** Amethyst Shards & Diamonds.
   - **Signature Weapon:** **Daydream's Spear** (custom polearm with bonus melee reach).
2. **🔥 Element Kingdom**: Primal forces of fire, storm, earth, and ocean.
3. **🌿 Wild Kingdom**: Untamed nature, organic beast armors, and druidic weaponry.
4. **🏛️ Forgotten Kingdom**: Ancient lost armor, subterranean relics, and shadow magic.

---

## 🚀 Technical Requirements

- **Minecraft Version:** `1.21.1`
- **Mod Loader:** `NeoForge 21.1.247`
- **Java Development Kit (JDK):** `Java 21`
- **Build Tool:** `Gradle 8.10` with `ModDevGradle 2.0.75`

---

## 📂 Project Architecture & Entry Points

```
MCMod_Four_Kingdoms_MOD/
├── build.gradle                               # Core Gradle build script with NeoForge ModDevGradle setup
├── gradle.properties                          # Global project variables (mod_id, versions, group_id)
├── settings.gradle                            # Gradle settings & plugin repositories
├── README.md                                  # Developer & architecture documentation
└── src/
    └── main/
        ├── java/com/fourkingdoms/mod/
        │   ├── FourKingdomsMod.java            # [ENTRY POINT] Main @Mod class initializing all registries
        │   ├── item/
        │   │   └── DaydreamSpearItem.java     # Custom Spear item class with extended entity attack reach
        │   ├── material/
        │   │   ├── ModArmorMaterials.java      # Armor stats (durability, defense, equipment layer JSON)
        │   │   └── ModToolMaterials.java       # Tool material stats (mining speed, durability, damage)
        │   └── registry/
        │       ├── ModItems.java               # DeferredRegister for all mod items, weapons, and armor
        │       └── ModCreativeTabs.java        # Custom "Four Kingdoms: Dream Kingdom" creative mode tab
        └── resources/
            ├── META-INF/
            │   └── neoforged.mods.toml         # NeoForge mod metadata manifest
            ├── assets/four_kingdoms/
            │   ├── lang/
            │   │   └── en_us.json              # English localization keys
            │   ├── models/
            │   │   ├── equipment/
            │   │   │   └── daydream.json       # NeoForge 1.21 equipment layer texture mapping
            │   │   └── item/                   # 2D Inventory item model definitions
            │   │       ├── daydream_spear.json
            │   │       ├── daydream_helmet.json
            │   │       ├── daydream_chestplate.json
            │   │       ├── daydream_leggings.json
            │   │       ├── daydream_boots.json
            │   │       ├── daydream_pickaxe.json
            │   │       ├── daydream_axe.json
            │   │       ├── daydream_shovel.json
            │   │       └── daydream_hoe.json
            │   └── textures/
            │       ├── entity/equipment/humanoid/
            │       │   └── daydream.png        # 64x32 Player armor rendering texture
            │       └── item/                   # 16x16 PNG Inventory item textures
            └── data/four_kingdoms/
                └── recipe/                     # Crafting recipe JSONs (Amethyst Shard + Diamond)
```

---

## 🛠️ Developer Guide: How to Add New Character Sets

When expanding the mod to add new hero sets (e.g. for the **Wild Kingdom** or **Element Kingdom**), follow this 7-step workflow:

### Step 1: Define Armor & Tool Materials

Add a new material entry in `src/main/java/com/fourkingdoms/mod/material/`:

- **`ModArmorMaterials.java`**: Specify durability multiplier, defense map, equip sound, toughness, repair ingredient, and equipment layer name.
- **`ModToolMaterials.java`**: Specify durability, mining speed, damage bonus, enchantability, and repair ingredient.

### Step 2: Register Items in `ModItems.java`

Use `ITEMS.register` or `ITEMS.registerItem` in `src/main/java/com/fourkingdoms/mod/registry/ModItems.java`:

```java
public static final DeferredItem<Item> NEW_HERO_WEAPON = ITEMS.register("new_hero_weapon",
        () -> new SwordItem(ModToolMaterials.NEW_HERO, new Item.Properties()));
```

### Step 3: Add to Creative Mode Tab

Update `src/main/java/com/fourkingdoms/mod/registry/ModCreativeTabs.java` to list your new item in the appropriate kingdom tab.

### Step 4: Add Localization Keys

Add human-readable display names in `src/main/resources/assets/four_kingdoms/lang/en_us.json`:

```json
"item.four_kingdoms.new_hero_weapon": "Hero's Blade"
```

### Step 5: Create Model JSON Files

- **Item Models (`assets/four_kingdoms/models/item/*.json`)**: Define 2D inventory parent (`minecraft:item/handheld` for tools/weapons, `minecraft:item/generated` for armor).
- **Equipment Layer Model (`assets/four_kingdoms/models/equipment/*.json`)**: Link humanoid layer textures for rendering worn armor on entity models.

### Step 6: Add Textures

- **Item Icons (`assets/four_kingdoms/textures/item/*.png`)**: 16x16 PNG icons.
- **Worn Armor Textures (`assets/four_kingdoms/textures/entity/equipment/humanoid/*.png`)**: 64x32 PNG equipment layer texture.

### Step 7: Add Crafting Recipes

Create recipe JSON files in `src/main/resources/data/four_kingdoms/recipe/`.

---

## ⚡ Build & Run Commands

| Task | Command | Description |
| :--- | :--- | :--- |
| **Install Dependencies** | `./gradlew --refresh-dependencies` | Downloads & resolves Java/NeoForge dependencies |
| **Compile Code** | `./gradlew compileJava` | Compiles Java classes in `src/main/java` |
| **Check Linting** | `./gradlew spotlessCheck` | Validates code formatting, unused imports, & style |
| **Auto-Format Code** | `./gradlew spotlessApply` | Automatically formats all Java source files |
| **Run Static Analysis** | `./gradlew check` | Runs Spotless and static code verification |
| **Test Client** | `./gradlew runClient` | Launches Minecraft client with the mod loaded |
| **Build JAR** | `./gradlew build` | Generates compiled `.jar` artifact in `build/libs/` |
| **Test Server** | `./gradlew runServer` | Launches dedicated Minecraft test server |

---

## 🛠️ Prerequisites & VS Code Setup

### 1. Installed Software

- **Java 21 (JDK 21):** Required for Minecraft 1.21.1 and NeoForge.
  - *macOS (Homebrew):* `brew install openjdk@21`
  - *Verify:* `java -version`
- **Gradle Wrapper:** Automatically included in the workspace repository via `./gradlew`. No manual Gradle installation required.

### 2. Recommended VS Code Extensions

- **Extension Pack for Java** (Red Hat / Microsoft) — Provides auto-completion, real-time linting, formatting (`Cmd+Shift+F` / `Shift+Alt+F`), and jump-to-definition.
- **Gradle for Java** (Microsoft) — Provides Gradle task runner in VS Code sidebar.

---

## 📜 License & Credits

- **Mod Author:** EnGarcia
- **License:** MIT License
- **Framework:** NeoForge 1.21.1

---

## 🚢 Releasing

- Use [Conventional Commits](https://www.conventionalcommits.org/) (`feat:`, `fix:`, `feat!:`).
- All types (`feat/fix/perf/revert/docs/style/refactor/test/build/ci/chore`) appear in the changelog (see `release-please-config.json`) and are linted by the **Commitlint** workflow on PRs and `main` pushes — non-conforming messages fail CI.
- On push to `main`, **Release Please** opens/updates a Release PR with changelog + version bump. Merging it creates tag `vX.Y.Z` + GitHub Release.
- Tag push triggers `Release` workflow: builds with `-Pmod_version=X.Y.Z` (overrides `gradle.properties`), attaches jar to GitHub Release.
- **Modrinth / CurseForge** auto-enable once secrets exist (skipped otherwise).
  Each release also syncs `MODRINTH.md` to the Modrinth project page and reuses the GitHub release notes as changelog:

| Secret | Description |
| :--- | :--- |
| `MODRINTH_TOKEN` | Modrinth PAT — needs **Create/Read/Write versions** + **Read/Write projects** (for description sync) |
| `MODRINTH_PROJECT_ID` | Modrinth project ID/slug (required — publishing fails against the `unset-modrinth-project` fallback) |
| `CURSEFORGE_TOKEN` / `CURSEFORGE_PROJECT_ID` | CurseForge API token + numeric project ID (optional) |

- Manual release: `Actions > Release > Run workflow`, or `git tag v1.2.3 && git push origin v1.2.3`.
