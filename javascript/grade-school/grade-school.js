export class GradeSchool {
  grades = {};
  students = {};

  roster() {
    return this._deepClone(this.grades);
  }

  add(name, grade) {
    this._handleExistingName(name, grade);

    this.grades[grade] = (this.grades[grade] || []).concat(name);
    this.grades[grade] = this.grades[grade].sort();
  }

  grade(value) {
    return this.grades[value]
      ? [...this.grades[value]]
      : [];
  }

  _handleExistingName(name, grade) {
    const oldGrade = this.students[name];
    if (oldGrade) {
      this.grades[oldGrade] = this.grades[oldGrade].filter(rosterName => rosterName !== name);
    }

    this.students[name] = grade;
  }

  _deepClone(obj) {
    const copy = {}
    for (let prop of Object.keys(obj)) {
      copy[prop] = [...obj[prop]];
    }

    return copy;
  }
}
