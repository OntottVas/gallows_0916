package hu.progmatic.gallows_0916.control;

import hu.progmatic.gallows_0916.service.GallowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
    private final GallowsService gallowsService;

    @Autowired
    public GameController(GallowsService gallowsService) {
        this.gallowsService = gallowsService;
    }

    @GetMapping("/play")
    public String play(Model model) {
        model.addAttribute("gameWord", gallowsService.getWordsToArray());
        model.addAttribute("usedCharacters", gallowsService.getUsedCharacters());
        model.addAttribute("counter", gallowsService.getCounter());
        return "play";
    }

    @PostMapping("/guess")
    public String guess(@ModelAttribute ("character") char character) {
        gallowsService.charFind(character);
        return "redirect:/play";
    }


}
