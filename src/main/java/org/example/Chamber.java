//------------------------------------------------------
// Assignment (2)
// Written by: (Rayan Ansari 2174698)
// For SES350 Section (631) – Spring 2025
//Purpose:  the purpose is to a chamber class that ties the items that are on the floor and the doors we can use
package org.example;
import java.util.*;

public final class Chamber {
    private final List<Item> items   = new ArrayList<>();/**the items that are needed to be picked up*/
    private final Set<Door>  doors   = new HashSet<>();/** the doors within the dungeon that the chartacter can go through*/

    public Chamber(Item... initial) {
        for (Item i : initial) items.add(i);
    }
    /** adds the door*/
    void addDoor(Door d)   { doors.add(d); }

    public List<Item> getItems()  { return items; }
    public Set<Door>  getDoors()  { return doors; }

    /** this  either removes or returns the item */
    public Item takeItem(Item i) {
        if (items.remove(i)) return i;
        throw new IllegalArgumentException("Item isnt here");
    }
}

