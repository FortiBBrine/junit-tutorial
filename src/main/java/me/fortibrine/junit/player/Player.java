package me.fortibrine.junit.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {

    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Player player)) return false;

        return name.equals(player.name);
    }
}
