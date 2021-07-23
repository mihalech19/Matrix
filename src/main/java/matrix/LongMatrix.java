package matrix;

import java.util.Arrays;
import java.util.Objects;

public class LongMatrix implements Matrix<Long, LongMatrix> {
    private final long[][] matrix;
    private final int xDimension;
    private final int yDimension;

    private boolean isMatrix(long[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        for(int i =0; i < matrix.length; i++){
            if (matrix[0].length != matrix[i].length)
                return false;
        }
        return true;

    }
    public LongMatrix(long[][] matrix) {
        if (!isMatrix(matrix))
            throw new IllegalArgumentException();

        this.yDimension = matrix.length;
        this.xDimension = matrix[0].length;
        this.matrix = matrix;
    }

    public static LongMatrix getIdentityMatrix(int size) {
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            result[i][i] = 1L;
        }

        return new LongMatrix(result);

    }

    public int getXSize() {
        return xDimension;
    }

    public int getYSize() {
        return yDimension;
    }

    public Long get(int row, int col) {
        if (col > xDimension - 1 || row > yDimension - 1)
            throw new IllegalArgumentException("The coordinates do not match the dimensionality of the matrix");

        return matrix[row][col];
    }

    public LongMatrix multiply(LongMatrix B) {

        if (xDimension != B.getYSize())
            throw new IllegalArgumentException("The number of columns of the first matrix must be equal to the number of rows of the second matrix.");

        long[][] result = new long[yDimension][B.getXSize()];

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < xDimension; k++) {
                    result[i][j] += matrix[i][k] * B.get(k, j);
                }

            }
        }
        return new LongMatrix(result);
    }

    public LongMatrix exponentiation(int n) {
        if (xDimension != yDimension)
            throw new ArithmeticException("The number of matrix rows does not equal the number of columns. Exponentiation is not possible.");

        LongMatrix result = getIdentityMatrix(xDimension);
        LongMatrix tmp = this;

        while (n != 0) {

            if ((n & 1) == 1) {
                result = result.multiply(tmp);

            }
            n /= 2;
            if (n == 0) break;
            tmp = tmp.multiply(tmp);
        }

        return result;
    }

    public LongMatrix add(LongMatrix B) {
        if (xDimension != B.getXSize() || yDimension != B.getYSize())
            throw new ArithmeticException("Matrices of different sizes. Addition is not possible");
        long[][] result = new long[yDimension][xDimension];
        for (int i = 0; i < yDimension; i++) {
            for (int j = 0; j < xDimension; j++) {
                result[i][j] = matrix[i][j] + B.get(i, j);
            }
        }
        return new LongMatrix(result);
    }

    public LongMatrix transpose() {
        long[][] result = new long[xDimension][yDimension];
        for(int i = 0; i < yDimension; i++){
            for(int j = 0; j < xDimension; j++){
                result[j][i] = matrix[i][j];
            }
        }
        return new LongMatrix(result);
    }


    public LongMatrix findDeterminant() {
        // TODO: 22.07.2021
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongMatrix that = (LongMatrix) o;
        return xDimension == that.xDimension && yDimension == that.yDimension && Arrays.deepEquals(matrix, that.matrix);
    }


    @Override
    public String toString() {
        return "LongMatrix{" +
                "  xDimension=" + xDimension +
                ", yDimension=" + yDimension +
                "\nmatrix=\n"
                + Arrays.deepToString(matrix).replace("],", "]\n") +
                '}';
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(xDimension, yDimension);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }
}
