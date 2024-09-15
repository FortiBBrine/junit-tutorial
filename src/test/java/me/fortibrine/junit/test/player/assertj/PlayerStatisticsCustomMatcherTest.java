package me.fortibrine.junit.test.player.assertj;

import me.fortibrine.junit.player.Player;
import org.junit.jupiter.api.Test;

import static me.fortibrine.junit.test.player.assertj.PlayerAssert.assertThat;

public class PlayerStatisticsCustomMatcherTest {

    @Test
    public void playerConstructorAssignsName() {
        Player player = new Player("Stuart", 30);
//        assertThat(player.getName()).isEqualTo("Stuart");
        assertThat(player).hasName("Stuart");
    }

}
