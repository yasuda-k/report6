package jp.ac.uryukyu.ie.e165712;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void judge() {

        int[] pears = {2, 0, 0, 1, 0}; //フルハウス
        Player player1 = new Player(pears, "player1");
        player1.Judge(pears, player1);
        assertEquals(4, player1.getPower());
    }
}