import java.util.Arrays;

class Matrix {

    private int[][] matrix;

    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");
        matrix = new int[rows.length][rows[0].length()];

        for (int i = 0; i < rows.length; i++) {
            int[] columnNumbers = Arrays.stream(rows[i].split(" ")).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();

            matrix[i] = columnNumbers;
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int columnLength = matrix.length;
        int[] column = new int[columnLength];

        for (int i = 0; i < columnLength; i++) {
            column[i] = matrix[i][columnNumber - 1];
        }

        return column;
    }
}
