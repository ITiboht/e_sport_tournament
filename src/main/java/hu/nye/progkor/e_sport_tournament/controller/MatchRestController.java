package hu.nye.progkor.e_sport_tournament.controller;

import hu.nye.progkor.e_sport_tournament.model.Match;
import hu.nye.progkor.e_sport_tournament.service.ESportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/e-sport")
public class MatchRestController {

  private ESportService eSportService;

  public MatchRestController(ESportService eSportService) {
    this.eSportService = eSportService;
  }

  @GetMapping
  public List<Match> getAllMatches() {
    return eSportService.getAllMatches();
  }

  @GetMapping("/{id}")
  Match getMatch(final @PathVariable("id") Long id) {

    return eSportService.getMatch(id);

  }

  @PostMapping
  Match createMatch(final @RequestBody Match match) {

    return eSportService.createMatch(match);

  }

  @PutMapping("/{id}")
  Match updateMatch(final @PathVariable Long id, final @RequestBody Match matchUpdate) {

    return eSportService.updateMatch(id, matchUpdate);

  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteMatch(final @PathVariable Long id) {
    eSportService.deleteMatch(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
