package org.bkkimutai.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class HeroTest {
    private Hero hero;

    @BeforeEach
    public void setUp() {
        hero = new Hero("Superman", 30, "Flight", "Kryptonite", 1);
    }

    @Test
    public void testGetHeroName() {
        assertEquals("Superman", hero.getHeroName());
    }

    @Test
    public void testSetHeroName() {
        hero.setHeroName("Batman");
        assertEquals("Batman", hero.getHeroName());
    }

    @Test
    public void testGetHeroAge() {
        assertEquals(30, hero.getHeroAge());
    }

    @Test
    public void testSetHeroAge() {
        hero.setHeroAge(35);
        assertEquals(35, hero.getHeroAge());
    }

    @Test
    public void testGetHeroPower() {
        assertEquals("Flight", hero.getHeroPower());
    }

    @Test
    public void testSetHeroPower() {
        hero.setHeroPower("Super Strength");
        assertEquals("Super Strength", hero.getHeroPower());
    }

    @Test
    public void testGetHeroWeakness() {
        assertEquals("Kryptonite", hero.getHeroWeakness());
    }

    @Test
    public void testSetHeroWeakness() {
        hero.setHeroWeakness("None");
        assertEquals("None", hero.getHeroWeakness());
    }

    @Test
    public void testGetHeroId() {
        assertEquals(1, hero.getHeroId());
    }

    @Test
    public void testSetHeroId() {
        hero.setHeroId(2);
        assertEquals(2, hero.getHeroId());
    }

    @Test
    public void testGetSquadId() {
        assertEquals(1, hero.getSquadId());
    }

    @Test
    public void testSetSquadId() {
        hero.setSquadId(2);
        assertEquals(2, hero.getSquadId());
    }
}
