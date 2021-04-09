export class LinkedList {
  first = null;
  last = null;
  length = 0;

  push(value) {
    this.length++;

    if (!this.first) {
      this.first = new Node(value);
      this.last = this.first;
    } else {
      let currentNode = this.first;

      while (currentNode.next) {
        currentNode = currentNode.next;
      }

      currentNode.next = new Node(value);
      currentNode.next.previous = currentNode;
      this.last = currentNode.next;
    }
  }

  pop() {
    if (this.last) {
      this.length--;
      const lastValue = this.last.value;

      this.last = this.last.previous;
      if (this.last) {
        this.last.next = null;
      } else {
        this.first = null;
      }

      return lastValue;
    }

    return null;
  }

  shift() {
    if (this.first) {
      this.length--;
      const firstValue = this.first.value;

      this.first = this.first.next;
      if (this.first) {
        this.first.previous = null;
      } else {
        this.last = null;
      }

      return firstValue;
    }

    return null;
  }

  unshift(value) {
    this.length++;

    if (!this.last) {
      this.first = new Node(value);
      this.last = this.first;
    } else {
      let currentNode = this.last;

      while (currentNode.previous) {
        currentNode = currentNode.previous;
      }

      currentNode.previous = new Node(value);
      currentNode.previous.next = currentNode;
      this.first = currentNode.previous;
    }
  }

  delete(value) {
    let currentNode = this.first;
    while (currentNode && currentNode.value !== value) {
      currentNode = currentNode.next;
    }

    if (currentNode) {
      this.length--;

      if (currentNode.previous) {
        currentNode.previous.next = currentNode.next;
      } else {
        this.first = currentNode.next;
      }

      if (currentNode.next) {
        currentNode.next.previous = currentNode.previous;
      } else {
        this.last = currentNode.previous;
      }
    }
  }

  count() {
    return this.length;
  }
}

class Node {
  next = null;
  previous = null;
  value = null;

  constructor(value) {
    this.value = value;
  }
}