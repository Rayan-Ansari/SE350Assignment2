//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement an monster class makes sure the character has an enemy to fight on certain doorways
package org.example;
public final class Monster extends Character {
    public Monster(String name, int strength, int craft, int health) {
        super(name, strength, craft, health);
        if ((strength != 0) && (craft != 0))
            throw new IllegalArgumentException("Monster can use strength or craft not both");
    }

    /**
     * if it's true the monster uses strength if it's false the monster uses craft
     */
    public boolean usesStrength() {
        return craft == 0;
    }

    @Override
    public void addItem(Item i) {
    }
    /**
     * monsters don’t pick items
     */
    @Override
    public void equip(Item i) {
    }

}

