package matrix;

import java.math.BigDecimal;

// TODO: 23.07.2021
public class BigDecimalMatrix implements Matrix<BigDecimal, BigDecimalMatrix>{
    @Override
    public int getXSize() {
        return 0;
    }

    @Override
    public int getYSize() {
        return 0;
    }

    @Override
    public BigDecimal get(int x, int y) {
        return null;
    }

    @Override
    public BigDecimalMatrix multiply(BigDecimalMatrix matrixB) {
        return null;
    }

    @Override
    public BigDecimalMatrix exponentiation(int n) {
        return null;
    }

    @Override
    public BigDecimalMatrix add(BigDecimalMatrix matrixB) {
        return null;
    }

    @Override
    public BigDecimalMatrix transpose() {
        return null;
    }
}
