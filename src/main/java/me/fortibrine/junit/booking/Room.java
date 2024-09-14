package me.fortibrine.junit.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Room {

    private final String name;
    private final boolean available;

}
