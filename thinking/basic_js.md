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
the sum of an array of numbers
Array.prototype.reduce()
The reduce() method executes a user-supplied “reducer” callback function on each element of the array, passing in the return value from the calculation on the preceding element. The final result of running the reducer across all elements of the array is a single value.
```js
[1,2,3,4].reduce((prev, cur) => prev + cur, 0);
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
## 优先队列 / 堆
For Priority Queue / Queue data structures, you may use [datastructures-js/priority-queue](https://github.com/datastructures-js/priority-queue) and [datastructures-js/queue](https://github.com/datastructures-js/queue).

```js
// empty queue with default priority the element value itself.
const numbersQueue = new MinPriorityQueue();

// empty queue, will provide priority in .enqueue
const patientsQueue = new MinPriorityQueue();

// empty queue with priority returned from a prop of the queued object
const biddersQueue = new MaxPriorityQueue({ priority: (bid) => bid.value });
```

with comparator
The constructor also accepts a compare callback option to allow using complex comparison between queue elements. compare works similar to javascript sort callback: returning a number less or equal 0, means do not swap.
```js
const employeesQueue = new MaxPriorityQueue({
  compare: (e1, e2) => {
    if (e1.salary > e2.salary) return -1; // do not swap
    if (e1.salary < e2.salary) return 1; // swap

    // salaries are the same, compare rank
    return e1.rank < e2.rank ? 1 : -1;
  }
});
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
String to number parseInt(Value, radix)
```js
parseInt("100",10) = 100
parseInt("8",8) = NaN // 8进制里没有8
parseInt("15",8) = 13 // 8 + 5
parseInt("16",16) = 22
parseInt(" 100 ") = 100
parseInt("0x16") = 22 // 字符串0x开头默认16进制
parseFloat(" 100 ") = 100
parseFloat("2018@geeksforgeeks") = 2018
parseFloat("geeksforgeeks@2018") = NaN
parseFloat("3.14") = 3.14
parseFloat("22 7 2018") = 22
```
## Math
divide integers
```js
var y=11;
var x=4;
var quotient = Math.floor(y/x); //2
var remainder = y % x; //3
```