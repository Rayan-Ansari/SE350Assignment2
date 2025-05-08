//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement an fight class to simulate a fight between the user
// and the monster in front of the door
package org.example;
/** handles the combat */

public final class Fight implements Action {
    private final Dungeon dungeon;
    private final Door door;
    public Fight(Dungeon d, Door door)
    { this.dungeon = d; /** @param d sasves the satet of the game*/
        this.door = door;/** @param door the door that the monster is in front of*/

    }
/** this runs until the player or mosnter die*/
    @Override public void execute() {
        Monster m = door.getEnemy();
        Character p = dungeon.getPlayer();

        boolean useStr = m.usesStrength();
        System.out.println("\n Let's Fight! " + m.getName() + " (" +
                (useStr ? "STR" : "CRF") + ")");
        /** keeps going until someone's health is at zero*/
        while (p.isAlive() && m.isAlive()) {
            int pRoll = p.rollFightValue(useStr);
            int mRoll = m.rollFightValue(useStr);
            int diff  = Math.abs(pRoll - mRoll);
            /** if there is a tie break we give the player a better chance*/
            if (pRoll >= mRoll) {
                m.loseHealth(diff);
                System.out.println("you damaged him for " + diff +
                        ", monster health: " + m.getHealth());
            } else {
                p.loseHealth(diff);
                System.out.println("they hit you for " + diff +
                        ", your health: " + p.getHealth());
            }
        }
        /** print if and when player or monster dies*/
        if (!p.isAlive()) {
            System.out.println("wasted Game over.");
            dungeon.killPlayer();
        } else {
            System.out.println("u killed the monster.");
            door.defeatEnemy();
        }
    }
/** just an entrance name to show who the player is fighting*/
    @Override public String toString() {
        Monster m = door.getEnemy();
        return "fight the r " + m.getName();
    }
}
