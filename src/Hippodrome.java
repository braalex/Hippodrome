import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List horses;
    static Hippodrome game;

    public Hippodrome(List horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){
        for(Horse horse : game.getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for(Horse horse : game.getHorses()) {
            horse.print();
        }
        for(int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for(int i = 0; i < 60; i++) {
            move();
            print();
            Thread.sleep(400);
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double dist = 0;
        for(Horse horse : getHorses()) {
            if(horse.getDistance() > dist) {
                dist = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!", getWinner().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList());
        game.getHorses().add(new Horse("\uD83D\uDC0E", 3, 0));
        game.getHorses().add(new Horse("\ud83d\udc22", 3, 0));
        game.getHorses().add(new Horse("\ud83d\udc29", 3, 0));
        game.run();
        game.printWinner();
    }
}