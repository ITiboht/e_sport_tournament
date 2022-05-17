package hu.nye.progkor.esport.service;

import hu.nye.progkor.esport.model.Match;

import java.util.List;

public interface EsportService {

  List<Match> getAllMatches();

  Match getMatch(Long id);

  Match createMatch(Match match);

  Match updateMatch(Long id, Match matchUpdate);

  void deleteMatch(Long id);

}
