import java.util.ArrayList;

public class HashMap<K, V> {
  private static class LinkedListNode<K, V> {
    public LinkedListNode<K, V> next;
    public LinkedListNode<K, V> prev;
    public K key;
    public V value;
    
    public LinkedListNode(K k, V v) {
      key = k;
      value = v;
    }
  }

  private ArrayList<LinkedListNode<K, V>> arr;
  private int capacity;

  public HashMap(int cap) {
    arr = new ArrayList<>();
    arr.ensureCapacity(cap);
    for (int i=0; i<cap; i++) {
      arr.add(null);
    }
    capacity = cap;
  }

  public void put(K key, V value) {
    int hash = getHash(key);
    LinkedListNode<K, V> node = getNode(key);
    if (node != null) {
      node.value = value;
      return;
    }

    node = new LinkedListNode(key, value);
    int hash = getHash(key);
    LinkedListNode<K, V> head = arr.get(hash);
    if (head != null) {
      node.next = head;
      head.prev = node;
    }
    arr.set(hash, node);
  }

  public V get(K key) {
    LinkedListNode<K, V> node = getNode(key);
    return node == null ? null : node.value;
  }

  public void remove(K key) {
    LinkedListNode<K, V> node = getNode(key);
    if (node == null) {
      return;
    }

    int hash = getHash(key);
    if (node.prev == null) {
      arr.get(hash) = node.next;
      return;
    }

    node.prev.next = node.next;
    if (node.next != null) {
      node.next.prev = node.prev;
    }

  }


  private LinkedListNode<K, V> getNode(K key) {
    int hash = getHash(key);
    LinkedListNode<K, V> node = arr.get(hash);
    while (node != null) {
      if (node.key.equals(key)) {
        return node;
      }
      node = node.next;
    }

    return null;
  }

  private int getHash(K key) {
    return Math.abs(key.hashCode() % capacity);
  }

}
