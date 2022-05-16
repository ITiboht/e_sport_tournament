package hu.nye.progkor.e_sport_tournament.service;

import hu.nye.progkor.e_sport_tournament.model.Match;

import java.util.List;

public interface ESportService {

  List<Match> getAllMatches();

  Match getMatch(Long id);

  Match createMatch(Match match);

  Match updateMatch(Long id, Match matchUpdate);

  void deleteMatch(Long id);

}
