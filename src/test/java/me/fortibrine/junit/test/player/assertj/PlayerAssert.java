package me.fortibrine.junit.test.player.assertj;

import me.fortibrine.junit.player.Player;
import org.assertj.core.api.AbstractAssert;

public class PlayerAssert extends AbstractAssert<PlayerAssert, Player> {

    protected PlayerAssert(Player player) {
        super(player, PlayerAssert.class);
    }

    public static PlayerAssert assertThat(Player player) {
        return new PlayerAssert(player);
    }

    public PlayerAssert hasName(String expectedName) {
        isNotNull();
        if (!actual.getName().equals(expectedName)) {
            failWithMessage("Expected name to be <%s> but was <%s>", expectedName, actual.getName());
        }

        return this;
    }

}
