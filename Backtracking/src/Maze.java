import jdk.swing.interop.SwingInterOpUtils;

public class Maze {

    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 0},
                        {0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                };
        int actual[][] = new int[mat.length][mat.length];
        int solucion[][] = new int[mat.length][mat.length];
        boolean[][] visitado = new boolean[mat.length][mat.length];
        for (int i = 0; i < solucion.length; i++) {
            for (int j = 0; j < solucion.length; j++) {
                solucion[i][j] = 0;
                visitado[i][j] = false;
            }
        }
        findPathTo(mat, actual, solucion, visitado, 0, 0, 0, 5, 7);
        for (int i = 0; i < solucion.length; i++) {
            for (int j = 0; j < solucion[0].length; j++) {
                if (solucion[i][j] == 1)
                    System.out.print(" * ");
                else
                    System.out.print(" 0 ");
            }
            System.out.println();
        }
    }

    public static void findPathTo(int[][] mat, int[][] actual, int[][] solucion, boolean[][] visitado, int len, int i, int j, int x, int y) {

        if ((x == i && y == j) && (get1sLen(solucion) < get1sLen(actual) || get1sLen(solucion) == 0)) {
            System.out.println(get1sLen(actual));
            for (int k = 0; k < actual.length; k++) {
                for (int l = 0; l < actual[0].length; l++) {
                    solucion[k][l] = actual[k][l];
                }
            }
        } else {
            visitado[i][j] = true;
            actual[i][j] = 1;
            len++;
            //Arriba
            if (isSafe(mat, visitado, i, j + 1)) {
                findPathTo(mat, actual, solucion, visitado, len, i, j + 1, x, y);
            }
            //Abajo
            if (isSafe(mat, visitado, i, j - 1)) {
                findPathTo(mat, actual, solucion, visitado, len, i, j - 1, x, y);
            }
            //Derecha
            if (isSafe(mat, visitado, i + 1, j)) {
                findPathTo(mat, actual, solucion, visitado, len, i + 1, j, x, y);
            }
            //Izquierda
            if (isSafe(mat, visitado, i - 1, j)) {
                findPathTo(mat, actual, solucion, visitado, len, i - 1, j, x, y);
            }
            len--;
            visitado[i][j] = false;
            actual[i][j] = 0;
        }
    }

    private static boolean isSafe(int[][] mat, boolean[][] visitado, int x, int y) {
        return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) && mat[x][y] == 1 && !visitado[x][y];
    }

    private static int get1sLen(int[][] v) {
        int s = 0;
        for (int k = 0; k < v.length; k++) {
            for (int l = 0; l < v[0].length; l++) {
                if (v[k][l] == 1) {
                    s++;
                }
            }
        }
        return s;
    }

    private static class Boolean {
        private boolean valor;

        public Boolean() {
            valor = false;
        }

        public void setValor(boolean valor) {
            this.valor = valor;
        }

        public boolean getValor() {
            return valor;
        }
    }
}
