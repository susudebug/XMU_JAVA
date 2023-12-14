public class FootballPlayer {
        private String playerName, position, team;
        private int gamesPlayed, rating;
        FootballPlayer() {
            this("default", "default", "default", 0);
        }
        FootballPlayer(String playerName, String position, String team, int gamesPlayed) {
            this.playerName = playerName;
            this.position = position;
            this.team = team;
            this.gamesPlayed = gamesPlayed;
        }
        public void playerRating(){
            System.out.println("这是FootballPlayer 中的 playersRating方法");
        }
        public int compareTo(FootballPlayer other) {
            if (this.rating > other.rating) return 1;
            if (this.rating < other.rating) return -1;
            else return 0;
        }

        public String getPlayerName() {
            return playerName;
        }

        public int getGamesPlayed() {
            return gamesPlayed;
        }

        public String getPosition() {
            return position;
        }

        public String getTeam() {
            return team;
        }

    public int getRating() {
        this.playerRating(); // error
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public void setGamesPlayed(int gamesPlayed) {
            this.gamesPlayed = gamesPlayed;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        @Override
        public String toString() {
            return "Name: " + this.playerName +
                    ", Position: " + this.position  +
                    ", Team: " + this.team ;
        }
}
