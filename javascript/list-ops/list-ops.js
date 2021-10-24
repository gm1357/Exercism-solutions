export class List {
  constructor(initialList = []) {
    this.values = initialList;
    this.size = null;
  }

  append({ values }) {
    this.values = [...this.values, ...values];
    this._clearSize();
    return this;
  }

  concat({ values }) {
    const flattenList = new List([...this.values]);

    for (let element of values) {
      flattenList.append(element);
    }

    return flattenList;
  }

  filter(filterFunction) {
    let filteredList = [];
    for (let element of this.values) {
      if (filterFunction(element)) {
        filteredList = [...filteredList, element];
      }
    }
    return new List(filteredList);
  }

  map(mapFunction) {
    let mapList = [];
    for (let element of this.values) {
      mapList = [...mapList, mapFunction(element)];
    }
    return new List(mapList);
  }

  length() {
    if (this.size == null) {
      this._calculateSize();
    }
    return this.size;
  }

  foldl(foldFunction, acc) {
    for (let element of this.values) {
      acc = foldFunction(acc, element);
    }
    return acc;
  }

  foldr(foldFunction, acc) {
    return this.reverse().foldl(foldFunction, acc);
  }

  reverse() {
    let reverseList = [];
    for (let element of this.values) {
      reverseList = [element, ...reverseList];
    }
    return new List(reverseList);
  }

  _clearSize() {
    this.size = null;
  }

  _calculateSize() {
    let count = 0;
    for (let _ of this.values) {
      count++;
    }
    this.size = count;
  }
}
