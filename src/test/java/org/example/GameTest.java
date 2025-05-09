//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose of the gametest class is to test the game and if it behaves properly in both
// happy and unhappy scenarios

package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
/**tests to see whether an item has been pciked up*/
    @Test void pickItemTransfersToInventory() {
        Chamber c = new Chamber(new Axe());
        Character p = new Warrior("Llama");
        Dungeon d = new Dungeon(p, c, c);


        Action pick = d.getActions().stream()
                .filter(a -> a instanceof Pick)
                .findFirst()
                .orElseThrow();
        pick.execute();

        assertEquals(1, p.getInventory().size());
        assertTrue(c.getItems().isEmpty());
    }
/** unhappy test to test whether theres a monster infront of the door.*/
    @Test void EnemyIsStillAlive() {
        Chamber a = new Chamber();
        Chamber b = new Chamber();
        Door.connect(a, b, new Monster("Troll", 2, 0, 4));
        Character p = new Warrior("Llama");
        Dungeon d = new Dungeon(p, a, b);

        Action move = d.getActions().stream()
                .filter(Move.class::isInstance)
                .findFirst()
                .orElse(null);
        assertNull(move, "can't move cause monster is still alive");
    }
/** happy test to showcase the user has defeated the monster*/
    @Test void fightDefeatsMonster() {
        Chamber a = new Chamber();
        Chamber b = new Chamber();
        Door.connect(a, b, new Monster("Baby-faced", 0, 1, 1));
        Character p = new Wizard("Mike");
        Dungeon d = new Dungeon(p, a, b);

        Fight fight = (Fight) d.getActions().get(0);
        fight.execute();

        Door door = a.getDoors().iterator().next();
        assertFalse(door.hasEnemy());
        boolean moveExists = d.getActions().stream()
                .anyMatch(Move.class::isInstance);
        assertTrue(moveExists);
    }
}
