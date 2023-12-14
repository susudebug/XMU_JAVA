public class Defensiveback extends FootballPlayer{
    private int tackles, interceptions, forced_fumbles;
    Defensiveback() {
        this.tackles = 0;
        this.interceptions = 0;
        this.forced_fumbles = 0;
    }
    Defensiveback(String playerName, String position, String team, int gamesPlayed, int tackles, int interceptions, int forced_fumbles) {
        super(playerName, "Defensive Back", team, gamesPlayed);
        this.tackles = tackles;
        this.interceptions = interceptions;
        this.forced_fumbles = forced_fumbles;
    }
    double  averageTacklesPerGame() {
        return (double) this.tackles * 1.0 / (double) this.getGamesPlayed();
    }
    double averageInterceptionsPerGame() {
        return (double) this.interceptions * 1.0 / (double) this.getGamesPlayed();
    }
    double averageForcedFumblesPerGame() {
        return (double) this.forced_fumbles * 1.0 / (double) this.getGamesPlayed();
    }
    public void playerRating() {
        int rating = (int) ((this.averageTacklesPerGame() + this.averageInterceptionsPerGame() + this.averageForcedFumblesPerGame() / 5.0) * 10.0);
        this.setRating(rating);
    }

    public int getForced_fumbles() {
        return forced_fumbles;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public int getTackles() {
        return tackles;
    }

    public void setForced_fumbles(int forced_fumbles) {
        this.forced_fumbles = forced_fumbles;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public void setTackles(int tackles) {
        this.tackles = tackles;
    }

    public String toString() {
        return super.toString() +
                ", Average Yards Per Game: " + this.averageTacklesPerGame() +
                ", Average Yards Per Attempt: " + this.averageInterceptionsPerGame() +
                ", Average Touch Downs Per Game: " + this.averageForcedFumblesPerGame() +
                ", Player's Rating: " + this.getRating();
    }
}
