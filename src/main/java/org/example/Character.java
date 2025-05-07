//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to implement a character class to initiliaze the character in the game
package org.example;
import java.util.*;

/** initialize the character stats*/
public abstract class Character {
    protected final String name;
    protected int strength;
    protected int craft;
    protected int health;

    protected final List<Item> inventory = new ArrayList<>();
    /** we use a set so that the character has at most 2 different items*/
    protected final Set<Item> hands      = new HashSet<>();   // ≤2
    /** base stats*/
    protected Character(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
    }

    public String getName()         { return name; }
    public int getHealth()          { return health; }
    public void loseHealth(int h)   { health = Math.max(0, health - h); }
    public boolean isAlive()        { return health > 0; }
    public int getStrength()        { return strength; }
    public int getCraft()           { return craft; }

    /** manages the inventory */
    public void addItem(Item i)               { inventory.add(i); }
    public List<Item> getInventory()          { return inventory; }
    /** equips an item*/
    public void equip(Item i) {
        if (!inventory.contains(i)) throw new IllegalArgumentException("item isn't carried carried");
        if (hands.size() == 2) throw new IllegalStateException("both of the hands are full");
        hands.add(i);
    }
    /**unequips an item*/
    public void unequip(Item i) { hands.remove(i); }
    public Set<Item> getHands() { return hands; }

    /**we have extra sterntgh and extracraft so that the stat bonuses dont double*/
    protected int extraStrength() {
        return hands.stream().mapToInt(Item::getStrengthBonus).sum();
    }
    protected int extraCraft() {
        return hands.stream().mapToInt(Item::getCraftBonus).sum();
    }

    /**calculates roll 1-6*/
    public int rollFightValue(boolean useStrength) {
        int base = useStrength ? strength + extraStrength()
                : craft    + extraCraft();
        return base + (int)(Math.random()*6)+1;
    }
}

