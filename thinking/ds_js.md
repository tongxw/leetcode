# JavaScript

## 数组 Array

## 链表 List

## 哈希表 HashMap

## 栈 Stack
```js
// Stack class
class Stack {
  // Array is used to implement stack
  constructor() {
    this.items = [];
  }

  // push function
  push(element) {
    // push element into the items
    this.items.push(element);
  }

  // pop function
  pop() {
    // return top most element in the stack
    // and removes it from the stack
    // Underflow if stack is empty
    if (this.items.length == 0)
        return "Underflow";
    return this.items.pop();
  }

  // peek function
  peek() {
    // return the top most element from the stack
    // but does'nt delete it.
    return this.items[this.items.length - 1];
  }

  // isEmpty function
  isEmpty() {
    // return true if stack is empty
    return this.items.length == 0;
  }

  // printStack function
  printStack() {
    var str = "";
    for (var i = 0; i < this.items.length; i++)
        str += this.items[i] + " ";
    return str;
  }
}
```
## 队列 Queue / Deque
```js
// Queue class
class Queue
{
  // Array is used to implement a Queue
  constructor() {
    this.items = [];
  }
                
  // enqueue function
  enqueue(element) {    
    // adding element to the queue
    this.items.push(element);
  }

  dequeue() {
  // removing element from the queue
  // returns underflow when called 
  // on empty queue
  if(this.isEmpty())
    return "Underflow";
    return this.items.shift();
  }

  // front function
  front() {
    // returns the Front element of 
    // the queue without removing it.
    if(this.isEmpty())
        return "No elements in Queue";
    return this.items[0];
  }
  
  // isEmpty function
  isEmpty() {
    // return true if the queue is empty.
    return this.items.length == 0;
  }

  // printQueue function
  printQueue() {
    var str = "";
    for(var i = 0; i < this.items.length; i++)
        str += this.items[i] +" ";
    return str;
  }
}
```