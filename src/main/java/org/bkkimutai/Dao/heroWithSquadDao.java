package org.bkkimutai.Dao;

import org.bkkimutai.Config.Database;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class heroWithSquadDao {
    private static Sql2o sql2o = Database.getDatabase();

    public static List<HeroWithSquad> getAllHerosWithSquads() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(
                            "SELECT h.heroId, h.heroName, h.squadId, s.squadName " +
                                    "FROM heros h " +
                                    "INNER JOIN squads s ON h.squadId = s.squadId;")
                    .executeAndFetch(HeroWithSquad.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
