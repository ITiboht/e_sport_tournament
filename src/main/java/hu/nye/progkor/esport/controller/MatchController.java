package hu.nye.progkor.esport.controller;

import hu.nye.progkor.esport.model.Match;
import hu.nye.progkor.esport.model.exception.NotFoundException;
import hu.nye.progkor.esport.service.ESportService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/e-sport")
public class MatchController {

  private final ESportService eSportService;

  public MatchController(final ESportService eSportService) {
    this.eSportService = eSportService;
  }

  @GetMapping
  public String getAllMatches(final Model model) {

    final List<Match> matches = eSportService.getAllMatches();
    model.addAttribute("matches", matches);
    return "matches";

  }

  @GetMapping("/{id}")
  public String getMatches(final Model model, final @PathVariable Long id) {

    final Match match = eSportService.getMatch(id);
    model.addAttribute("match", match);
    return "edit";

  }

  @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String createMatch(final Model model, final @RequestParam(value = "id", required = false) Long id, final Match matchChanges) {

    final Match match = eSportService.updateMatch(id, matchChanges);
    model.addAttribute("match", match);
    return "edit";

  }

  @GetMapping("/create")
  public String createMatch(final Model model, final Match match) {

    final Match savedMatch = eSportService.createMatch(match);
    model.addAttribute("match", savedMatch);
    return "edit";

  }

  @GetMapping("/{id}/delete")
  public String deleteMatch(final Model model, final @PathVariable("id") Long id) {

    try {
      eSportService.deleteMatch(id);
    } catch (NotFoundException e) {

    }
    final List<Match> matches = eSportService.getAllMatches();
    model.addAttribute("matches", matches);
    return "matches";
  }

}
