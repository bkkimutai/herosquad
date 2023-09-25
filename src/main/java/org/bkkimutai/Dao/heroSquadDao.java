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
}
