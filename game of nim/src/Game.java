import java.util.Scanner;
public class Game {
    /**
     *
     * @param p1 First player
     * @param p2 Second Player
     * @param pile Pile of marbles
     * @param turn Player who has to play first
     */
    public static void runOneGame(Player p1, Player p2, Pile pile, Player turn) {
        int marble;
        while (pile.getCurrentNumberOfMarbles() > 1) {
            // For Smart / Novice Computer....
            if(turn==p1){marble = p1.play(pile);}
            // For Humans....
            else{marble = p2.play(pile);}

            if(pile.takeMarbles(marble)){
                if(turn.getName().equals(p1.name)){ p1.setScore(pile.getCurrentNumberOfMarbles()-marble); }
                else{ p2.setScore(pile.getCurrentNumberOfMarbles()-marble); }
            }
            else{ System.out.println("Invalid Input: Try again!"); continue; }
            if(turn == p1){turn = p2;}else{turn=p1;}
            System.out.println(gameStatus(p1, p2, pile, turn));
        }

        if(turn.getName().equals(p1.name)){ p1.setScore(pile.getCurrentNumberOfMarbles()-1); }
        else{ p2.setScore(pile.getCurrentNumberOfMarbles()-1); }

        System.out.println("*** " + (turn==p1?p2:p1).getName() + " is the winner! ***");
        p1.setNumberOfPlays(p1.getNumberOfPlays()+1);
        p2.setNumberOfPlays(p2.getNumberOfPlays()+1);
        if (turn==p2) p1.setScore(p1.getScore()+1);
        else p2.setScore(p2.getScore()+1);
    }
    /**
     *
     * @param p1 First player
     * @param p2 Second Player
     * @param pile Pile of marbles
     * @param turn Player who has to play first
     */
    public static String gameStatus(Player p1, Player p2, Pile pile, Player turn) {
        return "This is a game between " + p1.getName() + " and " + p2.getName() +
                ".\nInitial number of piles: " + pile.getInitialNumberOfMarbles() +
                ".\nCurrent number of piles: " + pile.getCurrentNumberOfMarbles() +
                ".\n" + pile.showPile() + "\nIt is " + turn.getName() + "'s turn to play.";
    }
    public static void main(String[] args) {
        
// Print out a welcome message
        System.out.println("Welcome to the game of Nim!");
        System.out.println("---------------------------");
        Player p1,p2;
        boolean smart = false;
        Scanner console = new Scanner(System.in);
        do {
            System.out.println("H)Human-Human C)Computer-Human");
            if (console.nextLine().toUpperCase().equals("H")) {
                do {
                    System.out.println("Name of Player 1?");
                    String name = console.nextLine();
                    System.out.println("Name of Player 2?");
                    String name2 = console.nextLine();
                    System.out.println("Age of Player 1?");
                    int age = console.nextInt();
                    System.out.println("Age of Player 2?");
                    int age2 = console.nextInt();
                    p1 = new HumanPlayer(name, age);
                    p2 = new HumanPlayer(name2, age2);
                    // Create a pile of marbles, randomly between 10 to 100 marbles.
                    Pile pile = new Pile(Utilities.randomInteger(10, 100));
                    // Randomly select the player who should play first.
                    Player turn = Utilities.randomInteger(1, 2) == 1 ? p1 : p2;
                    System.out.println(gameStatus(p1, p2, pile, turn));
                    runOneGame(p1, p2, pile, turn);
                    System.out.println(p1);
                    System.out.println(p2);
                    System.out.println("P)lay again Q)uit");
                    console.nextLine();
                }while (console.nextLine().toUpperCase().equals("P"));
            } else {
                System.out.println("S)mart-Computer N)ovice-Computer");
                // The first player is the Computer.
                if (console.nextLine().toUpperCase().equals("N")) { p1 = new Computerplayer("DumBot", smart);}
                else{smart=true; p1 = new Computerplayer("SmartBot3000", smart); }
                //boolean smart = Utilities.randomInteger(0, 1) != 0;
                // The second player is human
                System.out.println("Name of Player 2?");
                String name = console.nextLine();
                System.out.println("Age of Player 2?");
                int age = console.nextInt();
                p2 = new HumanPlayer(name, age);
                do {
                    // Create a pile of marbles, randomly between 10 to 100 marbles.
                    Pile pile = new Pile(Utilities.randomInteger(10, 100));
                    // Randomly select the player who should play first.
                    Player turn = Utilities.randomInteger(1, 2) == 1 ? p1 : p2;
                    // Print out game information
                    System.out.println(gameStatus(p1, p2, pile, turn));
                    // Start playing a game
                    runOneGame(p1, p2, pile, turn);
                    System.out.println(p1);
                    System.out.println(p2);
                    System.out.println("P)lay again Q)uit");
                    console.nextLine();
                } while (console.nextLine().toUpperCase().equals("P"));
            }
            System.out.println("N)ew play set E)xit");
        } while (console.nextLine().toUpperCase().equals("N"));
        System.out.println("Thx for playing! ");
    }
}