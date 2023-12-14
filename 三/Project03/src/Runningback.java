public class Runningback extends FootballPlayer{
    private int running_attempts, total_running_yards, touchdowns;
    Runningback() {
        this.running_attempts = 0;
        this.total_running_yards = 0;
        this.touchdowns = 0;
    }
    Runningback(String playerName, String position, String team, int gamesPlayed, int running_attempts, int total_running_yards, int touchdowns) {
        super(playerName, "Running Back", team, gamesPlayed);
        this.running_attempts = running_attempts;
        this.total_running_yards = total_running_yards;
        this.touchdowns = touchdowns;
    }
    double  averageYardsPerGame() {
        return (double) this.total_running_yards * 1.0 / (double) this.getGamesPlayed();
    }
    double averageYardsPerAttempt() {
        return (double) this.total_running_yards * 1.0 / (double) this.running_attempts;
    }
    double averageTouchDownsPerGame() {
        return (double) this.touchdowns * 1.0 / (double) this.getGamesPlayed();
    }
    public void playerRating() {
        int rating = (int) (this.averageTouchDownsPerGame() + this.averageYardsPerAttempt() + this.averageYardsPerGame() / 5.0);
        this.setRating(rating);
    }

    public int getRunning_attempts() {
        return running_attempts;
    }

    public int getTotal_running_yards() {
        return total_running_yards;
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    public void setRunning_attempts(int running_attempts) {
        this.running_attempts = running_attempts;
    }

    public void setTotal_running_yards(int total_running_yards) {
        this.total_running_yards = total_running_yards;
    }

    public void setTouchdowns(int touchdowns) {
        this.touchdowns = touchdowns;
    }

    public String toString() {
        return super.toString() +
                ", Average Yards Per Game: " + this.averageYardsPerGame() +
                ", Average Yards Per Attempt: " + this.averageYardsPerAttempt() +
                ", Average Touch Downs Per Game: " + this.averageTouchDownsPerGame() +
                ", Player's Rating: " + this.getRating();
    }
}
