package lessons.lesson2.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

    private int[] testArray;

    @BeforeEach
    void setUp() {
        testArray = new int[]{0, 3, 6, 9, 12, 15, 18, 21};
    }

    @Test
    void change0And1Test() {
        Assertions.assertArrayEquals(new int[]{1, 0, 1, 0, 1}, ArrayUtils.change0And1(new int[]{0, 1, 0, 1, 0}));
    }

    @Test
    void makeArray() {
        Assertions.assertArrayEquals(testArray, ArrayUtils.makeArray());
    }

    @Test
    void changeLess6() {
        Assertions.assertArrayEquals(new int[]{0, 6, 6, 9, 12, 15, 18, 21}, ArrayUtils.changeLess6(testArray));
    }

    @Test
    void fillDiagonals1() {
        Assertions.assertArrayEquals(new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 1}}, ArrayUtils.fillDiagonals1(new int[3][3]));
    }

    @Test
    void findMinAndMax() {
        Assertions.assertArrayEquals(new int[]{0, 21}, ArrayUtils.findMinAndMax(testArray));
    }

    @Test
    void checkBalance() {
        Assertions.assertFalse(ArrayUtils.checkBalance(testArray));
    }

    @Test
    void moveArrayElements() {
        Assertions.assertArrayEquals(new int[]{18, 21, 0, 3, 6, 9, 12, 15}, ArrayUtils.moveArrayElements(testArray, 2));
    }
}