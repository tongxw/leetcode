## BlockingQueue
```java
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    Storage s = new Storage();
    
    //注意这里只能新建，同一个Thread不能多次start，内部对象会被销毁
    for (int i=0; i<3; i++) {
      new Thread(() -> {
        try {
          Thread.sleep(1000);
          s.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
      new Thread(() -> {
        try {
          s.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }
    
  }
}

class Storage {
  private BlockingQueue<String> q = new LinkedBlockingQueue<>(2);
  
  public Storage() {}
  
  public void produce() throws InterruptedException {
    int counter = new Random().nextInt();
    System.out.println("produce: " + counter);
    q.put(String.valueOf(counter));
    counter++;
  }
  
  public void consume() throws InterruptedException {
    System.out.println("consume: " + q.take());
  }
}
```
## Synchronized Queue
```java
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    Storage s = new Storage();
    
    //注意这里只能新建，同一个Thread不能多次start，内部对象会被销毁
    for (int i=0; i<3; i++) {
      new Thread(() -> {
        try {
          s.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
      new Thread(() -> {
        try {
          s.cosume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }
    
  }
}

class Storage {
  private Queue<String> q = new LinkedList<>();
  
  private int MAX = 2;
  private int counter = 0;
  
  public Storage() {}
  
  public void produce() throws InterruptedException {
    synchronized (q) {
      while (q.size() >= MAX) {
        q.wait();
      }
      
      q.offer(String.valueOf(counter));
      System.out.println("produce: " + counter);
      counter++;
      
      Thread.sleep(1000);
      q.notifyAll();
    }
  }
  
  public void cosume() throws InterruptedException {
    synchronized (q) {
      while (q.isEmpty()) {
        q.wait();
      }

      System.out.println("consume: " + q.poll());
      Thread.sleep(1000);
      q.notifyAll();
    }
  }
}
```
## Lock and Condition
``` java
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    Storage s = new Storage();
    
    //注意这里只能新建，同一个Thread不能多次start，内部对象会被销毁
    for (int i=0; i<3; i++) {
      new Thread(() -> {
        try {
          s.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
      new Thread(() -> {
        try {
          s.cosume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }
    
  }
}

class Storage {
  private Queue<String> q = new LinkedList<>();
  
  private Lock lock = new ReentrantLock();
  private Condition full = lock.newCondition();
  private Condition empty = lock.newCondition();
  
  private int MAX = 2;
  private int counter = 0;
  
  public Storage() {}
  
  public void produce() throws InterruptedException {
    lock.lock();
    try {
      while (q.size() >= MAX) {
        full.await();
      }
      
      q.offer(String.valueOf(counter));
      System.out.println("produce: " + counter);
      counter++;
      Thread.sleep(1000);
      empty.signalAll();
    } finally {
      lock.unlock();
    }
  }
  
  public void cosume() throws InterruptedException {
    lock.lock();
    try {
      while (q.isEmpty()) {
        empty.await();
      }
      
      System.out.println("consume: " + q.poll());
      Thread.sleep(1000);
      full.signalAll();
    } finally {
      lock.unlock();
    }
    
  }
}
```