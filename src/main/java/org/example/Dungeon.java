//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement a dungeon class which is the base of the game
// and how all the pieces fit together
package org.example;
import java.util.*;
/** sets the player charcater, the initial chamber point and sets the given chamber as the way to win*/
public final class Dungeon {
    private final Character player;
    private final Chamber entry, goal;
    private Chamber current;
    private boolean playerAlive = true;

    public Dungeon(Character p, Chamber entry, Chamber goal) {
        this.player = p;
        this.entry  = entry;
        this.goal   = goal;
        this.current = entry;
    }

    public Character getPlayer()       { return player; }
    public Chamber getCurrentChamber() { return current; }
/** the game ios finished when the character reaches the end or dies*/
    public boolean isFinished() {
        return !playerAlive || current == goal;
    }
    void killPlayer() { playerAlive = false; }

    /** the actions of the player */
    public void move(Door d) {
        current = d.other(current);
    }


    public List<Action> getActions() {
        List<Action> list = new ArrayList<>();

        /** the options for how to fight a given monster guarding a door */
        current.getDoors().stream()
                .filter(Door::hasEnemy)
                .forEach(door -> list.add(new Fight(this, door)));

        /** the options to pick up something */
        for (Item i : current.getItems())
            list.add(new Pick(this, i));

        /** the options to move the charcater */
        current.getDoors().stream()
                .filter(door -> !door.hasEnemy())
                .forEach(door -> list.add(new Move(this, door)));

        return list;
    }
}

