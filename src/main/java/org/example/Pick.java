//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement a pick class that extends an acion so that the character
// can use items from the chaber and pick it up
package org.example;

public final class Pick implements Action {
    private final Dungeon d;
    private final Item item;
    public Pick(Dungeon d, Item i) { this.d = d; this.item = i; }

    @Override public void execute() {
        Item i = d.getCurrentChamber().takeItem(item);/**picks up off florr*/
        d.getPlayer().addItem(i);/** puts it in character inventory*/
        System.out.println("Picked up " + i);
    }
    @Override public String toString() { return "Pick " + item; }
}
