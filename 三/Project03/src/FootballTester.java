public class FootballTester {
    FootballTester(){}
    public static void main(String[] args) {
        Quarterback q1 = new Quarterback("Phil Sims", "Quarter Back", "Giants", 10, 7, 5, 8, 3);
        Quarterback q2 = new Quarterback("Steve Young", "Quarter Back", "49ers", 11, 8, 8, 8, 4);
        Runningback r1 = new Runningback("Jim Brown", "Running Back", "Browns", 14, 12, 7, 6);
        Runningback r2 = new Runningback("Saquon Barkley", "Running Back", "Giants", 11, 9,7, 10);
        Defensiveback d1 = new Defensiveback("Spider Lockart", "Defensive Back", "Giants", 11, 12, 3, 2);
        Defensiveback d2 = new Defensiveback("Aqib Talib","Defensive Back", "Rams", 7, 10, 3, 11);
        FootballTeam team1 = new FootballTeam("team1", "HarryPotter", 10);
        FootballTeam team2 = new FootballTeam("team2", "TomRiddle", 9);
        team1.addPlayer(q1);
        team1.addPlayer(r1);
        team1.addPlayer(d1);
        team2.addPlayer(q2);
        team2.addPlayer(r2);
        team2.addPlayer(d2);
        System.out.println("");
        System.out.println("Information of 1st team");
        System.out.println("");
        System.out.print(team1.toString());
        System.out.println("");
        System.out.println("Information of 2nd team");
        System.out.println("");
        System.out.print(team2.toString());
        System.out.println("");
        System.out.println("Testing Finding player by position");
        System.out.println("Comparing " + q1.getPlayerName() + "with " + d2.getPlayerName());
        if (q1.compareTo(d2) == 1) System.out.println(q1.getPlayerName() + " has a higher rating");
        else if (q1.compareTo(d2) == -1) System.out.println(d2.getPlayerName() + " has a higher rating");
        else System.out.println(q1.getPlayerName() + " has the same rating with " + q2.getPlayerName());
        System.out.println("");
        System.out.println("Testing Finding player by position");
        System.out.println(team1.findPlayerByPosition("Running Back"));
        System.out.println("");
        System.out.println(team2.findPlayerByPosition("run"));
    }
}
