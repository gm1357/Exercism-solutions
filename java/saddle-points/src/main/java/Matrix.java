import java.util.*;

class Matrix {
    private List<List<Integer>> matrix;

    Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        if (this.matrix.isEmpty() || this.matrix.get(0).isEmpty()) {
            return saddlePoints;
        }

        var numRows = this.matrix.size();
        var numCols = this.matrix.get(0).size();
        List<List<Integer>> candidates = new ArrayList<>();

        for (int indexRow = 0; indexRow < numRows; indexRow++) {
            List<Integer> row = this.matrix.get(indexRow);

            candidates.add(
                    this.getColumnCandidates(
                        numCols,
                        new ArrayList<>(Collections.singleton(0)),
                        row
                    )
            );

            int finalIndexRow = indexRow;
            candidates.get(indexRow).forEach(candidate -> {
                MatrixCoordinate saddlePoint = getRowSaddlePoint(numRows, row, finalIndexRow, candidate);

                if (saddlePoint != null) {
                    saddlePoints.add(saddlePoint);
                }
            });
        }

        return saddlePoints;
    }

    private MatrixCoordinate getRowSaddlePoint(int numRows, List<Integer> row, int indexRow, Integer candidateCol) {
        boolean isSaddle = true;
        for (int indexRowAux = 0; indexRowAux < numRows; indexRowAux++) {
            List<Integer> rowAux = this.matrix.get(indexRowAux);

            if (row.get(candidateCol) > rowAux.get(candidateCol)) {
                isSaddle = false;
                break;
            }
        }

        if (isSaddle) {
            return new MatrixCoordinate(indexRow + 1, candidateCol + 1);
        }
        return null;
    }

    private List<Integer> getColumnCandidates(int numCols, List<Integer> candidatesColumn, List<Integer> row) {
        List<Integer> currentCandidates = new ArrayList<>(candidatesColumn);

        if (row.size() > 1) {
            for (int indexCol = 1; indexCol < numCols; indexCol++) {
                if (row.get(indexCol).equals(row.get(currentCandidates.get(0)))) {
                    currentCandidates.add(indexCol);
                } else if (row.get(indexCol) > row.get(currentCandidates.get(0))) {
                    currentCandidates.clear();
                    currentCandidates.add(indexCol);
                }
            }
        }

        return currentCandidates;
    }
}
