# JavaScript

## 数组 Array
concat array
```js
const a = ['a'];
const b = ['b'];
a.push(...b);
const c = a.concat(b);
```
sort array: note that js will convert the elements to string type first.
```js
['Google', 'Apple', 'Microsoft'].sort(); // ['Apple', 'Google', 'Microsoft'];
['Google', 'apple', 'Microsoft'].sort(); // ['Google', 'Microsoft", 'apple']
[10, 20, 1, 2].sort(); // [1, 10, 2, 20]
```
so, to sort numbers,
```js
arr = [10, 20, 1, 2];
arr.sort(function (x, y) {
    if (x < y) {
        return -1;
    }
    if (x > y) {
        return 1;
    }
    return 0;
});
console.log(arr); // [1, 2, 10, 20]
```
create a matrix of all 1,
```js
const arr = new Array(3);
for (let i=0; i<arr.length; i++) {
  arr[i] = new Array(4).fill(1); // Creating an array of size 4 and filled of 1
}
arr[0][0] = 10;
console.log(arr[0][0]); // 10
console.log(arr[1][0]); // 1
console.log(arr[2][0]); // 1
```

## 链表 List

## 哈希表 HashMap
The Map object holds key-value pairs and remembers the original insertion order of the keys.
```js
const map1 = new Map();

map1.set('a', 1);
map1.set('b', 2);
map1.set('c', 3);

console.log(map1.get('a'));
// expected output: 1

map1.set('a', 97);

console.log(map1.has('a'));
// expected output: true

console.log(map1.get('a'));
// expected output: 97

console.log(map1.size);
// expected output: 3

map1.delete('b');

console.log(map1.size);
// expected output: 2

for (const entry of map1) {
  console.log(entry);
}
// expected output: Array ["a", 97], Array ["c", 3]
```
How to convert Map keys to array?
Map.keys() returns a MapIterator object which can be converted to Array using Array.from or [spread syntax](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax).
```js
let myMap = new Map().set('a', 1).set('b', 2);
let keys = Array.from( myMap.keys() );
let keys =[ ...myMap.keys() ];
```

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

## 类型转换 / Type Conversion
Convert the elements of an array into a string
```js
  const fruits = ["Banana", "Orange", "Apple", "Mango"];
  console.log(fruits.join())   // Returns "Banana,Orange,Apple,Mango"
  console.log(fruits.toString())   // Returns "Banana,Orange,Apple,Mango"
```
Convert a number to a string, using different bases:
```js
var num = 15;
var a = num.toString();
var b = num.toString(2);
var c = num.toString(8);
var d = num.toString(16);
```
Split a string into an array of substrings:
```js
let str = "How are you doing today?";
const myArr = str.split(" ");
```