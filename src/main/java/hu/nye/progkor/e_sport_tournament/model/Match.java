package hu.nye.progkor.e_sport_tournament.model;

import java.util.Objects;

public class Match {
    private Long id;
    private String date_of_match;
    private String name_of_team_1;
    private String name_of_team_2;
    private int points;
    private Game game;

    public Match(){

    }

    public Match(Long id, String date_of_match, String name_of_team_1, String name_of_team_2, int points, Game game) {
        this.id = id;
        this.date_of_match = date_of_match;
        this.name_of_team_1 = name_of_team_1;
        this.name_of_team_2 = name_of_team_2;
        this.points = points;
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_of_match() {
        return date_of_match;
    }

    public void setDate_of_match(String date_of_match) {
        this.date_of_match = date_of_match;
    }

    public String getName_of_team_1() {
        return name_of_team_1;
    }

    public void setName_of_team_1(String name_of_team_1) {
        this.name_of_team_1 = name_of_team_1;
    }

    public String getName_of_team_2() {
        return name_of_team_2;
    }

    public void setName_of_team_2(String name_of_team_2) {
        this.name_of_team_2 = name_of_team_2;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return points == match.points && Objects.equals(id, match.id) && Objects.equals(date_of_match, match.date_of_match) && Objects.equals(name_of_team_1, match.name_of_team_1) && Objects.equals(name_of_team_2, match.name_of_team_2) && game == match.game;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date_of_match, name_of_team_1, name_of_team_2, points, game);
    }

    @Override
    public String toString() {
        return "ESport{" +
                "id=" + id +
                ", date_of_match='" + date_of_match + '\'' +
                ", name_of_team_1='" + name_of_team_1 + '\'' +
                ", name_of_team_2='" + name_of_team_2 + '\'' +
                ", points=" + points +
                ", game=" + game +
                '}';
    }
}
