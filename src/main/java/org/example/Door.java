//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement a door class that links all the rooms so
// that it can go through a dunegeon and go through multiple chambers
package org.example;
public final class Door {
    private final Chamber a, b;
    private Monster enemy;              /** turns to null if the door isn't guadred or the die*/
    /** we do this so we can traverse through the dungeon and multiple chambers*/
    private Door(Chamber a, Chamber b, Monster m) {
        this.a = a; this.b = b; this.enemy = m;
        a.addDoor(this);
        b.addDoor(this);
    }
/** this connects two chambers from one door onto the otherside*/
    public static void connect(Chamber c1, Chamber c2) {
        new Door(c1, c2, null);
    }
    public static void connect(Chamber c1, Chamber c2, Monster m) {
        new Door(c1, c2, m);
    }
    /** makes sure the other end of the door into anohter chamber is returned*/
    public Chamber other(Chamber current) {
        return current == a ? b : a;
    }

    public boolean hasEnemy()  { return enemy != null && enemy.isAlive(); }
    public Monster getEnemy()  { return enemy; }
    public void defeatEnemy()  { enemy = null; }
}

