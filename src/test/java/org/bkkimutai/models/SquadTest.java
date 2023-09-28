package org.bkkimutai.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.bkkimutai.models.Squad;

public class SquadTest {

    private Squad squad;

    @BeforeEach
    void setUp() {
        squad = new Squad("Test Squad", "Test Cause", 5);
    }

    @Test
    void testGetSquadName() {
        assertEquals("Test Squad", squad.getSquadName());
    }

    @Test
    void testGetSquadCause() {
        assertEquals("Test Cause", squad.getSquadCause());
    }

    @Test
    void testGetMaxSize() {
        assertEquals(5, squad.getMaxSize());
    }

    @Test
    void testGetSquadId() {
        assertEquals(1, squad.getSquadId());
    }

    @Test
    void testIsSquadFull() {
        assertFalse(squad.isSquadFull());
    }


}
