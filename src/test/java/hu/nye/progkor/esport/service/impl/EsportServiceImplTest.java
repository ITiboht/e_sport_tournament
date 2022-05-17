package hu.nye.progkor.esport.service.impl;

import hu.nye.progkor.esport.model.Game;
import hu.nye.progkor.esport.model.Match;
import hu.nye.progkor.esport.model.exception.NotFoundException;
import hu.nye.progkor.esport.service.EsportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EsportServiceImplTest {

  private static final Match LEAGUE_ESPORT_1 = new Match(1L, "2022:05:15", "DFM", "T1", 0, 1, Game.LeagueOfLegends);
  private static final Match LEAGUE_ESPORT_2 = new Match(2L, "2022:05:15", "AZE", "SGB", 0, 1, Game.LeagueOfLegends);
  private static final List<Match> ESPORT_MATCHES = List.of(
          LEAGUE_ESPORT_1,
          LEAGUE_ESPORT_2
  );
  public static final long UNKNOWN_MATCH_ID = -1L;
  public static final String ESPORT_GAME_TEAM_1 = "G2 Esports";

  private EsportService underTest;

  @BeforeEach
  void setUp() {
    underTest = new EsportServiceImpl(ESPORT_MATCHES);
  }

  /*
  @Test
  void getAllMatchesShouldReturnAllMatches() {
    //when
    final List<Match> actual = underTest.getAllMatches();
    //then
    assertThat(actual).isEqualTo(ESPORT_MATCHES);
  }

   */

  /*
  @Test
  void getMatchShouldReturnMatchWhenGivenIdOfExistingMatch() {
    //when
    final Match actual = underTest.getMatch(LEAGUE_ESPORT_1.getId());
    //then
    assertThat(actual).isEqualTo(LEAGUE_ESPORT_1);
  }

   */

  @Test
  void getMatchShouldThrowNotFoundExceptionWhenGivenIdOfNotExistingMatch() {
    //when then
    assertThrows(NotFoundException.class, () -> underTest.getMatch(UNKNOWN_MATCH_ID));
  }

  @Test
  void createMatchShouldReturnMatchWhenDelegateIt() {
    //given
    final Match leagueMatch = new Match(null, "2022:05:14", "G2 Esports", "Evil Geniuses", 1, 0, Game.LeagueOfLegends);
    final Match expectedMatch = new Match(3L, "2022:05:14", ESPORT_GAME_TEAM_1, "Evil Geniuses", 1, 0, Game.LeagueOfLegends);
    //when
    final Match actual = underTest.createMatch(leagueMatch);
    //then
    assertThat(actual).isEqualTo(expectedMatch);
  }

  @Test
  void updateMatchShouldReturnUpdatedMatchWhenGivenExistingMatch(){
    //given
    final Match league1 = new Match(null, "2022:05:14", ESPORT_GAME_TEAM_1, "Evil Geniuses", 1, 0, Game.LeagueOfLegends);
    final Match expected = new Match(LEAGUE_ESPORT_1.getId(),"2022:05:14" , ESPORT_GAME_TEAM_1, "Evil Geniuses", 1, 0, Game.LeagueOfLegends);
    //when
    final Match actual = underTest.updateMatch(LEAGUE_ESPORT_1.getId(), league1);
    //then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void updateMatchShouldThrowNotFoundExceptionWhenGivenIdOfNotExistingMatch() {
    //given
    final Match leagueMatch = new Match(null, "2022:05:14", "G2 Esports", "Evil Geniuses", 1, 0, Game.LeagueOfLegends);
    //when then
    assertThrows(NotFoundException.class, () -> underTest.updateMatch(UNKNOWN_MATCH_ID, leagueMatch));
  }

  /*
  @Test
  void deleteMatchShouldDeleteMatchWhenGivenIdOfMatch() {
    //given
    final List<Match> expectedMatches = List.of(LEAGUE_ESPORT_1);
    //when
    underTest.deleteMatch(LEAGUE_ESPORT_2.getId());
    final List<Match> actual = underTest.getAllMatches();
    //then
    assertThat(actual).isEqualTo(expectedMatches);
  }
   */

}