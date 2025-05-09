//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose of the textui class is to visually map the game in text so that
// the game runs properly visual wise.
package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TextUI {

    public void play(Dungeon d) {
        while (!d.isFinished()) {
            print(d);
            Action a = ask(d);
            a.execute();
        }
    }

    /** shows what room of the dungeon we in */
    private void print(Dungeon d) {
        Chamber r = d.getCurrentChamber();
        StringBuilder s = new StringBuilder();
        s.append("You are in a chamber with ")
                .append(r.getDoors().size()).append(" doors\n");
        s.append("There are ")
                .append(r.getItems().size()).append(" items in the chamber\n");

/** prints who the mosnter is and what their stats are*/
        int doorIdx = 1;
        for (Door door : r.getDoors()) {
            if (door.hasEnemy()) {
                Monster m = door.getEnemy();
                s.append("Door ").append(doorIdx)
                        .append(" guarded by ").append(m.getName())
                        .append(" [HP=").append(m.getHealth())
                        .append(", STR=").append(m.getStrength())
                        .append(", CRF=").append(m.getCraft())
                        .append("]\n");
            }
            doorIdx++;
        }


        System.out.println(s.toString());
    }

    /** Asks the user for an action. */
    private Action ask(Dungeon d) {
        StringBuilder s = new StringBuilder();
        s.append("Here are your options:\n");
        List<Action> actions = d.getActions();
        for (int i = 0; i < actions.size(); i++) {
            Action a = actions.get(i);
            s.append("\t").append(i).append(": ")
                    .append(a.toString()).append("\n");
        }
        System.out.println(s.toString());

        //ask for action
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            int command = Integer.parseInt(reader.readLine());
            return actions.get(command);
        } catch (IOException e) {
            return new PrintError(d, e);
        }
    }
}


