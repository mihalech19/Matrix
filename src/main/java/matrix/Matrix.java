package matrix;

public interface Matrix<T ,S extends Matrix<T,S>>{
    int getXSize();
    int getYSize();
    T get(int x, int y);
    S multiply(S matrixB);
    S exponentiation(int n);
    S add(S matrixB);
    S transpose();
}
