package hu.nye.progkor.esport.service.impl;

import hu.nye.progkor.esport.model.Game;
import hu.nye.progkor.esport.model.Match;
import hu.nye.progkor.esport.model.exception.NotFoundException;
import hu.nye.progkor.esport.service.ESportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ESportServiceImpl implements ESportService {

  private static final List<Match> DATA_BASE = new ArrayList<>();

  @Autowired
  public ESportServiceImpl() {
    DATA_BASE.add(new Match(1L, "2022:05:15", "AZE", "SGB", 0, 1, Game.LeagueOfLegends));
    DATA_BASE.add(new Match(2L, "2022:05:15", "DFM", "T1", 0, 1, Game.LeagueOfLegends));
  }

  public ESportServiceImpl(final List<Match> matches) {
    DATA_BASE.addAll(matches);
  }

  @Override
  public List<Match> getAllMatches() {
    return Collections.unmodifiableList(DATA_BASE);
  }

  @Override
  public Match getMatch(final Long id) {
    return DATA_BASE.stream().filter(Match -> Match.getId()
                    .equals(id))
            .findFirst()
            .orElseThrow(NotFoundException::new);
  }

  @Override
  public Match createMatch(final Match match) {

    match.setId(getNextId());
    DATA_BASE.add(match);
    return match;

  }

  @Override
  public Match updateMatch(final Long id, final Match matchUpdate) {

    final Match match = getMatch(id);
    match.setDate_of_match(matchUpdate.getDate_of_match());
    match.setName_of_team_1(matchUpdate.getName_of_team_1());
    match.setName_of_team_2(matchUpdate.getName_of_team_2());
    match.setPoints_of_team_1(matchUpdate.getPoints_of_team_1());
    match.setPoints_of_team_2(matchUpdate.getPoints_of_team_2());
    match.setGame(matchUpdate.getGame());
    return match;

  }

  @Override
  public void deleteMatch(final Long id) {

    final Match match = getMatch(id);
    DATA_BASE.remove(match);

  }

  private long getNextId() {

    return getLastId() + 1L;

  }

  private long getLastId() {

    return DATA_BASE.stream()
            .mapToLong(Match::getId)
            .max()
            .orElse(0);

  }

}
