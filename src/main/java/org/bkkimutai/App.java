package org.bkkimutai;

import org.bkkimutai.models.HeroWithSquad;
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
            List<HeroWithSquad> heroesWithSquads = heroWithSquadDao.getAllHerosWithSquads();
            payload.put("heroesWithSquads", heroesWithSquads);
            return new ModelAndView(payload, "index.hbs");
        }, new HandlebarsTemplateEngine());

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
        post("/heros", (request, response) -> {
            Map<String, Object> payload = new HashMap<>();
            String heroName = request.queryParams("heroName");
            int heroAge = Integer.parseInt(request.queryParams("heroAge"));
            String heroPower = request.queryParams("heroPower");
            String heroWeakness = request.queryParams("heroWeakness");
            int squadId = Integer.parseInt(request.queryParams("squadId"));
            Hero newHero = new Hero(heroName, heroAge, heroPower, heroWeakness, squadId);
            heroSquadDao.addHero(newHero);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //display a single hero from a squad
        get("/squads/:squadId/heros/:heroId", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int heroId = Integer.parseInt(request.params("heroId"));
            Hero foundHero = heroSquadDao.findHeroById(heroId);
            model.put("hero", foundHero);
            int squadId = Integer.parseInt(request.params("squadId"));
            Squad foundSquad = heroSquadDao.findSquadById(squadId);
            model.put("squad", foundSquad);
            model.put("squads", heroWithSquadDao.getAllHerosWithSquads());
            return new ModelAndView(model, "hero-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:squadId", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadToFindId = Integer.parseInt(request.params("squadId"));
            Squad foundSquad = heroSquadDao.findSquadById(squadToFindId);
            model.put("squad", foundSquad);
            List<Hero> allHerosBySquad = heroSquadDao.getAllHerosBySquad(squadToFindId);
            model.put("heros", allHerosBySquad);
            model.put("squads", heroSquadDao.getAllSquads());
            return new ModelAndView(model, "squad-details.hbs");
        }, new HandlebarsTemplateEngine());

        //delete squad by id
        get("/squads/:squadId/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToDelete = Integer.parseInt(request.params("squadId"));
            heroSquadDao.deleteSquadById(idOfSquadToDelete);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //delete hero by id
        get("squads/:squadId/heros/:heroId/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(request.params("heroId"));
            heroSquadDao.deleteHeroById(idOfHeroToDelete);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/allherossquads/all", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> allSquadHeros = heroSquadDao.getAllSquads();
            model.put("squad", allSquadHeros);
            return new ModelAndView(model, "allherosquad-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:squadId/heros/:heroId/update-hero", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int heroId = Integer.parseInt(req.params("heroId"));
            Hero foundHero = heroSquadDao.findHeroById(heroId);
            model.put("hero", foundHero);
            int squadId = Integer.parseInt(req.params("squadId"));
            Squad foundSquad = heroSquadDao.findSquadById(squadId);
            model.put("squad", foundSquad);
            model.put("squads", heroSquadDao.getAllSquads());
            return new ModelAndView(model, "update-hero.hbs");
        }, new HandlebarsTemplateEngine());

        post("/update-hero", (req, res) -> {
            Map<String, Object> payload = new HashMap<>();
            String heroName = req.queryParams("heroName");
            int heroAge = Integer.parseInt(req.queryParams("heroAge"));
            String heroPower = req.queryParams("heroPower");
            String heroWeakness = req.queryParams("heroWeakness");
            int squadId = Integer.parseInt(req.queryParams("squadId"));
            Hero updatedHero = new Hero(heroName, heroAge, heroPower, heroWeakness, squadId);
            heroSquadDao.updateHero(updatedHero);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

    }

}