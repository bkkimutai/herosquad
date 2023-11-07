package org.bkkimutai.models;

import org.bkkimutai.models.HeroWithSquad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroWithSquadTest {
    private HeroWithSquad heroWithSquad;

    @BeforeEach
    public void setUp() {
        heroWithSquad = new HeroWithSquad(1, "Superman", 1001, "Justice League","Name",1, "FinTech");
    }

    @Test
    public void testGetters() {
        // Test the getters for all fields
        assertEquals(1, heroWithSquad.getHeroId());
        assertEquals("Superman", heroWithSquad.getHeroName());
        assertEquals(1001, heroWithSquad.getSquadId());
        assertEquals("Justice League", heroWithSquad.getSquadName());
    }

    @Test
    public void testSetters() {
        // Test the setters for all fields
        heroWithSquad.setHeroId(2);
        heroWithSquad.setHeroName("Spider-Man");
        heroWithSquad.setSquadId(1002);
        heroWithSquad.setSquadName("Avengers");

        assertEquals(2, heroWithSquad.getHeroId());
        assertEquals("Spider-Man", heroWithSquad.getHeroName());
        assertEquals(1002, heroWithSquad.getSquadId());
        assertEquals("Avengers", heroWithSquad.getSquadName());
    }

    @Test
    public void testConstructor() {
        // Test the constructor that initializes the fields
        assertEquals(1, heroWithSquad.getHeroId());
        assertEquals("Superman", heroWithSquad.getHeroName());
        assertEquals(1001, heroWithSquad.getSquadId());
        assertEquals("Justice League", heroWithSquad.getSquadName());
    }
}
