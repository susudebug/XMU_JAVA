public class FootballTeam {
    private String team_name, team_owner;
    private FootballPlayer[] numbers;
    int currentIndex = 0;
    FootballTeam(String team_name, String team_owner, int size) {
        this.team_name = team_name;
        this.team_owner = team_owner;
        this.numbers = new FootballPlayer[size];
        this.currentIndex = 0;
    }
    public void addPlayer(FootballPlayer x) {
        if(x == null) {
            System.out.println("FootballPlayer x is NULL!");
        }
        else {
            if (this.currentIndex == this.numbers.length) {
                System.out.println("The team is full!");
            }
            else {
                this.numbers[this.currentIndex++] = x;
                System.out.println("Successfully add!");
            }
        }
    }
    public String findPlayerByPosition(String pos) {
        String res = "";
        Boolean flag = false;
        for (int i = 0; i < this.currentIndex; i++) {
            if (this.numbers[i].getPosition().equals(pos)) {
                res = this.numbers[i].toString();
                flag = true;
                break;
            }
        }
        if (!flag) res = "Cannot find the FootballPlayer by the position";
        return res;
    }

    public String toString() {
        String res = "Team Name: " + this.team_name + ", Team Owner: " + this.team_owner + "\n";
        for (int i = 0; i < this.currentIndex; i++) {
            res += this.numbers[i].toString() + "\n";
        }
        return res;
    }
}
