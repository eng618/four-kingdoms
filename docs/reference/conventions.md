# Reference: Conventions

* `mod_id`: `four_kingdoms` (never rename; it prefixes all IDs, lang keys, creative tabs).
* Java packages: `com.fourkingdoms.mod.{registry,material,item,event,entity,client}`.
* Lang keys: `item.four_kingdoms.<id>`, `creativetab.four_kingdoms.<kingdom>`, `entity.four_kingdoms.<mob>`.
* Creative tabs: one per kingdom (`dream_kingdom`, `element_kingdom`, `forgotten_kingdom`, `wild_kingdom` placeholder). Icon = kingdom signature weapon.
* Formatting: `./gradlew spotlessApply` before every commit (removes unused imports, trailing whitespace, enforces newline).
* Docs: Diátaxis quadrants; code-referenced paths in backticks with line hints where stable.
