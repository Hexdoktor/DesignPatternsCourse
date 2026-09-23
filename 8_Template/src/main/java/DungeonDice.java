import java.util.*;

public class DungeonDice extends Game {

    private int[] playerHP;
    private int[] kills;
    private int winner = -1;
    private Random random = new Random();

    // List of players still alive
    private List<Integer> alivePlayers;

    @Override
    public void initializeGame(int numberOfPlayers) {
        playerHP = new int[numberOfPlayers];
        kills = new int[numberOfPlayers];
        alivePlayers = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            playerHP[i] = 10;
            kills[i] = 0;
            alivePlayers.add(i);
        }

        System.out.println("Dungeon Dice begins! First to 10 monster kills wins.");
    }

    @Override
    public boolean endOfGame() {
        // Win by kills
        for (int i = 0; i < kills.length; i++) {
            if (kills[i] >= 10) {
                winner = i;
                return true;
            }
        }

        // Win by being last alive
        if (alivePlayers.size() == 1) {
            winner = alivePlayers.get(0);
            return true;
        }

        return false;
    }

    @Override
    public void playSingleTurn(int turnIndex) {

        if (alivePlayers.isEmpty()) return;

        int realIndex = turnIndex % alivePlayers.size();
        int player = alivePlayers.get(realIndex);

        System.out.println("\nPlayer " + player + ", it's your turn!");
        System.out.println("Press ENTER to open a door...");
        new java.util.Scanner(System.in).nextLine();

        int room = random.nextInt(3); // 0 treasure, 1 monster, 2 trap

        switch (room) {
            case 0:
                System.out.println("You found a treasure room!");
                System.out.println("Gain +1 HP.");
                playerHP[player]++;
                break;

            case 1:
                System.out.println("A monster appears!");

                System.out.println("Do you want to fight or try to run? (f/r)");
                String choice = new java.util.Scanner(System.in).nextLine();

                if (choice.equalsIgnoreCase("r")) {
                    int escapeRoll = random.nextInt(6) + 1;
                    System.out.println("Escape roll: " + escapeRoll);

                    if (escapeRoll >= 4) {
                        System.out.println("You escaped safely!");
                    } else {
                        System.out.println("Escape failed! You lose 2 HP.");
                        playerHP[player] -= 2;
                        if (playerHP[player] <= 0) {
                            System.out.println("Player " + player + " has died!");
                            alivePlayers.remove(Integer.valueOf(player));
                        }
                    }
                    break;
                }

                // Fight
                int playerRoll = random.nextInt(6) + 1;
                int monsterRoll = random.nextInt(6) + 1;

                System.out.println("You roll " + playerRoll + ", Monster rolls " + monsterRoll);

                if (playerRoll >= monsterRoll) {
                    kills[player]++;
                    System.out.println("You defeated the monster! Total kills: " + kills[player]);
                } else {
                    System.out.println("You lost the fight and take 2 damage!");
                    playerHP[player] -= 2;
                    if (playerHP[player] <= 0) {
                        System.out.println("Player " + player + " has died!");
                        alivePlayers.remove(Integer.valueOf(player));
                    }
                }
                break;

            case 2:
                System.out.println("A trap! You lose 1 HP.");
                playerHP[player]--;

                if (playerHP[player] <= 0) {
                    System.out.println("Player " + player + " has died!");
                    alivePlayers.remove(Integer.valueOf(player));
                }
                break;
        }
    }


    @Override
    public void displayWinner() {
        System.out.println("\nPlayer " + winner + " wins the game!");
    }
}
