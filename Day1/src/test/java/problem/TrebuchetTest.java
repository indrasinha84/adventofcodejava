package problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem.Trebuchet;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TrebuchetTest {
    String filePath = "src/test/resources/input/input.XSCORE.txt";

    @Test
    void problem1() {
        var obj = new Trebuchet();
        assertEquals(53651, obj.problem1(filePath));
    }

    @Test
    void problem2() {
        var obj = new Trebuchet();
        assertEquals(53894, obj.problem2(filePath));
    }
}