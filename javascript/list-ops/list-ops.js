export class List {
  constructor(initialList = []) {
    this.values = initialList;
    this.size = null;
  }

  append(list) {
    return new List([...this.values, ...list.values]);
  }

  concat(list) {
    return new List([
      ...this.values,
      ...list.values.reduce((previous, current) => [...previous, ...current.values], [])
    ]);
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
      let count = 0;
      for (let _ of this.values) {
        count++;
      }
      this.size = count;
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
    for (let i = this.length() - 1; i >= 0; i--) {
      acc = foldFunction(acc, this.values[i]);
    }
    return acc;
  }

  reverse() {
    let reverseList = [];
    for (let element of this.values) {
      reverseList = [element, ...reverseList];
    }
    return new List(reverseList);
  }
}
