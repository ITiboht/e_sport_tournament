package hu.nye.progkor.esport.controller;

import hu.nye.progkor.esport.model.Match;
import hu.nye.progkor.esport.service.ESportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
