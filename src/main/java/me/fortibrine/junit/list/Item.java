package me.fortibrine.junit.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Item implements Comparable<Item> {

    private final int size;
    private final String description;

    @Override
    public int compareTo(Item other) {
        return this.description.compareTo(other.description);
    }

}
