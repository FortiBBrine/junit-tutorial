package me.fortibrine.junit.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PlayerStatistics {

    private Player player;
    private int games;
    private int goals;

    public double gamesPerGoal() {
        return (double) this.games / (double) this.goals;
    }

    public double goalsPerGame() {
        return (double) this.goals / (double) this.games;
    }

    public boolean underThirty() {
        return this.player.getAge() < 30;
    }

    public Double[] createCsvRecord() {
        if (this.games == 0) {
            return null;
        }

        return new Double[] {goalsPerGame(), gamesPerGoal()};
    }

    public static Player getYoungerPlayer(Player player1, Player player2) {
        return (player2.getAge() < player1.getAge()) ? player2 : player1;
    }

}
