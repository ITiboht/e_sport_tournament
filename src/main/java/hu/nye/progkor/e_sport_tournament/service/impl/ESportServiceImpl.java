package hu.nye.progkor.e_sport_tournament.service.impl;

import hu.nye.progkor.e_sport_tournament.model.Match;
import hu.nye.progkor.e_sport_tournament.service.ESportService;

import java.util.ArrayList;
import java.util.List;

public class ESportServiceImpl implements ESportService {

    private static final List<Match> DATA_BASE = new ArrayList<>();

    @Override
    public List<Match> getAllMatches() {
        return null;
    }

    @Override
    public Match getMatch(Long id) {
        return null;
    }

    @Override
    public Match createMatch(Match match) {
        return null;
    }

    @Override
    public Match updateMatch(Long id, Match matchUpdate) {
        return null;
    }

    @Override
    public void deleteMatch(Long id) {

    }
}
