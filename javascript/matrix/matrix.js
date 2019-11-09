export class Matrix {

  constructor(matrixString) {
    this.matrix = [];
    
    matrixString.split('\n').forEach(row => 
      this.matrix.push(
        row.split(' ').map(numberString => 
          parseInt(numberString)
        )
      )
    );
  }

  get rows() {
    return this.matrix;
  }

  get columns() {
    return this.matrix[0].map((col, i) => this.matrix.map(row => row[i]));
  }
}
