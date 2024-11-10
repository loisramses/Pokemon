package pokemon;

import java.util.HashMap;

public class Player {
    private String name;
    private Integer catchedPokemons;
    private HashMap<String, Boolean> map;
    private long positionX;
    private long positionY;

    public Player(String name) {
        this.name = name;
        this.catchedPokemons = 0;
        this.map = new HashMap<>();
    }

    public void spawnPlayer() {
        this.moveTo(0, 0);
    }

    private void moveTo(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.catchPokemon();
        this.savePosition();
    }

    public void moveTo(char chardinalDirection) {
        switch (chardinalDirection) {
            case 'N':
                positionY++;
                break;
            case 'S':
                positionY--;
                break;
            case 'E':
                positionX++;
                break;
            case 'O':
                positionX--;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
        if (this.checkHouse())
            this.catchPokemon();
        this.savePosition();
    }

    // Saves position to map
    private void savePosition() {
        this.map.put(this.positionX + "," + this.positionY, true);
    }

    private void catchPokemon() {
        this.catchedPokemons++;
    }

    // Check if the house has been visited
    private boolean checkHouse() {
        return this.map.get(positionX + "," + positionY) == null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCatchedPokemons() {
        return catchedPokemons;
    }

    public void setCatchedPokemons(Integer catchedPokemons) {
        this.catchedPokemons = catchedPokemons;
    }

    public long getPositionX() {
        return positionX;
    }

    public void setPositionX(long position_x) {
        this.positionX = position_x;
    }

    public long getPositionY() {
        return positionY;
    }

    public void setPositionY(long position_y) {
        this.positionY = position_y;
    }

    public HashMap<String, Boolean> getMap() {
        return map;
    }
}