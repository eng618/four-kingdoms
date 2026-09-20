# Explanation: Elemental System Design

Nine Element heroes need distinct identities without nine code paths. Approach:

* One `ArmorMaterial` + `Tier` per hero, all consumed through the shared `SetBonus` registry (see `how-to/add-armor-set-bonus.md`).
* Identity comes from three dials: (1) repair ingredient, (2) stat skew (e.g. fire = damage, earth = defense, storm = speed), (3) one tick effect (burn aura, conductivity, …).
* Weapons share `KingdomSpearItem` / vanilla sword classes with per-hero damage/speed/reach rows in `materials-balance.md`.
* Add heroes in vertical slices (one hero fully playable before the next), not horizontal layers (all materials, then all items…), to keep the mod testable at every commit.
