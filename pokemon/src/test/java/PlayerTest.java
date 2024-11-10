import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pokemon.Player;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Ash");
        player.spawnPlayer();
    }

    @Test
    void testInitialPosition() {
        assertEquals(0, player.getPositionX());
        assertEquals(0, player.getPositionY());
    }

    @Test
    void testCatchPokemon() {
        assertEquals(1, player.getCatchedPokemons());
        player.moveTo('N'); // Move north, should catch a Pokémon
        assertEquals(2, player.getCatchedPokemons());
    }

    @Test
    void testMoveToDifferentDirections() {
        player.moveTo('E');
        assertEquals(1, player.getPositionX());
        assertEquals(0, player.getPositionY());

        player.moveTo('S');
        assertEquals(1, player.getPositionX());
        assertEquals(-1, player.getPositionY());

        player.moveTo('O');
        assertEquals(0, player.getPositionX());
        assertEquals(-1, player.getPositionY());
    }

    @Test
    void testInvalidDirectionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            player.moveTo('X'); // Invalid direction
        });
    }

    @Test
    void testMultipleCatchPokemons() {
        for (int i = 0; i < 1000; i++) {
            player.moveTo('N');
            player.moveTo('E');
            player.moveTo('S');
            player.moveTo('O');
        }
        assertEquals(4, player.getCatchedPokemons());
    }

    @Test
    void testPositionSaving() {
        player.moveTo('S');
        player.moveTo('O');
        player.moveTo('N');
        player.moveTo('N');
        player.moveTo('E');
        player.moveTo('E');
        assertTrue(player.getMap().containsKey("0,0")); // Check if position is saved
        assertTrue(player.getMap().containsKey("0,1")); // Check if position is saved
        assertTrue(player.getMap().containsKey("0,-1")); // Check if position is saved
        assertTrue(player.getMap().containsKey("1,1")); // Check if position is saved
        assertTrue(player.getMap().containsKey("-1,1")); // Check if position is saved
        assertTrue(player.getMap().containsKey("-1,-1")); // Check if position is saved
        assertTrue(player.getMap().containsKey("-1,0")); // Check if position is saved
        assertTrue(player.getMap().containsKey("1,1")); // Check if position is saved
    }
}
