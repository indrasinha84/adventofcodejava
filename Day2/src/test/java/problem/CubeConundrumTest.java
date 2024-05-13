package problem;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CubeConundrumTest {
    String filePath = "src/test/resources/input/input.XSCORE.txt";

    @Test
    void problem1() {
        var obj = new CubeConundrum();
        assertEquals(2810, obj.problem1(filePath));

    }

    @Test
    void problem2() {
        var obj = new CubeConundrum();
        assertEquals(69110, obj.problem2(filePath));
    }
}