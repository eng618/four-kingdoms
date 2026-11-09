package com.fourkingdoms.mod.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Pure unit tests for armor-set bonus constants and additive chance math.
 * <p>
 * These tests do not load Minecraft/NeoForge registries; gameplay integration
 * should be validated with {@code task dev} / {@code task run:server} smoke tests.
 * </p>
 */
class ArmorSetEffectLogicTest {

    @Test
    void intervalTimingMatchesDesign() {
        assertEquals(400, ArmorSetEffectHandler.INTERVAL_TICKS);
        assertEquals(400, ArmorSetEffectHandler.BUFF_DURATION_TICKS);
        assertEquals(200, ArmorSetEffectHandler.SHORT_BUFF_DURATION_TICKS);
        assertEquals(100, ArmorSetEffectHandler.RETALIATION_DURATION_TICKS);
        assertEquals(100, ArmorSetEffectHandler.CLEANSE_THRESHOLD_TICKS);
    }

    @Test
    void additiveChancePerPiece() {
        assertEquals(0.25F, ArmorSetEffectHandler.PER_PIECE_CHANCE);
        assertEquals(0.25F, additiveChance(1));
        assertEquals(0.50F, additiveChance(2));
        assertEquals(0.75F, additiveChance(3));
        assertEquals(1.00F, additiveChance(4));
    }

    private static float additiveChance(int piecesWorn) {
        return ArmorSetEffectHandler.PER_PIECE_CHANCE * piecesWorn;
    }
}
