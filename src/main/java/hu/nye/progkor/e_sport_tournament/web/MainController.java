package hu.nye.progkor.e_sport_tournament.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/games")
    public String games() {
        return "games";
    }

    @GetMapping("/matches")
    public String matches() {
        return "matches";
    }

    @GetMapping("/csgo")
    public String csgo() {
        return "csgo";
    }

    @GetMapping("/rl")
    public String rl() {
        return "rl";
    }

    @GetMapping("/sc2")
    public String sc2() {
        return "sc2";
    }

    @GetMapping("/lol")
    public String lol() {
        return "lol";
    }

}
