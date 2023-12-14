public class Quarterback extends FootballPlayer{
    private int pass_attempts, pass_completed, touchdowns_passing, total_yards_passing;
    Quarterback() {
        this.pass_attempts = 0;
        this.pass_completed = 0;
        this.total_yards_passing = 0;
        this.touchdowns_passing = 0;
    }
    Quarterback(String playerName, String position, String team, int gamesPlayed, int pass_attempts, int pass_completed, int touchdowns_passing, int total_yards_passing) {
        super(playerName, "Quarter Back", team, gamesPlayed);
        this.pass_attempts = pass_attempts;
        this.pass_completed = pass_completed;
        this.touchdowns_passing = touchdowns_passing;
        this.total_yards_passing = total_yards_passing;
    }
    double completionPercentage() {
        return (double) this.pass_completed * 1.0 / (double) this.pass_attempts;
    }
    double  averagePassingYardsPerGame() {
        return (double) this.total_yards_passing * 1.0 / (double) this.getGamesPlayed();
    }
    double averageTouchDownsPerGame() {
        return (double) touchdowns_passing * 1.0 / (double) getGamesPlayed();
    }

    public int getPass_attempts() {
        return pass_attempts;
    }

    public int getPass_completed() {
        return pass_completed;
    }

    public int getTouchdowns_passing() {
        return touchdowns_passing;
    }

    public int getTotal_yards_passing() {
        return total_yards_passing;
    }

    public void setPass_attempts(int pass_attempts) {
        this.pass_attempts = pass_attempts;
    }

    public void setPass_completed(int pass_completed) {
        this.pass_completed = pass_completed;
    }

    public void setTotal_yards_passing(int total_yards_passing) {
        this.total_yards_passing = total_yards_passing;
    }

    public void setTouchdowns_passing(int touchdowns_passing) {
        this.touchdowns_passing = touchdowns_passing;
    }
    public void playerRating() {
        int rating = (int) (this.averagePassingYardsPerGame() + this.completionPercentage() * 100.0 + this.averagePassingYardsPerGame() / 5.0);
        this.setRating(rating);
    }

    public String toString() {
        return super.toString() +
                ", Completion Percentage: " + this.completionPercentage() +
                ", Average Passing Yards Per Game: " + this.averagePassingYardsPerGame() +
                ", Average Touch Downs Per Game: " + this.averageTouchDownsPerGame() +
                ", Player's Rating: " + this.getRating();
    }
}
