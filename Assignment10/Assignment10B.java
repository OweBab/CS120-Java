public class Assignment10B {

    static class Player {
        String name;
        String team;
        int goals;
        int assists;
        int points;

        Player(String name, String team, int goals, int assists, int points) {
            this.name = name;
            this.team = team;
            this.goals = goals;
            this.assists = assists;
            this.points = points;
        }
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Connor McDavid", "EDM", 48, 90, 138),
            new Player("Nathan MacKinnon", "COL", 53, 74, 127),
            new Player("Nikita Kucherov", "TBL", 44, 86, 130),
            new Player("Macklin Celebrini", "SJS", 45, 70, 115),
            new Player("Leon Draisaitl", "EDM", 35, 62, 97),
            new Player("Auston Matthews", "TOR", 42, 48, 90),
            new Player("David Pastrnak", "BOS", 38, 55, 93),
            new Player("Mark Scheifele", "WPG", 40, 55, 95),
            new Player("Nick Suzuki", "MTL", 35, 60, 95),
            new Player("Kirill Kaprizov", "MIN", 40, 52, 92),
            new Player("Jason Robertson", "DAL", 36, 55, 91)
        };

        sortPlayers(players);

        System.out.printf("%-18s%-6s%6s%6s%6s%n", "Player", "Team", "G", "A", "P");
        for (int i = 0; i < players.length; i++) {
            System.out.printf("%-18s%-6s%6d%6d%6d%n",
                players[i].name, players[i].team,
                players[i].goals, players[i].assists, players[i].points);
        }
    }

    // Bubble sort: goals (desc), then points (desc), then name (A-Z)
    public static void sortPlayers(Player[] players) {
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - 1 - i; j++) {
                if (comesAfter(players[j], players[j + 1])) {
                    Player temp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = temp;
                }
            }
        }
    }

    // Return true if a should come after b in the sorted order
    public static boolean comesAfter(Player a, Player b) {
        if (a.goals != b.goals) {
            return a.goals < b.goals;
        }
        if (a.points != b.points) {
            return a.points < b.points;
        }
        return a.name.compareTo(b.name) > 0;
    }
}
