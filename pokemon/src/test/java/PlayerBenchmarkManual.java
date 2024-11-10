import pokemon.Player;

public class PlayerBenchmarkManual {
    
    public static void main(String[] args) {
        Player player = new Player("Ash");
        
        // Test moves to North
        benchmarkMoveToNorth(player, 1000000); // 1Million moviment to North
        
        // Test moves to East
        benchmarkMoveToEast(player, 1000000); // 1Million moviment to East
        
        // Teste de múltiplos movimentos
        benchmarkMultipleMoves(player, 1000000); // 1Million moviment (N, E, S, O)
    }

    private static void benchmarkMoveToNorth(Player player, int count) {
        long startTime = System.nanoTime();
        
        for (int i = 0; i < count; i++) {
            player.moveTo('N');
        }
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        // Convert to ms
        double durationInMs = duration / 1_000_000.0;
        System.out.printf("Tempo para mover para o Norte (%d movimentos): %.6f ms\n", count, durationInMs);
    }

    private static void benchmarkMoveToEast(Player player, int count) {
        long startTime = System.nanoTime();
        
        for (int i = 0; i < count; i++) {
            player.moveTo('E');
        }
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        // Convert to ms
        double durationInMs = duration / 1_000_000.0;
        System.out.printf("Tempo para mover para o Leste (%d movimentos): %.6f ms\n", count, durationInMs);
    }

    private static void benchmarkMultipleMoves(Player player, int count) {
        long startTime = System.nanoTime();
        
        for (int i = 0; i < count; i++) {
            player.moveTo('N');
            player.moveTo('E');
            player.moveTo('S');
            player.moveTo('O');
        }
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        // Convert to ms
        double durationInMs = duration / 1_000_000.0;
        System.out.printf("Tempo para múltiplos movimentos (%d movimentos): %.6f ms\n", count * 4, durationInMs);
    }
}
