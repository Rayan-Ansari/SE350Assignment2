//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement an item class to dictate everything the character can have.
package org.example;
public abstract class Item {
    /** the immutable state */
    private final String name;
    private final int strengthBonus;
    private final int craftBonus;
    /** constructor is protected so the subclasses are inmstantiated  and the string is immutable */
    protected Item(String name, int strengthBonus, int craftBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.craftBonus = craftBonus;
    }
    /** accessors */
    public String getName()               { return name; }
    public int getStrengthBonus()         { return strengthBonus; }
    public int getCraftBonus()            { return craftBonus; }

    /** we display it polymorphically the  ui uses the inital string everuwhere. */
    @Override public String toString() {
        String stats = "";
        if (strengthBonus != 0) stats = "+" + strengthBonus + " STR";
        if (craftBonus    != 0) stats = "+" + craftBonus  + " CRF";
        return name + (stats.isEmpty() ? "" : " (" + stats + ")");
    }
}
