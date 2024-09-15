package me.fortibrine.junit.test.player.assertj;

import me.fortibrine.junit.player.Player;
import me.fortibrine.junit.player.PlayerStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerStatisticsTest {

    private Player playerPatrickUnderThirty;
    private PlayerStatistics statisticsOfPatrickUnderThirty;

    @BeforeEach
    public void setup() {
        playerPatrickUnderThirty = new Player("Patrick", 27);
        statisticsOfPatrickUnderThirty = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);
    }

    @Test
    public void playerNameEqual() {

        System.out.println("Test 1");

        Player player2 = new Player("Patrick", 25);

        assertThat(player2).isEqualTo(playerPatrickUnderThirty);
    }

    @Test
    public void playerNameNotEqual() {
        System.out.println("Test 2");
        Player player2 = new Player("Kalvin", 25);

        assertThat(playerPatrickUnderThirty).isNotEqualTo(player2);
    }

    @Test
    public void youngerPlayerSame() {
        System.out.println("Test 3");
        Player player2 = new Player("Patrick", 25);

        // checks in memory
        assertThat(player2).isSameAs(PlayerStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2));
    }

    @Test
    public void underThirtyTrue() {
        System.out.println("Test 4");
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);

        assertThat(statistics.underThirty()).isTrue();
    }

    @Test
    public void underThirtyFalse() {
        System.out.println("Test 5");

        Player player1 = new Player("Patrick", 37);
        PlayerStatistics statistics = new PlayerStatistics(player1, 3, 3);

        assertThat(statistics.underThirty()).isFalse();
    }

    @Test
    public void csvReportNull() {
        System.out.println("Test 6");

        Player player1 = new Player("Patrick", 27);
        PlayerStatistics statistics = new PlayerStatistics(player1, 0, 0);

        assertThat(statistics.createCsvRecord()).isNull();
    }

    @Test
    public void csvReportNotNull() {
        System.out.println("Test 7");

        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);

        assertThat(statistics.createCsvRecord()).isNotNull();
    }

    @Test
    public void getCsvStatsRecord() {
        System.out.println("Test 8");

        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 4, 8);
        Double[] expectedArray = {2d, 0.5};

        assertThat(expectedArray).isEqualTo(statistics.createCsvRecord());
    }

}
