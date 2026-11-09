package com.fourkingdoms.mod;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FourKingdomsModConstantsTest {

    @Test
    void modIdMatchesResourceNamespace() {
        assertEquals("four_kingdoms", FourKingdomsMod.MOD_ID);
    }
}
