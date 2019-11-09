export class Matrix {

  constructor(matrixString) {
    this.matrix = [];
    this.transposedMatrix = [];
    
    matrixString.split('\n').forEach(row => 
      this.matrix.push(
        row.split(' ').map(Number)
      )
    );

    this.transposedMatrix = this.matrix[0].map((col, i) => this.matrix.map(row => row[i]));
  }

  get rows() {
    return this.matrix;
  }

  get columns() {
    return this.transposedMatrix;
  }
}
