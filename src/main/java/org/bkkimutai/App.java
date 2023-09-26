package org.bkkimutai;

import org.bkkimutai.Dao.HeroWithSquad;
import org.bkkimutai.Dao.heroSquadDao;
import org.bkkimutai.Dao.heroWithSquadDao;
import org.bkkimutai.models.Hero;
import org.bkkimutai.models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //show all heros in all squads and show all squads
        get("/", (req, res) -> {
            Map<String, Object> payload = new HashMap<>();

            // Step 1: Retrieve heroes with squads
            List<HeroWithSquad> heroesWithSquads = heroWithSquadDao.getAllHerosWithSquads();

            // Add the list of heroes with squads to the payload
            payload.put("heroesWithSquads", heroesWithSquads);

            // You can also add other data to the payload as needed
            // ...

            // Step 2: Render the Handlebars template with the payload
            return new ModelAndView(payload, "index.hbs");
        }, new HandlebarsTemplateEngine());
//        get("/", (req, res) -> {
//            Map<String, Object> payload = new HashMap<>();
//            List<Squad> squads = heroSquadDao.getAllSquads();
//            payload.put("squads", squads);
//            List<Hero> heros = heroSquadDao.getAllHeros();
//            payload.put("heros", heros);
//            return new ModelAndView(payload, "index.hbs");
//        }, new HandlebarsTemplateEngine());

        //display form to create a new squad
        get("/squads/new", (request, response) -> {
            Map<String, Object> payload = new HashMap<>();
            List<Squad> squads = heroSquadDao.getAllSquads();
            payload.put("squads", squads);
            return new ModelAndView(payload, "new-squad.hbs");
        }, new HandlebarsTemplateEngine());

        //process new squad
        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            String squadCause = request.queryParams("squadCause");
            int maxSize = Integer.parseInt(request.queryParams("maxSize"));
            Squad newSquad = new Squad(squadName, squadCause, maxSize);
            heroSquadDao.addSquad(newSquad);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //show new hero form
        get("/heros/new", (request, response) -> {
            Map<String, Object> payload = new HashMap<>();
            List<Squad> squads = heroSquadDao.getAllSquads();
            payload.put("squads", squads);
            return new ModelAndView(payload, "new-hero.hbs");
        }, new HandlebarsTemplateEngine());

        //process new hero
        post("/heros",(request,response)->{
            Map<String,Object> payload = new HashMap<>();
            String heroName = request.queryParams("heroName");
            int heroAge = Integer.parseInt(request.queryParams("heroAge"));
            String heroPower = request.queryParams("heroPower");
            String heroWeakness = request.queryParams("heroWeakness");
            int squadId = Integer.parseInt(request.queryParams("squadId"));
            Hero newHero = new Hero(heroName,heroAge,heroPower,heroWeakness,squadId);
            heroSquadDao.addHero(newHero);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());



    }
}