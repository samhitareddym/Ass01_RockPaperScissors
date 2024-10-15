import java.util.Scanner;
class RockPaperScissors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playAgain;
        do {
            // Get valid move from Player A
            String playerAMove = getValidMove(in, "Player A");

            // Get valid move from Player B
            String playerBMove = getValidMove(in, "Player B");

            // Display the results
            displayResult(playerAMove, playerBMove);

            // Ask if they want to play again
            System.out.print("Do you want to play again? [Y/N]: ");
            playAgain = in.next();

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        in.close();
    }

    // Method to get a valid move
    public static String getValidMove(Scanner scanner, String playerName) {
        String move;
        while (true) {
            System.out.print(playerName + ", enter your move (R, P, S): ");
            move = scanner.next().trim().toUpperCase();

            if (move.equalsIgnoreCase ("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S")) {
                break;
            } else {
                System.out.println("Invalid move! Please enter R, P, or S.");
            }
        }
        return move;
    }

    // Method to display the result of the rock, paper, scissors game
    public static void displayResult(String playerAMove, String playerBMove) {
        if (playerAMove.equals(playerBMove)) {
            System.out.println(getMoveName(playerAMove) + " vs " + getMoveName(playerBMove) + " – It's a tie!");
        } else if (isPlayerAWinner(playerAMove, playerBMove)) {
            System.out.println(getWinningPhrase(playerAMove, playerBMove) + " – Player A wins!");
        } else {
            System.out.println(getWinningPhrase(playerBMove, playerAMove) + " – Player B wins!");
        }
    }

    // Method to check if Player A is the winner
    public static boolean isPlayerAWinner(String playerAMove, String playerBMove) {
        return (playerAMove.equalsIgnoreCase("R") && playerBMove.equalsIgnoreCase("S")) ||
                (playerAMove.equalsIgnoreCase("P") && playerBMove.equalsIgnoreCase("R")) ||
                (playerAMove.equalsIgnoreCase("S") && playerBMove.equalsIgnoreCase("P"));
    }

    // Method to get the move name
    public static String getMoveName(String move) {
        switch (move) {
            case "R": return "Rock";
            case "P": return "Paper";
            case "S": return "Scissors";
            default: return "";
        }
    }

    // Method to get the winning phrase
    public static String getWinningPhrase(String winnerMove, String loserMove) {
        if (winnerMove.equalsIgnoreCase("R") && loserMove.equalsIgnoreCase("S")) {
            return "Rock breaks Scissors";
        } else if (winnerMove.equalsIgnoreCase("P") && loserMove.equalsIgnoreCase("R")) {
            return "Paper covers Rock";
        } else if (winnerMove.equalsIgnoreCase("S") && loserMove.equalsIgnoreCase("P")) {
            return "Scissors cuts Paper";
        }
        return "";
    }
}
