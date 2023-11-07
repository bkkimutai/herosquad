package org.bkkimutai.Dao;

import org.bkkimutai.Config.Database;
import org.bkkimutai.models.HeroWithSquad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class heroWithSquadDao {
    private static Sql2o sql2o = Database.getDatabase();

    public static List<HeroWithSquad> getAllHerosWithSquads() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(
                            "SELECT h.heroId, h.heroName, h.squadId, s.squadName, h.heroName, h.heroAge, h.heroPower, h.heroWeakness " +
                                    "FROM squads s " +
                                    "INNER JOIN heros h ON s.squadId = h.squadId;")
                    .executeAndFetch(HeroWithSquad.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
