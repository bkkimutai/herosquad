package org.bkkimutai;

import org.bkkimutai.Dao.heroSquadDao;
import org.bkkimutai.models.Hero;
import org.bkkimutai.models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //show all heros in all squads and show all squads
        get("/", (req, res)->{
            Map<String, Object> payload = new HashMap<>();
            List<Squad>allSquads = heroSquadDao.getAllSquads();
            payload.put("squads", allSquads);
            List<Hero> heros = heroSquadDao.getAllHeros();
            payload.put("heros",heros);
            return new ModelAndView(payload, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}