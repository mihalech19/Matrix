package matrix;

import java.util.Arrays;
import java.util.Objects;

public class LongMatrix {
    private final long[][] matrix;
    private final int xDimension;
    private final int yDimension;

    public LongMatrix(long[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException();
        this.yDimension = matrix.length;
        this.xDimension = matrix[0].length;
        this.matrix = matrix;
    }

    public int getXSize() {
        return xDimension;
    }

    public int getYSize() {
        return yDimension;
    }

    public long get(int row, int col) {
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
