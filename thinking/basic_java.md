# Java
[java.util.Collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html)<br />
![](./img/collection-framework-hierarchy-in-java.jpg)

## 数组 Array
List Array
```java
  List<Integer>[] arr = new List[n];
```
List of List
```java
  List<List<Integer>> arr = new ArrayList<>();
```
HashMap Array
```java
  Map<Integer, Integer>[] maps = new HashMap[n];
```
List to Object Array
```java
  String[] arr = list.toArray(new String[0]);
```

List to int Array
```java
    int[] primitive = list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();

    System.out.println(Arrays.toString(primitive));
```

## 链表 List

## 哈希表 HashMap
TreeSet
1. TreeSet是有序的Set集合，因此支持add、remove、get等方法。
2. 和NavigableSet一样，TreeSet的导航方法大致可以区分为两类，一类时提供元素项的导航方法，返回某个元素；另一类时提供集合的导航方法，返回某个集合。
lower、floor、ceiling 和 higher 分别返回小于、小于等于、大于等于、大于给定元素的元素，如果不存在这样的元素，则返回 null。
```java
for(Iterator iter = set.iterator(); iter.hasNext(); ) { 
    iter.next();
}   
```

## 栈 Stack
Java的栈操作最好用Deque来实现。
- [为什么不推荐使用Stack？](https://blog.csdn.net/qq_44013629/article/details/106461200)<br />
  因为Vector是当初JAVA曾经写得不太行的类，所以Stack也不太行。Vector不行是因为效率不太行，很多方法都用了synchronized修饰，虽然线程安全，但是像ArrayDeque,LinkedList这些线程不安全的，在需要安全的时候也可以用Collections.synchronizedCollection()转化成线程安全的，所以Vector就没什么用处了。
- [Why should I use Deque over Stack?](https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack)

## 队列 Queue / Deque
[link](https://www.geeksforgeeks.org/deque-interface-java-example/)
| Method               | Description                                                                                                                                                                                                                      |
|----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| add(element)         | This method is used to add an element at the tail of the queue. If the Deque is capacity restricted and no space is left for insertion, it returns an IllegalStateException. The function returns true on successful insertion.  |
| addFirst(element)    | This method is used to add an element at the head of the queue. If the Deque is capacity restricted and no space is left for insertion, it returns an IllegalStateException. The function returns true on successful insertion.  |
| addLast(element)     | This method is used to add an element at the tail of the queue. If the Deque is capacity restricted and no space is left for insertion, it returns an IllegalStateException. The function returns true on successful insertion.  |
| contains()           | This method is used to check whether the queue contains the given object or not.                                                                                                                                                 |
| descendingIterator() | This method returns an iterator for the deque. The elements will be returned in order from last(tail) to first(head).                                                                                                            |
| element()            | This method is used to retrieve, but not remove, the head of the queue represented by this deque.                                                                                                                                |
| getFirst()           | This method is used to retrieve, but not remove, the first element of this deque.                                                                                                                                                |
| getLast()            | This method is used to retrieve, but not remove, the last element of this deque.                                                                                                                                                 |
| iterator()           | This method returns an iterator for the deque. The elements will be returned in order from first (head) to last (tail).                                                                                                          |
| offer(element)       | This method is used to add an element at the tail of the queue. This method is preferable to add() method since this method does not throws an exception when the capacity of the container is full since it returns false.      |
| offerFirst(element)  | This method is used to add an element at the head of the queue. This method is preferable to addFirst() method since this method does not throws an exception when the capacity of the container is full since it returns false. |
| offerLast(element)   | This method is used to add an element at the tail of the queue. This method is preferable to add() method since this method does not throws an exception when the capacity of the container is full since it returns false.      |
| peek()               | This method is used to retrieve the element at the head of the deque but doesn’t remove the element from the deque. This method returns null if the deque is empty.                                                              |
| peekFirst()          | This method is used to retrieve the element at the head of the deque but doesn’t remove the element from the deque. This method returns null if the deque is empty.                                                              |
| peekLast()           | This method is used to retrieve the element at the tail of the deque but doesn’t remove the element from the deque. This method returns null if the deque is empty.                                                              |
| poll()               | This method is used to retrieve and remove the element at the head of the deque. This method returns null if the deque is empty.                                                                                                 |
| pollFirst()          | This method is used to retrieve and remove the element at the head of the deque. This method returns null if the deque is empty.                                                                                                 |
| pollLast()           | This method is used to retrieve and remove the element at the tail of the deque. This method returns null if the deque is empty.                                                                                                 |
| pop()                | This method is used to remove an element from the head and return it.                                                                                                                                                            |
| push(element)        | This method is used to add an element at the head of the queue.                                                                                                                                                                  |
| removeFirst()        | This method is used to remove an element from the head of the queue.                                                                                                                                                             |
| removeLast()         | This method is used to remove an element from the tail of the queue.                                                                                                                                                             |
| size()               | This method is used to find and return the size of the deque.                                                                                                                                                                    |
```java
// Java program to demonstrate the
// removal of elements in deque
import java.util.*;
public class DequeExample {
    public static void main(String[] args)
    {
        Deque<String> deque = new LinkedList<String>();
  
        // We can add elements to the queue
        // in various ways
  
        // Add at the last
        deque.add("Element 1 (Tail)");
  
        // Add at the first
        deque.addFirst("Element 2 (Head)");
  
        // Add at the last
        deque.addLast("Element 3 (Tail)");
  
        // Add at the first
        deque.push("Element 4 (Head)");
  
        // Add at the last
        deque.offer("Element 5 (Tail)");
  
        // Add at the first
        deque.offerFirst("Element 6 (Head)");
  
        System.out.println(deque + "\n");
  
        // We can remove the first element
        // or the last element.
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removing "
                           + "first and last: "
                           + deque);
    }
}
```
```java
// Java program to demonstrate the
// removal of elements in deque
  
import java.util.*;
public class ArrayDequeDemo {
    public static void main(String[] args)
    {
        // Initializing an deque
        Deque<String> dq
            = new ArrayDeque<String>();
  
        // add() method to insert
        dq.add("For");
        dq.addFirst("Geeks");
        dq.addLast("Geeks");
  
        System.out.println(dq);
  
        System.out.println(dq.pop());
  
        System.out.println(dq.poll());
  
        System.out.println(dq.pollFirst());
  
        System.out.println(dq.pollLast());
    }
}
```
```java
// Java program to demonstrate the
// iteration of elements in deque
  
import java.util.*;
public class ArrayDequeDemo {
    public static void main(String[] args)
    {
        // Initializing an deque
        Deque<String> dq
            = new ArrayDeque<String>();
  
        // add() method to insert
        dq.add("For");
        dq.addFirst("Geeks");
        dq.addLast("Geeks");
        dq.add("is so good");
  
        for (Iterator itr = dq.iterator();
             itr.hasNext();) {
            System.out.print(itr.next() + " ");
        }
  
        System.out.println();
  
        for (Iterator itr = dq.descendingIterator();
             itr.hasNext();) {
            System.out.print(itr.next() + " ");
        }
    }
}
```
## 堆 / 优先队列
## 字符串操作
| Method                | Description                                                                                                          | Return Type  |
|-----------------------|----------------------------------------------------------------------------------------------------------------------|--------------|
| charAt()              | Returns the character at the specified index (position)                                                              | char         |
| codePointAt()         | Returns the Unicode of the character at the specified index                                                          | int          |
| codePointBefore()     | Returns the Unicode of the character before the specified index                                                      | int          |
| codePointCount()      | Returns the Unicode in the specified text range of this String                                                       | int          |
| compareTo()           | Compares two strings lexicographically                                                                               | int          |
| compareToIgnoreCase() | Compares two strings lexicographically, ignoring case differences                                                    | int          |
| concat()              | Appends a string to the end of another string                                                                        | String       |
| contains()            | Checks whether a string contains a sequence of characters                                                            | boolean      |
| contentEquals()       | Checks whether a string contains the exact same sequence of characters of the specified CharSequence or StringBuffer | boolean      |
| copyValueOf()         | Returns a String that represents the characters of the character array                                               | String       |
| endsWith()            | Checks whether a string ends with the specified character(s)                                                         | boolean      |
| equals()              | Compares two strings. Returns true if the strings are equal, and false if not                                        | boolean      |
| equalsIgnoreCase()    | Compares two strings, ignoring case considerations                                                                   | boolean      |
| format()              | Returns a formatted string using the specified locale, format string, and arguments                                  | String       |
| getBytes()            | Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array       | byte[]       |
| getChars()            | Copies characters from a string to an array of chars                                                                 | void         |
| hashCode()            | Returns the hash code of a string                                                                                    | int          |
| indexOf()             | Returns the position of the first found occurrence of specified characters in a string                               | int          |
| intern()              | Returns the canonical representation for the string object                                                           | String       |
| isEmpty()             | Checks whether a string is empty or not                                                                              | boolean      |
| lastIndexOf()         | Returns the position of the last found occurrence of specified characters in a string                                | int          |
| length()              | Returns the length of a specified string                                                                             | int          |
| matches()             | Searches a string for a match against a regular expression, and returns the matches                                  | boolean      |
| offsetByCodePoints()  | Returns the index within this String that is offset from the given index by codePointOffset code points              | int          |
| regionMatches()       | Tests if two string regions are equal                                                                                | boolean      |
| replace()             | Searches a string for a specified value, and returns a new string where the specified values are replaced            | String       |
| replaceFirst()        | Replaces the first occurrence of a substring that matches the given regular expression with the given replacement    | String       |
| replaceAll()          | Replaces each substring of this string that matches the given regular expression with the given replacement          | String       |
| split()               | Splits a string into an array of substrings                                                                          | String[]     |
| startsWith()          | Checks whether a string starts with specified characters                                                             | boolean      |
| subSequence()         | Returns a new character sequence that is a subsequence of this sequence                                              | CharSequence |
| substring()           | Returns a new string which is the substring of a specified string                                                    | String       |
| toCharArray()         | Converts this string to a new character array                                                                        | char[]       |
| toLowerCase()         | Converts a string to lower case letters                                                                              | String       |
| toString()            | Returns the value of a String object                                                                                 | String       |
| toUpperCase()         | Converts a string to upper case letters                                                                              | String       |
| trim()                | Removes whitespace from both ends of a string                                                                        | String       |
| valueOf()             | Returns the string representation of the specified value                                                             | String       |

Removing certain characters from a string:
1. replace(char oldChar, char newChar): Returns a string resulting from replacing all occurrences of oldChar in this string with newChar.
2. replace(CharSequence target, CharSequence replacement): Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.
```java
String str = "abcdDCBA123";
String strNew = str.replace("a", ""); // strNew is 'bcdDCBA123'
```
3. replaceFirst(String regex, String replacement): Replaces the first substring of this string that matches the given regular expression with the given replacement.
```java
String str = "abcdDCBA123";
String strNew = str.replaceFirst("ab", ""); // strNew is 'cdDCBA123'
```
4. replaceAll(String regex, String replacement): Replaces each substring of this string that matches the given regular expression with the given replacement.
```java
String str = "abcdDCBA123";
String strNew = str.replaceAll("([a-z])", ""); // strNew is 'DCBA123'
```

## 类型转换
String <-> int
```java
String str="-1234";
int inum = Integer.parseInt(str); // -1234

String str="1122ab";
int num = Integer.valueOf(str); // NumberFormatException

int ivar = 111;
String str = String.valueOf(ivar);

int ivar2 = 200;
String str2 = Integer.toString(ivar2);

int num = 99;  
String str = String.format("%d",num);
```

String <-> Double
```java
String str = "122.202";
double dnum = Double.parseDouble(str);

String str = "122.111";
double dnum = Double.valueOf(str);

String str3 = "999.333";
double var3 = new Double(str3);

double dnum = 99.9999;  
String str = String.valueOf(dnum);

double dnum = -105.556;
String str = Double.toString(dnum);

double dnum = -99.999;
String str = String.format("%f", dnum); 

double dnum = -99.999;  
String str = String.format("%.2f", dnum); // "-100.00"

double dnum = -99.999; 
DecimalFormat df = new DecimalFormat("#.000");
String str = df.format(dnum); // "-99.999"

double dnum = -66.89;
StringBuilder sb = new StringBuilder();
sb.append(dnum);
String str = sb.toString();

```