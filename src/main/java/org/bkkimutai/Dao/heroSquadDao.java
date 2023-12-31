package org.bkkimutai.Dao;

import org.bkkimutai.Config.Database;
import org.bkkimutai.models.Hero;
import org.bkkimutai.models.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class heroSquadDao {
    private static Sql2o sql2o = Database.getDatabase();

    public static List<Squad> getAllSquads() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM squads;")
                    .executeAndFetch(Squad.class);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static List<Hero> getAllHeros() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM heros;")
                    .executeAndFetch(Hero.class);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static void addSquad(Squad newSquad) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("INSERT INTO squads (squadName, squadCause, maxSize) " +
                            "VALUES (:squadName, :squadCause, :maxSize)")
                    .addParameter("squadName", newSquad.getSquadName())
                    .addParameter("squadCause", newSquad.getSquadCause())
                    .addParameter("maxSize", newSquad.getMaxSize())
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void addHero(Hero newHero) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("INSERT INTO heros (heroName, heroAge, heroPower, heroWeakness, squadId) " +
                            "VALUES (:heroName, :heroAge, :heroPower, :heroWeakness, :squadId)")
                    .addParameter("heroName", newHero.getHeroName())
                    .addParameter("heroAge", newHero.getHeroAge())
                    .addParameter("heroPower", newHero.getHeroPower())
                    .addParameter("heroWeakness", newHero.getHeroWeakness())
                    .addParameter("squadId", newHero.getSquadId())
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static Hero findHeroById(int heroId) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM heros WHERE heroId = :heroId;")
                    .addParameter("heroId", heroId)
                    .executeAndFetchFirst(Hero.class); // Fetch the first result
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null; // Handle exceptions appropriately
        }
    }

    public static Squad findSquadById(int squadId) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM squads WHERE squadId = :squadId")
                    .addParameter("squadId", squadId)
                    .executeAndFetchFirst(Squad.class); // Fetch the first result
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null; // Handle exceptions appropriately
        }
    }

    public static List<Hero> getAllHerosBySquad(int squadId) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM heros WHERE squadId = :squadId")
                    .addParameter("squadId", squadId)
                    .executeAndFetch(Hero.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null; // Handle exceptions appropriately
        }
    }

    public static void deleteSquadById(int squadId) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM squads WHERE squadId = :squadId;")
                    .addParameter("squadId", squadId)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void deleteHeroById(int heroId) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM heros WHERE heroId = :heroId;")
                    .addParameter("heroId", heroId)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static void updateHero(Hero updatedHero) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE heros SET heroName = :heroName, heroAge = :heroAge, " +
                            "heroPower = :heroPower, heroWeakness = :heroWeakness, squadId = :squadId " +
                            "WHERE heroName = :heroName")
                    .addParameter("heroName", updatedHero.getHeroName())
                    .addParameter("heroAge", updatedHero.getHeroAge())
                    .addParameter("heroPower", updatedHero.getHeroPower())
                    .addParameter("heroWeakness", updatedHero.getHeroWeakness())
                    .addParameter("squadId", updatedHero.getSquadId())
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
