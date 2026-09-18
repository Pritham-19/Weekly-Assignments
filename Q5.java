import java.util.Arrays;

public class Q5 {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Experience-only rule
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Matches + fitness rule
        static boolean isDraftable(int matchesPlayed,
                                   boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        // Sort by batting average in descending order
        @Override
        public int compareTo(Player other) {
            return Double.compare(
                other.battingAverage,
                this.battingAverage
            );
        }
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed) ||
                Player.isDraftable(player.matchesPlayed,
                                   player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        // Create array containing only draftable players
        Player[] finalPlayers = Arrays.copyOf(draftable, count);

        // Sort using compareTo()
        Arrays.sort(finalPlayers);

        String result = "";

        for (int i = 0; i < finalPlayers.length; i++) {

            result += (i + 1) + ". " +
                      finalPlayers[i].name;

            if (i < finalPlayers.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),

            new Player("Rahul", 7, 55.0, false),

            new Player("Sameer", 3, 60.0, false),

            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}