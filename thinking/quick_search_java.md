#### Array
```java
  List<Integer>[] arr = new List[n];
  List<List<Integer>> arr = new ArrayList<>();
  Map<Integer, Integer>[] maps = new HashMap[n];
  String[] arr = list.toArray(new String[0]);
  int[] primitive = list.stream().mapToInt(Integer::intValue).toArray();
  Arrays.sort(arr, Collections.reverseOrder());
  Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
          return ((Integer) o2[0]).compareTo(o1[0]);
      }
  });
```
#### HashMap
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
```
#### Numbers
```java
Integer.MAX_VALUE;Integer.MIN_VALUE;
Integer.parseInt(str);Integer.valueOf(str);String.valueOf(ivar);Integer.toString(ivar2);String.format("%d",num);
Double.parseDouble(str);Double.valueOf(str);String.valueOf(dnum);Double.toString(dnum);String.format("%f", dnum);
```
```java
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```