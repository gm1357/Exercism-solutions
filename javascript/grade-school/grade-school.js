export class GradeSchool {
  gradesToNames = {};
  namesToGrades = {};

  roster() {
    return JSON.parse(JSON.stringify(this.gradesToNames));
  }

  add(name, grade) {
    this._handleExistingName(name, grade);

    if (this.gradesToNames[grade]) {
      this.gradesToNames[grade].push(name);
      this.gradesToNames[grade] = this.gradesToNames[grade].sort();
    } else {
      this.gradesToNames[grade] = [name];
    }
  }

  grade(value) {
    return this.gradesToNames[value]
      ? JSON.parse(JSON.stringify(this.gradesToNames[value]))
      : [];
  }

  _handleExistingName(name, grade) {
    const oldGrade = this.namesToGrades[name];
    if (oldGrade) {
      this.gradesToNames[oldGrade] = this.gradesToNames[oldGrade].filter(rosterName => rosterName !== name);
    }

    this.namesToGrades[name] = grade;
  }
}
