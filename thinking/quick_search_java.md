#### Array
```java
  List<Integer>[] arr = new List[n];
  List<List<Integer>> arr = new ArrayList<>();
  Map<Integer, Integer>[] maps = new HashMap[n];
  String[] arr = list.toArray(new String[0]);
  重要！！int[] primitive = list.stream().mapToInt(i -> i).toArray();
  int sum =  Arrays.stream(array).sum();
  int avg = Arrays.stream(array).average().orElse(Double.NaN);
  Arrays.sort(arr, Collections.reverseOrder());
  Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
          return ((Integer) o2[0]).compareTo(o1[0]);
      }
  });
  Arrays.copyOf(array, <length>=newLength).copyOfRange(array, <start>=1, <end>=4)
  List<Integer> list = Arrays.asList(1, 2, 3, 4);
  List<T> list = new ArrayList<>(HashSet);
  list.addAll(otherList)
  Collections.sort(List<T>, (a, b) -> {});
  Collections.reverse().swap(List<T>, i, j).fill(List<T>, T obj).min().max()
  List<int[]> ans.toArray(new int[ans.size()][]) = int[][]
```
#### HashMap & Pair & TreeSet
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
  [23, 25, 35, 40] treeSet.floor(26) -> 25; treeSet.ceiling(33) -> 35;
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
str.replace("a", "").replaceFirst("ab", "").replaceAll("([a-z])", "").compareTo(str2);
str.length().charAt().toCharArray().valueOf().indexOf().lastIndexOf().substring().split(" ", 2);
String.valueOf(char[]);new String(char[]);
Character.isLetter('A'); Character.isDigit('0'); Character.isWhitespace(' '); 
Character.isUpperCase('A'); Character.isLowerCase('a');
Character.toLowerCase('A'); Character.toUpperCase('a');Character.toString('x');
StringBuilder str.append("GFG").insert(0, 'c').reverse().setCharAt(0, 'a').delete(start=1, end=5).deleteCharAt(1)
String.format("%d:%02d", h, m).valueOf(data, 6, 8)/* from 0, len=8*/.valueOf(data, 0, 5); /* from 0 to 5 */
String.join(",", Arrays.asList("foo", "bar", "baz")); // "foo,bar,baz"
s.chars().filter(c -> Character.isLetterOrDigit(c)).mapToObj(c -> Character.toLowerCase((char) c)).forEach(builder::append);
```
#### Numbers
```java
Integer.MAX_VALUE;Integer.MIN_VALUE;
Integer.bitCount(8) = 3
Integer.parseInt(str);Integer.valueOf(str);String.valueOf(ivar);Integer.toString(ivar2);String.format("%d",num);
Double.parseDouble(str);Double.valueOf(str);String.valueOf(dnum);Double.toString(dnum);String.format("%f", dnum);
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
### 重载类函数
```java
map = new LinkedHashMap(capacity, DEFAULT_LOAD_FACTOR, true) {
  @Override
  protected boolean removeEldestEntry(Map.Entry eldest) {
      return size() > MAX_CACHE_SIZE;
  }
};
```
### 输入
```java
public static void main(String[] args) throws Exception {
    Scanner cin = new Scanner(System.in);
    var a = cin.nextInt();
    var b = cin.nextInt();
    System.out.println(a + b);
}
```