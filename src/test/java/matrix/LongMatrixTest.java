package matrix;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class LongMatrixTest {

    @Test
    void multiply() {
        LongMatrix m1 = new LongMatrix(new long[][]{{1,2,3}, {1,2,3}});
        LongMatrix m2 = new LongMatrix(new long[][]{{4}, {5}, {6}});
        LongMatrix m3 = new LongMatrix(new long[][]{{1,2,3}, {1,2,3}, {1,2,3}});
        LongMatrix result1 = new LongMatrix(new long[][]{{32}, {32}});
        LongMatrix result2 = new LongMatrix(new long[][]{{6,12,18}, {6,12,18}, {6,12,18}});

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

    @Test
    void exponentiation() {
        LongMatrix m1 = new LongMatrix(new long[][]{{0,1}, {1,1}});
        LongMatrix result1 = new LongMatrix(new long[][]{{8,13}, {13,21}});
        LongMatrix result2 = new LongMatrix(new long[][]{{13,21}, {21,34}});
        LongMatrix result3 = new LongMatrix(new long[][]{{102334155,165580141}, {165580141,267914296}});
        assertEquals(result1, m1.exponentiation(7));
        assertEquals(result2, m1.exponentiation(8));
        assertEquals(result3, m1.exponentiation(41));
        assertThrows(ArithmeticException.class, ()-> new LongMatrix(new long[2][3]).exponentiation(3));
    }

    @Test
    void add() {

        LongMatrix m1 = new LongMatrix(new long[][]{{0,1}, {1,3}});
        LongMatrix m2 = new LongMatrix(new long[][]{{0,1,3}, {1,3,3}});
        LongMatrix result = new LongMatrix(new long[][]{{0,2}, {2,6}});
        assertEquals(result, m1.add(m1));
        assertThrows(ArithmeticException.class, ()-> m1.add(m1.add(m2)));

    }

    @Test
    void transpose() {
        LongMatrix m1 = new LongMatrix(new long[][]{{1,2,3}, {4,5,6}});
        LongMatrix result = new LongMatrix(new long[][]{{1,4}, {2,5}, {3,6}});
        assertEquals(result, m1.transpose());

    }
}