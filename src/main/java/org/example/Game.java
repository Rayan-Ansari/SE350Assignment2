//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement a game class to implement the game code was already given

package org.example;
public class Game {
    public static void main(String[] args) {
// initialize some chambers
        Chamber[] chambers = new Chamber[] {
                new Chamber(),
                new Chamber(new Axe()),
                new Chamber(new Shield()),
                new Chamber(),
                new Chamber()
        };
// connect the chambers with doors
        Door.connect(chambers[0], chambers[1]);
        Door.connect(chambers[1], chambers[2], new Monster("Goblin", 1, 0, 3));
        Door.connect(chambers[2], chambers[3], new Monster("Spider", 3, 0, 5));
        Door.connect(chambers[3], chambers[4]);
        Character player = new Wizard("Gandalf");
// initialize the dungeon with player, entry chamber, and goal chamber
        Dungeon d = new Dungeon(player, chambers[0], chambers[4]);
        TextUI ui = new TextUI();
        ui.play(d);
    }
}

