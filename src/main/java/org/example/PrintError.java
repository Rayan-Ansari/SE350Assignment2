//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement a printerror class in case the user selects an option within the game
// that isn't an option
package org.example;

public final class PrintError implements Action {

    private final Dungeon dungeon;
    private final Exception cause;

    /** @param d gives us the state of the game
     *
     * @param e throws an exception
     *
     */
    public PrintError(Dungeon d, Exception e) {
        this.dungeon = d;
        this.cause   = e;
    }

    @Override public void execute() {
        int max = dungeon.getActions().size() - 1;
        System.out.println(" wrong try again, enter a number between 0 and "
                + max + " and press Enter.");
    }

    @Override public String toString() {
        return "wrong again cmon man try again";
    }
}

