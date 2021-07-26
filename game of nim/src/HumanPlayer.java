import java.util.Scanner;

public class HumanPlayer extends Player{
    Scanner console = new Scanner(System.in);
    int age;
    @Override
    public int play(Pile pile) {
        int x = console.nextInt(); return x;
    }
    public HumanPlayer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player Name: " + this.name +
                ", Aged: " + this.age +
                ", Number of Plays: " + this.getNumberOfPlays() +
                ", Score: " + this.getScore();
    }


    public void setName(String name) { this.name = name; }
}
