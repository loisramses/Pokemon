package pokemon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Init Player
        Player player = new Player("Ash");
        player.spawnPlayer();

        // Read Path
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();
        
        for (char chardinalDirection : path.toCharArray()) {
            player.moveTo(chardinalDirection);
        }
        System.out.println(player.getCatchedPokemons());
    }
}