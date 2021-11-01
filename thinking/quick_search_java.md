#### Array
```java
  List<Integer>[] arr = new List[n];
  List<List<Integer>> arr = new ArrayList<>();
  Map<Integer, Integer>[] maps = new HashMap[n];
  String[] arr = list.toArray(new String[0]);
  int[] primitive = list.stream().mapToInt(Integer::intValue).toArray();
  int sum =  Arrays.stream(array).sum();
  int avg = Arrays.stream(array).average().orElse(Double.NaN);
  Arrays.sort(arr, Collections.reverseOrder());
  Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
          return ((Integer) o2[0]).compareTo(o1[0]);
      }
  });
  List<Integer> list = Arrays.asList(1, 2, 3, 4);
  List<T> list = new ArrayList<>(HashSet);
  Collections.sort(List<T>, (a, b) -> {});
  Collections.reverse().swap(List<T>, i, j).fill(List<T>, T obj).min().max()
```
#### HashMap & Pair
```java
  Map<String, String> brackets = new HashMap<String, String>() {
      {
          put("(", ")");
          put("{", "}");
          put("[", "]");
      }
  };
  for (Map.Entry<String,String> entry : gfg.entrySet()); entry.getKey(); entry.getValue();
  for (String name : gfg.keySet()); for (String url : gfg.values())
  Pair<Integer, String> pair = new Pair<>(1, "One"); pair.getKey(); pair.getValue();
```
#### Queue and Deque(Stack)
```java
  Deque<String> deque = new LinkedList<String>() = new ArrayDeque<String>();
  deque.add("Element 1 (Tail)").addFirst("Element 2 (Head)").addLast("Element 3 (Tail)");
  deque.push("Element 4 (Head)").offer("Element 5 (Tail)").offerFirst("Element 6 (Head)");
  deque.removeFirst().removeLast().size();
  Queue<Integer> q = new LinkedList<>() = new ArrayDeque<>();
  pq.add(1).offer(1).peek().poll();
```
#### PriorityQueue
```java
  PriorityQueue<Integer> pQueue = new PriorityQueue<>(length, (p1, p2) -> p2 - p1);
  pQueue.add(1).offer(1).isEmpty().poll();
```
#### Strings
```java
str.replace("a", "").replaceFirst("ab", "").replaceAll("([a-z])", "");
str.length().charAt().toCharArray().valueOf().indexOf().lastIndexOf().substring();
String.value(char[]);new String(char[]);
Character.isLetter('A'); Character.isDigit('0'); Character.isWhitespace(' '); 
Character.isUpperCase('A'); Character.isLowerCase('a');
Character.toLowerCase('A'); Character.toUpperCase('a');Character.toString('x');
StringBuilder str.append("GFG").reverse().setCharAt(0, 'a').delete(1, 5).deleteCharAt(1)
String.format("%d:%02d", h, m).valueOf(data, 6, 8)/* from 0, len=8*/.valueOf(data, 0, 5); /* from 0 to 5 */
String.join(",", Arrays.asList("foo", "bar", "baz")); // "foo,bar,baz"
```
#### Numbers
```java
Integer.MAX_VALUE;Integer.MIN_VALUE;
Integer.bitCount(8) = 3
Integer.parseInt(str);Integer.valueOf(str);String.valueOf(ivar);Integer.toString(ivar2);String.format("%d",num);
Double.parseDouble(str);Double.valueOf(str);String.valueOf(dnum);Double.toString(dnum);String.format("%f", dnum);
```