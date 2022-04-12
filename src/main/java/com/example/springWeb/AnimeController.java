package com.example.springWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping(path = "/")
    public String homePage(Model model){
        List<Anime> animeTop = animeService.getAllAnime();
        model.addAttribute("animeTop", animeTop);
        model.addAttribute("newAnime", new Anime());
        return "home";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addAnime( @ModelAttribute ("anime123") Anime anime){
        animeService.saveAnime(anime);
        return "redirect:/";
    }
}
