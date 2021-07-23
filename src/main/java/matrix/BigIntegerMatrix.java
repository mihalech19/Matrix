package matrix;

import java.math.BigInteger;

// TODO: 23.07.2021  
public class BigIntegerMatrix implements Matrix<BigInteger, BigIntegerMatrix>{
    @Override
    public int getXSize() {
        return 0;
    }

    @Override
    public int getYSize() {
        return 0;
    }

    @Override
    public BigInteger get(int x, int y) {
        return null;
    }

    @Override
    public BigIntegerMatrix multiply(BigIntegerMatrix matrixB) {
        return null;
    }

    @Override
    public BigIntegerMatrix exponentiation(int n) {
        return null;
    }

    @Override
    public BigIntegerMatrix add(BigIntegerMatrix matrixB) {
        return null;
    }

    @Override
    public BigIntegerMatrix transpose() {
        return null;
    }
}
