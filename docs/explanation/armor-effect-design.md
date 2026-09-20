# Explanation: Armor Effect Design

Why server tick + probability, and why Nightmare cleanses instead of reducing damage:

* **Tick, not attribute:** Speed/Regen are `MobEffect`s, and Wither/Poison/Slowness mitigation has no vanilla attribute. A 400-tick server handler is the only mixin-free path and matches the "every 20 seconds" spec exactly.
* **Per-piece 25% rolls:** matches spec ("for each piece of armor") and makes 1pc weak / 4pc reliable (~68% ≥1 success) without hard full-set gating.
* **Nightmare option A:** true per-tick damage reduction would require mixins into each effect's damage path and risks mod conflicts. Duration-cut/cleanse delivers the same player-visible outcome (less time suffering) with events only.
* **Perf/safety:** one handler, one interval, `isClientSide` guard, no per-tick scanning. All tuning lives in `materials-balance.md`.
