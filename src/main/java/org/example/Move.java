//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement a move class in cases which the character
// can move through door or a different way out, basically so signify a movement action
package org.example;
/** stores tje diunmgheons and door references so we can use later*/
public final class Move implements Action {
    private final Dungeon d;
    private final Door door;
    public Move(Dungeon d, Door door) { this.d = d; this.door = door; }
/** makes sure the door doesnt have an enemy and gives corresponding messages for each scenario*/

@Override public void execute() {
        if (door.hasEnemy()) {
            System.out.println("Door still has an enemy");
            return;
        }
        d.move(door);
        System.out.println("Moving to next chamber\n");
    }
    @Override public String toString() {
        return "Go through door onto the next chamber";
    }
}
