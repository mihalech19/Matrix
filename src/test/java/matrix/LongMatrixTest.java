package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongMatrixTest {

    @Test
    void multiply() {
        LongMatrix m1 = new LongMatrix(new long[][]{{1,2,3}, {1,2,3}});
        LongMatrix m2 = new LongMatrix(new long[][]{{4}, {5}, {6}});
        LongMatrix m3 = new LongMatrix(new long[][]{{1,2,3}, {1,2,3}, {1,2,3}});
        LongMatrix result1 = new LongMatrix(new long[][]{{32}, {32}});
        LongMatrix result2 = new LongMatrix(new long[][]{{6,12,18}, {6,12,18}, {6,12,18}});


        System.out.println(result2);
        assertEquals(result1, m1.multiply(m2));
        assertEquals(result2, m3.multiply(m3));
        assertThrows(IllegalArgumentException.class, ()->m1.multiply(m1));
    }

    @Test
    void get() {
        LongMatrix m1 = new LongMatrix(new long[][]{{1,2,3}, {1,2,3}});
        assertEquals(3, m1.get(1,2));
        assertThrows(IllegalArgumentException.class, ()->m1.get(2,2));
        assertThrows(IllegalArgumentException.class, ()->m1.get(0,3));
    }
}